package com.pockyl.mekanismadvancedgenerators.block;

import mekanism.common.block.prefab.BlockTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.pockyl.mekanismadvancedgenerators.blockentity.BigSolarGeneratorBlockEntity;

import java.util.function.UnaryOperator;

/**
 * The base block of a big solar generator. Its pole and 3x3 panel are Mekanism bounding blocks, so placing fails unless
 * the block above and the 3x3 area two blocks above are free.
 */
public class BigSolarGeneratorBlock
        extends BlockTile.BlockTileModel<BigSolarGeneratorBlockEntity, GeneratorBlockType<BigSolarGeneratorBlockEntity>> {

    public BigSolarGeneratorBlock(GeneratorBlockType<BigSolarGeneratorBlockEntity> type,
            UnaryOperator<BlockBehaviour.Properties> properties) {
        super(type, properties);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) {
            return null;
        }
        BlockPos pos = context.getClickedPos();
        BlockGetter level = context.getLevel();
        if (!isFree(level, pos.above())) {
            return null;
        }
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (!isFree(level, pos.offset(x, 2, z))) {
                    return null;
                }
            }
        }
        return state;
    }

    private static boolean isFree(BlockGetter level, BlockPos pos) {
        return level.getBlockState(pos).canBeReplaced();
    }
}
