package com.pockyl.mekanismadvancedgenerators.block;

import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.text.ILangEntry;
import mekanism.common.block.interfaces.IHasDescription;
import mekanism.common.block.transmitter.BlockSmallTransmitter;
import mekanism.common.content.blocktype.BlockTypeTile;

import com.pockyl.mekanismadvancedgenerators.blockentity.AdvancedCableBlockEntity;
import com.pockyl.mekanismadvancedgenerators.registry.ModLang;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;

@NothingNullByDefault
public class AdvancedCableBlock extends BlockSmallTransmitter<AdvancedCableBlockEntity> implements IHasDescription {
    private final AdvancedCableTier tier;

    public AdvancedCableBlock(BlockTypeTile<AdvancedCableBlockEntity> type, AdvancedCableTier tier) {
        super(type);
        this.tier = tier;
    }

    public AdvancedCableTier getAdvancedTier() {
        return tier;
    }

    @Override
    public ILangEntry getDescription() {
        return ModLang.cableDescription(tier);
    }
}
