package com.pocky.solarpanels.content.block;

import com.pocky.solarpanels.content.blocktype.Generator;
import mekanism.common.block.prefab.BlockTile;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.UnaryOperator;

public class BlockBigSolarGenerator<TILE extends TileEntityMekanism, TYPE extends Generator<TILE>> extends BlockTile.BlockTileModel<TILE, TYPE> {

    public BlockBigSolarGenerator(TYPE type, UnaryOperator<BlockBehaviour.Properties> propertiesModifier) {
        super(type, propertiesModifier);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) return null;
        BlockPos pos = context.getClickedPos();
        BlockGetter world = context.getLevel();
        if (!isClear(world, pos.above())) return null;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (!isClear(world, pos.offset(x, 2, z))) return null;
            }
        }
        return state;
    }

    private static boolean isClear(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.isAir() || state.canBeReplaced();
    }
}
