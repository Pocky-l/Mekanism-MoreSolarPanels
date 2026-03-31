package com.pocky.solarpanels.content.cable;

import mekanism.common.content.network.transmitter.UniversalCable;
import mekanism.common.tile.transmitter.TileEntityUniversalCable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TileEntityAdvancedCable extends TileEntityUniversalCable {

    public TileEntityAdvancedCable(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @Override
    protected UniversalCable createTransmitter(Holder<Block> blockProvider) {
        AdvancedCableTier tier = ((BlockAdvancedCable) blockProvider.value()).getAdvancedTier();
        return new AdvancedUniversalCable(blockProvider, this, tier.getCapacity());
    }
}
