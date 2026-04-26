package com.pocky.solarpanels.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.LongSupplier;
import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.api.math.MathUtils;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.capabilities.holder.energy.EnergyContainerHelper;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.integration.computer.annotation.ComputerMethod;
import mekanism.common.integration.energy.BlockEnergyCapabilityCache;
import mekanism.common.inventory.container.sync.ISyncableData;
import mekanism.common.inventory.container.sync.SyncableLong;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.util.CableUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TileEntityGenerator extends TileEntityMekanism {

    private static final RelativeSide[] ENERGY_SIDES = {RelativeSide.FRONT};

    @Nullable
    private List<BlockEnergyCapabilityCache> outputCaches;
    private long maxOutput;
    private BasicEnergyContainer energyContainer;

    // Registered by GeneratorClientSoundManager on Dist.CLIENT — null on the server
    private static Consumer<TileEntityGenerator> clientTickCallback;
    private static Consumer<TileEntityGenerator> clientStopCallback;

    public static void setClientCallbacks(Consumer<TileEntityGenerator> tick, Consumer<TileEntityGenerator> stop) {
        clientTickCallback = tick;
        clientStopCallback = stop;
    }

    public TileEntityGenerator(Holder<Block> blockProvider, BlockPos pos, BlockState state, @NotNull LongSupplier maxOutput) {
        super(blockProvider, pos, state);
        updateMaxOutputRaw(maxOutput.getAsLong());
    }

    protected RelativeSide[] getEnergySides() {
        return ENERGY_SIDES;
    }

    @NotNull
    @Override
    protected IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener) {
        EnergyContainerHelper builder = EnergyContainerHelper.forSide(facingSupplier);
        builder.addContainer(energyContainer = BasicEnergyContainer.output(MachineEnergyContainer.validateBlock(this).getStorage(), listener), getEnergySides());
        return builder.build();
    }

    @Override
    protected boolean onUpdateServer() {
        boolean sendUpdatePacket = super.onUpdateServer();
        if (canFunction()) {
            if (outputCaches == null) {
                Direction direction = getDirection();
                RelativeSide[] energySides = getEnergySides();
                outputCaches = new ArrayList<>(energySides.length);
                for (RelativeSide energySide : energySides) {
                    Direction side = energySide.getDirection(direction);
                    outputCaches.add(BlockEnergyCapabilityCache.create((ServerLevel) level, worldPosition.relative(side), side.getOpposite()));
                }
            }
            CableUtils.emit(outputCaches, energyContainer, getMaxOutput());
        }
        return sendUpdatePacket;
    }

    // Disable Mekanism's built-in sound management — it filters out namespaces that don't start
    // with "mekanism", which means our sounds would start but never stop.
    @Override
    protected boolean canPlaySound() {
        return false;
    }

    @Override
    protected void onUpdateClient() {
        if (clientTickCallback != null) {
            clientTickCallback.accept(this);
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        stopClientSound();
    }

    @Override
    public void onChunkUnloaded() {
        super.onChunkUnloaded();
        stopClientSound();
    }

    private void stopClientSound() {
        if (level != null && level.isClientSide && clientStopCallback != null) {
            clientStopCallback.accept(this);
        }
    }

    // Public accessors used by GeneratorClientSoundManager (client-only class)
    public BlockPos getGeneratorSoundPos() {
        return getSoundPos();
    }

    public SoundSource getGeneratorSoundCategory() {
        return getSoundCategory();
    }

    public float getGeneratorInitialVolume() {
        return getInitialVolume();
    }

    @Override
    protected void invalidateDirectionCaches(Direction newDirection) {
        super.invalidateDirectionCaches(newDirection);
        outputCaches = null;
    }

    @ComputerMethod
    public long getMaxOutput() {
        return maxOutput;
    }

    protected void updateMaxOutputRaw(long maxOutput) {
        this.maxOutput = MathUtils.multiplyClamped(maxOutput, 2);
    }

    protected ISyncableData syncableMaxOutput() {
        return SyncableLong.create(this::getMaxOutput, value -> maxOutput = value);
    }

    public BasicEnergyContainer getEnergyContainer() {
        return energyContainer;
    }

    @ComputerMethod(methodDescription = "Get the amount of energy produced by this generator in the last tick.")
    abstract long getProductionRate();
}
