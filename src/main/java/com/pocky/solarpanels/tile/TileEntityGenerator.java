package com.pocky.solarpanels.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;
import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.api.math.MathUtils;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.AttributeSound;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.capabilities.holder.energy.EnergyContainerHelper;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.config.MekanismConfig;
import mekanism.common.integration.computer.annotation.ComputerMethod;
import mekanism.common.integration.energy.BlockEnergyCapabilityCache;
import mekanism.common.inventory.container.sync.ISyncableData;
import mekanism.common.inventory.container.sync.SyncableLong;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.util.CableUtils;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
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

    // Client-side sound management (Mekanism's SoundHandler filters out non-"mekanism" namespaces,
    // so we manage our own sound to ensure it starts and stops correctly)
    @Nullable
    private SoundInstance activeClientSound;
    private int clientSoundCooldown = 0;

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
        if (hasSound() && MekanismConfig.client.enableMachineSounds.get()) {
            if (getActive() && !isRemoved()) {
                if (--clientSoundCooldown <= 0) {
                    if (activeClientSound == null || !Minecraft.getInstance().getSoundManager().isActive(activeClientSound)) {
                        AttributeSound attr = Attribute.get(getBlockHolder(), AttributeSound.class);
                        if (attr != null) {
                            SoundEvent sound = attr.getSound().get();
                            BlockPos pos = getSoundPos();
                            Player player = Minecraft.getInstance().player;
                            // Only play if the player is within range (attenuation distance = 8 blocks)
                            if (player != null && player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) < 64.0) {
                                activeClientSound = new SimpleSoundInstance(
                                        sound.getLocation(),
                                        getSoundCategory(),
                                        MekanismConfig.client.baseSoundVolume.get() * getInitialVolume(),
                                        1.0F,
                                        SoundInstance.createUnseededRandom(),
                                        true,  // looping
                                        0,
                                        SoundInstance.Attenuation.LINEAR,
                                        pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                        false  // not relative to listener
                                );
                                Minecraft.getInstance().getSoundManager().play(activeClientSound);
                            }
                        }
                    }
                    clientSoundCooldown = SharedConstants.TICKS_PER_SECOND;
                }
            } else if (activeClientSound != null) {
                Minecraft.getInstance().getSoundManager().stop(activeClientSound);
                activeClientSound = null;
                clientSoundCooldown = 0;
            }
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
        if (level != null && level.isClientSide && activeClientSound != null) {
            Minecraft.getInstance().getSoundManager().stop(activeClientSound);
            activeClientSound = null;
            clientSoundCooldown = 0;
        }
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
