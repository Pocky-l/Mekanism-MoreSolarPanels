package com.pocky.solarpanels.tiles.panels;

import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.api.math.FloatingLong;
import mekanism.api.math.FloatingLongSupplier;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.capabilities.holder.energy.EnergyContainerHelper;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.capabilities.resolver.BasicCapabilityResolver;
import mekanism.common.integration.computer.annotation.ComputerMethod;
import mekanism.common.inventory.container.sync.ISyncableData;
import mekanism.common.inventory.container.sync.SyncableFloatingLong;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.util.CableUtils;
import mekanism.common.util.MekanismUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.Set;

public abstract class SPMTileEntityGenerator extends TileEntityMekanism {
    private FloatingLong maxOutput;
    private BasicEnergyContainer energyContainer;

    public SPMTileEntityGenerator(IBlockProvider blockProvider, BlockPos pos, BlockState state, @NotNull FloatingLongSupplier maxOutput) {
        super(blockProvider, pos, state);
        this.updateMaxOutputRaw(maxOutput.get());
        this.addCapabilityResolver(BasicCapabilityResolver.constant(Capabilities.CONFIG_CARD, this));
    }

    protected RelativeSide[] getEnergySides() {
        return new RelativeSide[]{RelativeSide.FRONT};
    }

    protected @NotNull IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener) {
        EnergyContainerHelper builder = EnergyContainerHelper.forSide(this::getDirection);
        builder.addContainer(this.energyContainer = BasicEnergyContainer.output(MachineEnergyContainer.validateBlock(this).getStorage(), listener), this.getEnergySides());
        return builder.build();
    }

    protected void onUpdateServer() {
        super.onUpdateServer();
        if (MekanismUtils.canFunction(this)) {
            Set<Direction> emitDirections = EnumSet.noneOf(Direction.class);
            Direction direction = this.getDirection();
            RelativeSide[] var3 = this.getEnergySides();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                RelativeSide energySide = var3[var5];
                emitDirections.add(energySide.getDirection(direction));
            }

            CableUtils.emit(emitDirections, this.energyContainer, this, this.getMaxOutput());
        }

    }

    @ComputerMethod
    public FloatingLong getMaxOutput() {
        return this.maxOutput;
    }

    protected void updateMaxOutputRaw(FloatingLong maxOutput) {
        this.maxOutput = maxOutput.multiply(2L);
    }

    protected ISyncableData syncableMaxOutput() {
        return SyncableFloatingLong.create(this::getMaxOutput, (value) -> {
            this.maxOutput = value;
        });
    }

    public BasicEnergyContainer getEnergyContainer() {
        return this.energyContainer;
    }

    @ComputerMethod(
            methodDescription = "Get the amount of energy produced by this generator in the last tick."
    )
    abstract FloatingLong getProductionRate();
}
