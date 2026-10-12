package com.pockyl.mekanismadvancedgenerators.block;

import mekanism.api.text.ILangEntry;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

import java.util.function.Supplier;

/**
 * Mekanism block type of a generator: facing, active light, security, redstone and comparator support, like Mekanism
 * Generators' own generator type (which is not part of its API).
 */
public class GeneratorBlockType<TILE extends TileEntityMekanism> extends BlockTypeTile<TILE> {

    public GeneratorBlockType(Supplier<TileEntityTypeRegistryObject<TILE>> tileType, ILangEntry description) {
        super(tileType, description);
        add(Attributes.ACTIVE_LIGHT, new AttributeStateFacing(), Attributes.SECURITY, Attributes.INVENTORY, Attributes.REDSTONE,
                Attributes.COMPARATOR);
    }

    public static final class Builder<TILE extends TileEntityMekanism>
            extends BlockTileBuilder<GeneratorBlockType<TILE>, TILE, Builder<TILE>> {

        private Builder(GeneratorBlockType<TILE> holder) {
            super(holder);
        }

        public static <TILE extends TileEntityMekanism> Builder<TILE> create(Supplier<TileEntityTypeRegistryObject<TILE>> tileType,
                ILangEntry description) {
            return new Builder<>(new GeneratorBlockType<>(tileType, description));
        }
    }
}
