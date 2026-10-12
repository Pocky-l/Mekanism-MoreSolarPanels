package com.pockyl.mekanismadvancedgenerators.block;

import mekanism.common.util.VoxelShapeUtils;
import net.minecraft.world.phys.shapes.VoxelShape;

import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.EnumMap;
import java.util.Map;

import static net.minecraft.world.level.block.Block.box;

/**
 * Hitboxes of the one-block solar panels, one per tier, generated from the block models by
 * {@code tools/model-gen/mekanismadvancedgenerators_shapes.py} in the workspace. Do not edit by hand: change the
 * model and run the script again.
 */
public final class SolarPanelShapes {
    private static final Map<SolarTier, VoxelShape> SHAPES = new EnumMap<>(SolarTier.class);

    static {
        SHAPES.put(SolarTier.ADVANCED, VoxelShapeUtils.combine(
                box(0, 6, 0, 16, 8, 16),
                box(3, 0, 3, 13, 1, 13),
                box(6, 4, 6, 10, 5, 10),
                box(7, 2, 7, 9, 4, 9),
                box(4, 1, 11, 5, 5, 12),
                box(5, 2, 10, 6, 5, 11),
                box(10, 2, 10, 11, 5, 11),
                box(5, 2, 5, 6, 5, 6),
                box(10, 2, 5, 11, 5, 6),
                box(11, 1, 11, 12, 5, 12),
                box(4, 1, 4, 5, 5, 5),
                box(11, 1, 4, 12, 5, 5),
                box(5, 1, 5, 11, 2, 11),
                box(1, 5, 1, 15, 6, 15)
        ));
        SHAPES.put(SolarTier.HYBRID, VoxelShapeUtils.combine(
                box(0, 6, 0, 16, 8, 16),
                box(3, 0, 3, 13, 1, 13),
                box(6, 4, 6, 10, 6, 10),
                box(7, 2, 7, 9, 4, 9),
                box(4, 1, 11, 5, 5, 12),
                box(5, 2, 10, 6, 5, 11),
                box(10, 2, 10, 11, 5, 11),
                box(10, 2, 5, 11, 5, 6),
                box(5, 2, 5, 6, 5, 6),
                box(11, 1, 11, 12, 5, 12),
                box(4, 1, 4, 5, 5, 5),
                box(11, 1, 4, 12, 5, 5),
                box(5, 1, 5, 11, 2, 11),
                box(1, 5, 1, 15, 6, 15)
        ));
        SHAPES.put(SolarTier.ULTIMATE, VoxelShapeUtils.combine(
                box(0.5, 7.5, 0.5, 15.5, 8.5, 15.5),
                box(1, 7, 15, 15, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(0, 7, 0, 1, 9, 16),
                box(3, 1, 3, 13, 2, 13),
                box(2, 0, 2, 14, 1, 14),
                box(6, 5, 6, 10, 7, 10),
                box(6.5, 3, 6.5, 9.5, 5, 9.5),
                box(4, 2, 4, 6, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(10, 2, 4, 12, 6, 6),
                box(5, 2, 5, 11, 3, 11),
                box(1, 6, 1, 15, 7, 15)
        ));
        SHAPES.put(SolarTier.QUANTUM, VoxelShapeUtils.combine(
                box(0.5, 7.5, 0.5, 15.5, 8.5, 15.5),
                box(1, 7, 15, 15, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(0, 7, 0, 1, 9, 16),
                box(3, 1, 3, 13, 2, 13),
                box(2, 0, 2, 14, 1, 14),
                box(4, 2, 4, 6, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(10, 2, 4, 12, 6, 6),
                box(5, 2, 5, 11, 6, 11),
                box(1, 6, 1, 15, 7, 15)
        ));
        SHAPES.put(SolarTier.SPECTRAL, VoxelShapeUtils.combine(
                box(0.5, 7.5, 0.5, 15.5, 8.5, 15.5),
                box(1, 7, 15, 15, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(0, 7, 0, 1, 9, 16),
                box(3, 1, 3, 13, 2, 13),
                box(2, 0, 2, 14, 1, 14),
                box(4, 2, 4, 6, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(10, 2, 4, 12, 6, 6),
                box(5, 2, 5, 11, 6, 11),
                box(1, 6, 1, 15, 7, 15)
        ));
        SHAPES.put(SolarTier.SINGULAR, VoxelShapeUtils.combine(
                box(0.5, 7.5, 0.5, 15.5, 8.5, 15.5),
                box(3, 1, 3, 13, 2, 13),
                box(1.75, 0, 1.75, 14.25, 1.5, 14.25),
                box(1.5, 0.75, 1.5, 4.5, 2.25, 4.5),
                box(11.5, 0.75, 1.5, 14.5, 2.25, 4.5),
                box(11.5, 0.75, 11.5, 14.5, 2.25, 14.5),
                box(1.5, 0.75, 11.5, 4.5, 2.25, 14.5),
                box(1, 0, 11, 5, 1, 15),
                box(11, 0, 11, 15, 1, 15),
                box(11, 0, 1, 15, 1, 5),
                box(1, 0, 1, 5, 1, 5),
                box(4, 2, 4, 6, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(10, 2, 4, 12, 6, 6),
                box(5, 2, 5, 11, 6, 11),
                box(1, 6, 1, 15, 7, 15),
                box(0, 7, 0, 1, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 15, 15, 9, 16)
        ));
        SHAPES.put(SolarTier.LIGHT_ABSORBING, VoxelShapeUtils.combine(
                box(0.5, 7.5, 0.5, 15.5, 8.5, 15.5),
                box(1, 7, 15, 15, 9, 16),
                box(0, 7, 0, 1, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(15, 7, 0, 16, 9, 16),
                box(3, 1, 3, 13, 2, 13),
                box(1.75, 0, 1.75, 14.25, 1.25, 14.25),
                box(1, 0, 10, 6, 1, 15),
                box(10, 0, 10, 15, 1, 15),
                box(10, 0, 1, 15, 1, 6),
                box(1, 0, 1, 6, 1, 6),
                box(4, 2, 4, 6, 6, 6),
                box(1.5, 1, 1.5, 4.5, 6, 4.5),
                box(11.5, 1, 1.5, 14.5, 6, 4.5),
                box(11.5, 1, 11.5, 14.5, 6, 14.5),
                box(1.5, 1, 11.5, 4.5, 6, 14.5),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(10, 2, 4, 12, 6, 6),
                box(5, 2, 5, 11, 6, 11),
                box(1, 6, 1, 15, 7, 15)
        ));
        SHAPES.put(SolarTier.PHOTONIC, VoxelShapeUtils.combine(
                box(0.5, 8.5, 0.5, 15.5, 9.5, 15.5),
                box(3, 2, 3, 13, 3, 13),
                box(1.75, 0, 1.75, 14.25, 2.25, 14.25),
                box(1, 8, 0, 15, 10, 1),
                box(15, 8, 0, 16, 10, 16),
                box(0, 8, 0, 1, 10, 16),
                box(1, 8, 15, 15, 10, 16),
                box(1, 0, 10, 6, 2, 15),
                box(10, 0, 10, 15, 2, 15),
                box(10, 0, 1, 15, 2, 6),
                box(10, 0, 0, 16, 1, 6),
                box(0, 0, 0, 6, 1, 6),
                box(0, 0, 10, 6, 1, 16),
                box(10, 0, 10, 16, 1, 16),
                box(1, 0, 1, 6, 2, 6),
                box(1.5, 2, 1.5, 4.5, 7, 4.5),
                box(11.5, 2, 1.5, 14.5, 7, 4.5),
                box(11.5, 2, 11.5, 14.5, 7, 14.5),
                box(1.5, 2, 11.5, 4.5, 7, 14.5),
                box(4, 3, 4, 12, 7, 12),
                box(5, 3, 5, 11, 7, 11),
                box(1, 7, 1, 15, 8, 15)
        ));
        SHAPES.put(SolarTier.CREATIVE, VoxelShapeUtils.combine(
                box(0, 8, 0, 1, 10, 16),
                box(15, 8, 0, 16, 10, 16),
                box(1, 8, 0, 15, 10, 1),
                box(1, 8, 15, 15, 10, 16),
                box(0.5, 8.5, 0.5, 15.5, 9.5, 15.5),
                box(3, 2, 3, 13, 3, 13),
                box(1, 0, 1, 15, 2.25, 15),
                box(10, 0, 0, 16, 1, 6),
                box(0, 0, 0, 6, 1, 6),
                box(0, 0, 10, 6, 1, 16),
                box(10, 0, 10, 16, 1, 16),
                box(1.5, 2, 1.5, 4.5, 7, 4.5),
                box(11.5, 2, 1.5, 14.5, 7, 4.5),
                box(11.5, 2, 11.5, 14.5, 7, 14.5),
                box(6.5, 2, 12, 9.5, 7, 15),
                box(6.5, 2, 1, 9.5, 7, 4),
                box(1, 2, 6.5, 4, 7, 9.5),
                box(12, 2, 6.5, 15, 7, 9.5),
                box(1.5, 2, 11.5, 4.5, 7, 14.5),
                box(4, 3, 4, 12, 7, 12),
                box(5, 3, 5, 11, 7, 11),
                box(1, 7, 1, 15, 8, 15)
        ));
    }

    private SolarPanelShapes() {
    }

    /**
     * The shape for every facing: the panel models do not turn with the block's facing, so neither does the shape.
     */
    public static VoxelShape[] of(SolarTier tier) {
        VoxelShape shape = SHAPES.get(tier);
        return new VoxelShape[]{shape, shape, shape, shape};
    }
}
