package su.gamepoint.solarpanels.tiles.panels;

import mekanism.api.Action;
import mekanism.api.AutomationType;
import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.api.math.FloatingLong;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.capabilities.holder.slot.IInventorySlotHolder;
import mekanism.common.capabilities.holder.slot.InventorySlotHelper;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.ComputerMethod;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.inventory.container.MekanismContainer;
import mekanism.common.inventory.container.sync.SyncableBoolean;
import mekanism.common.inventory.container.sync.SyncableFloatingLong;
import mekanism.common.inventory.slot.EnergyInventorySlot;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.WorldUtils;
import mekanism.generators.common.tile.TileEntityGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import su.gamepoint.solarpanels.SolarPanelsMod;
import su.gamepoint.solarpanels.registers.BlockRegister;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Dudko Roman
 */
public class CreativeSolarPanelTile extends TileEntityGenerator {

    private boolean seesSun;
    protected FloatingLong peakOutput;
    private FloatingLong lastProductionAmount;
    @WrappingComputerMethod(
            wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class,
            methodNames = {"getEnergyItem"}
    )
    private EnergyInventorySlot energySlot;
    @Nullable
    protected CreativeSolarPanelTile.SolarCheck solarCheck;

    public CreativeSolarPanelTile(BlockPos pos, BlockState state) {
        this(BlockRegister.CREATIVE_SOLAR_PANEL, pos, state, SolarPanelsMod.getConfig().creativeSolarPanel.get().multiply(2L));
    }

    protected CreativeSolarPanelTile(IBlockProvider blockProvider, BlockPos pos, BlockState state, @Nonnull FloatingLong output) {
        super(blockProvider, pos, state, () -> output);
        this.peakOutput = FloatingLong.ZERO;
        this.lastProductionAmount = FloatingLong.ZERO;
    }

    @Nonnull
    protected IInventorySlotHolder getInitialInventory(IContentsListener listener) {
        InventorySlotHelper builder = InventorySlotHelper.forSide(this::getDirection);
        builder.addSlot(this.energySlot = EnergyInventorySlot.drain(this.getEnergyContainer(), listener, 143, 35));
        return builder.build();
    }

    @ComputerMethod
    public boolean canSeeSun() {
        return this.seesSun;
    }

    protected void onUpdateServer() {
        super.onUpdateServer();
        if (this.solarCheck == null) {
            this.recheckSettings();
        }

        this.energySlot.drainContainer();
        this.seesSun = this.checkCanSeeSun();
        if (this.seesSun && MekanismUtils.canFunction(this) && !this.getEnergyContainer().getNeeded().isZero()) {
            this.setActive(true);
            FloatingLong production = this.getProduction();
            this.lastProductionAmount = production.subtract(this.getEnergyContainer().insert(production, Action.EXECUTE, AutomationType.INTERNAL));
        } else {
            this.setActive(false);
            this.lastProductionAmount = FloatingLong.ZERO;
        }

    }

    protected void recheckSettings() {
        if (this.level != null) {
            this.solarCheck = new CreativeSolarPanelTile.SolarCheck(this.level, this.worldPosition);
            this.peakOutput = this.getConfiguredMax().multiply(this.solarCheck.getPeakMultiplier());
        }
    }

    protected boolean checkCanSeeSun() {
        if (this.solarCheck == null) {
            return false;
        } else {
            this.solarCheck.recheckCanSeeSun();
            return this.solarCheck.canSeeSun();
        }
    }

    public FloatingLong getProduction() {
        if (this.level != null && this.solarCheck != null) {
            float brightness = this.getBrightnessMultiplier(this.level);
            return this.getConfiguredMax().multiply(brightness * this.solarCheck.getGenerationMultiplier());
        } else {
            return FloatingLong.ZERO;
        }
    }

    protected float getBrightnessMultiplier(@Nonnull Level world) {
        return WorldUtils.getSunBrightness(world, 1.0F);
    }

    protected RelativeSide[] getEnergySides() {
        return new RelativeSide[]{RelativeSide.BOTTOM};
    }

    protected FloatingLong getConfiguredMax() {
        return SolarPanelsMod.getConfig().creativeSolarPanel.get();
    }

    public FloatingLong getMaxOutput() {
        return this.peakOutput;
    }

    @ComputerMethod(
            nameOverride = "getProductionRate"
    )
    public FloatingLong getLastProductionAmount() {
        return this.lastProductionAmount;
    }

    public void addContainerTrackers(MekanismContainer container) {
        super.addContainerTrackers(container);
        container.track(SyncableBoolean.create(this::canSeeSun, (value) -> {
            this.seesSun = value;
        }));
        container.track(SyncableFloatingLong.create(this::getMaxOutput, (value) -> {
            this.peakOutput = value;
        }));
        container.track(SyncableFloatingLong.create(this::getLastProductionAmount, (value) -> {
            this.lastProductionAmount = value;
        }));
    }

    protected static class SolarCheck {
        private final boolean needsRainCheck;
        private final float peakMultiplier;
        protected final BlockPos pos;
        protected final Level world;
        protected boolean canSeeSun;

        public SolarCheck(Level world, BlockPos pos) {
            this.world = world;
            this.pos = pos;
            Biome b = this.world.getBiomeManager().getBiome(this.pos).value();
            this.needsRainCheck = b.getPrecipitation() != Biome.Precipitation.NONE;
            float tempEff = 0.3F * (0.8F - b.getBaseTemperature());
            float humidityEff = this.needsRainCheck ? -0.3F * b.getDownfall() : 0.0F;
            this.peakMultiplier = 1.0F + tempEff + humidityEff;
        }

        public void recheckCanSeeSun() {
            this.canSeeSun = WorldUtils.canSeeSun(this.world, this.pos);
        }

        public boolean canSeeSun() {
            return this.canSeeSun;
        }

        public float getPeakMultiplier() {
            return this.peakMultiplier;
        }

        public float getGenerationMultiplier() {
            if (!this.canSeeSun) {
                return 0.0F;
            } else {
                return !this.needsRainCheck || !this.world.isRaining() && !this.world.isThundering() ? this.peakMultiplier : this.peakMultiplier * 0.2F;
            }
        }
    }
}
