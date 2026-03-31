package com.pocky.solarpanels.content.cable;

import mekanism.common.block.transmitter.BlockSmallTransmitter;
import mekanism.common.content.blocktype.BlockTypeTile;

public class BlockAdvancedCable extends BlockSmallTransmitter<TileEntityAdvancedCable> {

    private final AdvancedCableTier advancedTier;

    public BlockAdvancedCable(BlockTypeTile<TileEntityAdvancedCable> type, AdvancedCableTier tier) {
        super(type);
        this.advancedTier = tier;
    }

    public AdvancedCableTier getAdvancedTier() {
        return advancedTier;
    }
}
