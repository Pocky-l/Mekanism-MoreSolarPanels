package com.pockyl.mekanismadvancedgenerators.blockentity;

import mekanism.common.content.network.transmitter.UniversalCable;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import mekanism.common.tile.transmitter.TileEntityUniversalCable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import com.pockyl.mekanismadvancedgenerators.block.AdvancedCableBlock;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;

/**
 * A Mekanism Universal Cable whose transfer capacity comes from an {@link AdvancedCableTier}. It joins the same energy
 * networks as Mekanism's cables.
 */
public class AdvancedCableBlockEntity extends TileEntityUniversalCable {

    public AdvancedCableBlockEntity(Holder<Block> block, BlockPos pos, BlockState state) {
        super(block, pos, state);
    }

    @Override
    protected UniversalCable createTransmitter(Holder<Block> block) {
        return new Transmitter(block, this);
    }

    public AdvancedCableTier getAdvancedTier() {
        return tierOf(this);
    }

    private static AdvancedCableTier tierOf(TileEntityTransmitter tile) {
        return ((AdvancedCableBlock) tile.getBlockState().getBlock()).getAdvancedTier();
    }

    /**
     * The cable's part of the energy network. {@link UniversalCable} sizes its buffer from {@link #getCapacity()} inside
     * its constructor, so the capacity is read from the block state, which the block entity already has at that point.
     */
    private static final class Transmitter extends UniversalCable {

        Transmitter(Holder<Block> block, TileEntityTransmitter tile) {
            super(block, tile);
        }

        @Override
        public long getCapacity() {
            return tierOf(getTransmitterTile()).capacity();
        }
    }
}
