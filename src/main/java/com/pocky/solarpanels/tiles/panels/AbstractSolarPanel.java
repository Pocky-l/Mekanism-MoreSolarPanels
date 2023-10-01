package com.pocky.solarpanels.tiles.panels;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Dudko Roman
 */
public abstract class AbstractSolarPanel extends SPMTileEntityGenerator {

    protected boolean seesSun;
    protected FloatingLong peakOutput;
    protected FloatingLong lastProductionAmount;
    @WrappingComputerMethod(
            wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = {"getEnergyItem"}, docPlaceholder = "")
    protected EnergyInventorySlot energySlot;

    @Nullable
    protected SolarCheck solarCheck;

    protected AbstractSolarPanel(IBlockProvider blockProvider, BlockPos pos, BlockState state, @Nonnull FloatingLong output) {
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
            this.solarCheck = new SolarCheck(this.level, this.worldPosition);
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
            if (brightness < 0) return FloatingLong.ZERO;
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

    protected abstract FloatingLong getConfiguredMax();

    public FloatingLong getMaxOutput() {
        return this.peakOutput;
    }

    @ComputerMethod(nameOverride = "getProductionRate")
    public FloatingLong getLastProductionAmount() {
        return this.lastProductionAmount;
    }

    public FloatingLong getProductionRate() {
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
            needsRainCheck = b.getPrecipitationAt(this.pos) != Biome.Precipitation.NONE;
            // Consider the best temperature to be 0.8; biomes that are higher than that
            // will suffer an efficiency loss (semiconductors don't like heat); biomes that are cooler
            // get a boost. We scale the efficiency to around 30% so that it doesn't totally dominate
            float tempEff = 0.3F * (0.8F - b.getBaseTemperature());

            // Treat rainfall as a proxy for humidity; any humidity works as a drag on overall efficiency.
            // As with temperature, we scale it so that it doesn't overwhelm production. Note the signedness
            // on the scaling factor. Also note that we only use rainfall as a proxy if it CAN rain; some dimensions
            // (like the End) have rainfall set, but can't actually support rain.
            float humidityEff = needsRainCheck ? -0.3F * b.getModifiedClimateSettings().downfall() : 0;
            peakMultiplier = 1.0F + tempEff + humidityEff;
        }

        public void recheckCanSeeSun() {
            this.canSeeSun = this.world != null && world.canSeeSky(this.pos);
        }

        public boolean canSeeSun() {
            return this.canSeeSun;
        }

        public float getPeakMultiplier() {
            return this.peakMultiplier;
        }

        public float getGenerationMultiplier() {
            return !this.needsRainCheck || !this.world.isRaining() && !this.world.isThundering() ? this.peakMultiplier : this.peakMultiplier * 0.2F;
        }
    }
}
