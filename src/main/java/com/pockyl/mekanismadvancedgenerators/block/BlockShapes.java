package com.pockyl.mekanismadvancedgenerators.block;

import mekanism.common.util.EnumUtils;
import mekanism.common.util.VoxelShapeUtils;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.minecraft.world.level.block.Block.box;

/**
 * Collision and outline shape of the big solar generators, one per horizontal facing (Mekanism's layout). The
 * one-block panels have their own shape per tier in {@link SolarPanelShapes}.
 */
public final class BlockShapes {
    /** Covers the base block, the pole and the 3x3 panel; the same model as Mekanism's Advanced Solar Generator. */
    public static final VoxelShape[] BIG_SOLAR_GENERATOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];

    static {
        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(6, -4, 6, 10, 25, 10), // pole
                box(4, 22, 2, 6, 24, 14), // tubes
                box(10, 22, 2, 12, 24, 14),
                box(4, 25, 5, 12, 31, 11), // barrel
                box(5, 24, 4, 6, 32, 12), // rings
                box(10, 24, 4, 11, 32, 12),
                box(5, -11, 1, 11, -5, 4), // connector
                box(0, -16, 0, 16, -14, 16), // base
                box(3, -14, 3, 13, -12, 13),
                box(4, -12, 4, 12, -4, 12),
                box(4, -12, 0, 12, -4, 1), // port
                box(14, 30, -16, 32, 31, 32), // east panel
                box(15, 29, -15, 31, 30, 31),
                box(12, 27, 7, 28, 29, 9),
                box(-16, 30, -16, 2, 31, 32), // west panel
                box(-15, 29, -15, 1, 30, 31),
                box(-12, 27, 7, 4, 29, 9)
        ).move(0, 1, 0), BIG_SOLAR_GENERATOR);
    }

    private BlockShapes() {
    }
}
