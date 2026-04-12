package com.pocky.solarpanels.content.cable;

import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.text.ILangEntry;
import mekanism.common.block.interfaces.IHasDescription;
import mekanism.common.block.transmitter.BlockSmallTransmitter;
import mekanism.common.content.blocktype.BlockTypeTile;

@NothingNullByDefault
public class BlockAdvancedCable extends BlockSmallTransmitter<TileEntityAdvancedCable> implements IHasDescription {

    private final AdvancedCableTier advancedTier;

    public BlockAdvancedCable(BlockTypeTile<TileEntityAdvancedCable> type, AdvancedCableTier tier) {
        super(type);
        this.advancedTier = tier;
    }

    public AdvancedCableTier getAdvancedTier() {
        return advancedTier;
    }

    @Override
    public ILangEntry getDescription() {
        return advancedTier.getDescription();
    }
}
