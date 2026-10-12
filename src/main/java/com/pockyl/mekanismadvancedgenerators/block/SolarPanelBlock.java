package com.pockyl.mekanismadvancedgenerators.block;

import mekanism.common.block.prefab.BlockTile;
import net.minecraft.world.level.material.MapColor;

import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;

/**
 * A one-block solar panel.
 */
public class SolarPanelBlock extends BlockTile.BlockTileModel<SolarGeneratorBlockEntity, GeneratorBlockType<SolarGeneratorBlockEntity>> {

    public SolarPanelBlock(GeneratorBlockType<SolarGeneratorBlockEntity> type) {
        super(type, properties -> properties.mapColor(MapColor.COLOR_BLUE));
    }
}
