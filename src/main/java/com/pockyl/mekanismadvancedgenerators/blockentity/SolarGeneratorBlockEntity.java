package com.pockyl.mekanismadvancedgenerators.blockentity;

import mekanism.api.Action;
import mekanism.api.AutomationType;
import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.api.math.MathUtils;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.capabilities.holder.energy.EnergyContainerHelper;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.capabilities.holder.slot.IInventorySlotHolder;
import mekanism.common.capabilities.holder.slot.InventorySlotHelper;
import mekanism.common.integration.energy.BlockEnergyCapabilityCache;
import mekanism.common.inventory.container.MekanismContainer;
import mekanism.common.inventory.container.sync.SyncableBoolean;
import mekanism.common.inventory.container.sync.SyncableLong;
import mekanism.common.inventory.slot.EnergyInventorySlot;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.util.CableUtils;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;
import com.pockyl.mekanismadvancedgenerators.tier.SolarAttribute;
import com.pockyl.mekanismadvancedgenerators.tier.SolarSize;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * A one-block solar panel of any tier: works like Mekanism's Solar Generator (biome, rain and sky checks), outputs
 * downwards and charges an item in its slot. The tier comes from the block's {@link SolarAttribute}.
 */
public class SolarGeneratorBlockEntity extends TileEntityMekanism {
    private static final RelativeSide[] ENERGY_SIDES = {RelativeSide.BOTTOM};

    // Set by the client sound manager; stay null on a dedicated server.
    private static Consumer<SolarGeneratorBlockEntity> clientTickHandler;
    private static Consumer<SolarGeneratorBlockEntity> clientRemoveHandler;

    private SolarTier tier;
    private SolarSize size;
    private BasicEnergyContainer energyContainer;
    private EnergyInventorySlot energySlot;
    @Nullable
    private List<BlockEnergyCapabilityCache> outputCaches;
    @Nullable
    protected SolarCheck solarCheck;
    private long maxOutput;
    private boolean seesSun;
    private long lastProduction;

    public SolarGeneratorBlockEntity(Holder<Block> block, BlockPos pos, BlockState state) {
        super(block, pos, state);
        setMaxOutput(configuredGeneration());
    }

    public static void setClientHandlers(Consumer<SolarGeneratorBlockEntity> tick, Consumer<SolarGeneratorBlockEntity> remove) {
        clientTickHandler = tick;
        clientRemoveHandler = remove;
    }

    @Override
    protected void presetVariables() {
        super.presetVariables();
        SolarAttribute attribute = Attribute.getOrThrow(getBlockHolder(), SolarAttribute.class);
        tier = attribute.tier();
        size = attribute.size();
    }

    public SolarTier getTier() {
        return tier;
    }

    public SolarSize getSize() {
        return size;
    }

    @NotNull
    @Override
    protected IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener) {
        EnergyContainerHelper builder = EnergyContainerHelper.forSide(facingSupplier);
        energyContainer = BasicEnergyContainer.output(MachineEnergyContainer.validateBlock(this).getStorage(), listener);
        builder.addContainer(energyContainer, getEnergySides());
        return builder.build();
    }

    @NotNull
    @Override
    protected IInventorySlotHolder getInitialInventory(IContentsListener listener) {
        InventorySlotHelper builder = InventorySlotHelper.forSide(facingSupplier);
        builder.addSlot(energySlot = EnergyInventorySlot.drain(energyContainer, listener, 143, 35));
        return builder.build();
    }

    /** Sides that output energy, relative to the block's facing. */
    protected RelativeSide[] getEnergySides() {
        return ENERGY_SIDES;
    }

    @Override
    protected boolean onUpdateServer() {
        boolean sendUpdatePacket = super.onUpdateServer();
        if (solarCheck == null) {
            recheckSettings();
        }
        energySlot.drainContainer();
        seesSun = checkCanSeeSun();
        if (seesSun && canFunction() && energyContainer.getNeeded() > 0L) {
            setActive(true);
            long production = getProduction();
            lastProduction = production - energyContainer.insert(production, Action.EXECUTE, AutomationType.INTERNAL);
        } else {
            setActive(false);
            lastProduction = 0L;
        }
        if (canFunction()) {
            CableUtils.emit(getOutputCaches(), energyContainer, maxOutput);
        }
        return sendUpdatePacket;
    }

    private List<BlockEnergyCapabilityCache> getOutputCaches() {
        if (outputCaches == null) {
            Direction facing = getDirection();
            outputCaches = new ArrayList<>();
            for (RelativeSide energySide : getEnergySides()) {
                Direction side = energySide.getDirection(facing);
                outputCaches.add(BlockEnergyCapabilityCache.create((ServerLevel) level, worldPosition.relative(side), side.getOpposite()));
            }
        }
        return outputCaches;
    }

    @Override
    protected void invalidateDirectionCaches(Direction newDirection) {
        super.invalidateDirectionCaches(newDirection);
        outputCaches = null;
    }

    /** Called once the level is known: sets up the sky check and the biome-dependent peak output. */
    protected void recheckSettings() {
        if (level == null) {
            return;
        }
        solarCheck = new SolarCheck(level, worldPosition);
        setMaxOutput(MathUtils.clampToLong(configuredGeneration() * solarCheck.getPeakMultiplier()));
    }

    protected boolean checkCanSeeSun() {
        if (solarCheck == null) {
            return false;
        }
        solarCheck.recheckCanSeeSun();
        return solarCheck.canSeeSun();
    }

    /** Energy produced this tick, before it is stored. */
    protected long getProduction() {
        if (level == null || solarCheck == null) {
            return 0L;
        }
        return MathUtils.clampToLong(configuredGeneration() * (getSunBrightness(level) * solarCheck.getGenerationMultiplier()));
    }

    protected static float getSunBrightness(Level level) {
        return WorldUtils.getSunBrightness(level, 1.0F);
    }

    protected long configuredGeneration() {
        return ModConfigs.GENERATION.generation(tier, size).getOrDefault();
    }

    /** The output rate is twice the peak generation, like Mekanism's own generators. */
    protected void setMaxOutput(long peakGeneration) {
        maxOutput = MathUtils.multiplyClamped(peakGeneration, 2);
    }

    public long getMaxOutput() {
        return maxOutput;
    }

    public boolean canSeeSun() {
        return seesSun;
    }

    /** Energy stored during the last tick, in J. */
    public long getProductionRate() {
        return lastProduction;
    }

    public BasicEnergyContainer getEnergyContainer() {
        return energyContainer;
    }

    @Override
    public void addContainerTrackers(MekanismContainer container) {
        super.addContainerTrackers(container);
        container.track(SyncableBoolean.create(this::canSeeSun, value -> seesSun = value));
        container.track(SyncableLong.create(this::getMaxOutput, value -> maxOutput = value));
        container.track(SyncableLong.create(this::getProductionRate, value -> lastProduction = value));
    }

    // Mekanism's own machine sound handling only plays sounds of the "mekanism*" namespaces: ours would start but never
    // stop. The client sound manager plays the solar hum instead.
    @Override
    protected boolean canPlaySound() {
        return false;
    }

    @Override
    protected void onUpdateClient() {
        super.onUpdateClient();
        if (clientTickHandler != null) {
            clientTickHandler.accept(this);
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        onClientRemoved();
    }

    @Override
    public void onChunkUnloaded() {
        super.onChunkUnloaded();
        onClientRemoved();
    }

    private void onClientRemoved() {
        if (level != null && level.isClientSide && clientRemoveHandler != null) {
            clientRemoveHandler.accept(this);
        }
    }

    public BlockPos getHumPosition() {
        return getSoundPos();
    }

    public SoundSource getHumCategory() {
        return getSoundCategory();
    }

    public float getHumVolume() {
        return getInitialVolume();
    }

    /**
     * Sky and weather check of one position, the same rules as Mekanism's Solar Generator: hot, dry biomes raise the
     * peak, rain cuts generation to 20% in biomes where it rains.
     */
    protected static class SolarCheck {
        protected final Level level;
        protected final BlockPos pos;
        private final boolean needsRainCheck;
        private final float peakMultiplier;
        protected boolean canSeeSun;

        SolarCheck(Level level, BlockPos pos) {
            this.level = level;
            this.pos = pos;
            Biome biome = level.getBiomeManager().getBiome(pos).value();
            needsRainCheck = biome.getPrecipitationAt(pos) != Biome.Precipitation.NONE;
            float temperatureEffect = 0.3F * (0.8F - biome.getBaseTemperature());
            float humidityEffect = needsRainCheck ? -0.3F * biome.getModifiedClimateSettings().downfall() : 0.0F;
            peakMultiplier = 1.0F + temperatureEffect + humidityEffect;
        }

        void recheckCanSeeSun() {
            canSeeSun = WorldUtils.canSeeSun(level, pos);
        }

        boolean canSeeSun() {
            return canSeeSun;
        }

        float getPeakMultiplier() {
            return peakMultiplier;
        }

        float getGenerationMultiplier() {
            if (!canSeeSun) {
                return 0.0F;
            }
            if (needsRainCheck && (level.isRaining() || level.isThundering())) {
                return peakMultiplier * 0.2F;
            }
            return peakMultiplier;
        }
    }
}
