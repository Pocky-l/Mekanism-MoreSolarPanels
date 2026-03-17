package com.pocky.solarpanels.content.blocktype;

import mekanism.common.util.EnumUtils;
import mekanism.common.util.VoxelShapeUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class BlockShapes {

    private BlockShapes() {
    }

    private static VoxelShape box(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return Block.box(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static final VoxelShape[] ADVANCED_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] HYBRID_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] ULTIMATE_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] QUANTUM_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] SPECTRAL_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] SINGULAR_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] LIGHT_ABSORBING_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] PHOTONIC_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] CREATIVE_SOLAR_PANEL = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];

    static {
        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(0.0, 6.0, 0.0, 16.0, 8.0, 16.0),
                box(4.0, 0.0, 4.0, 12.0, 1.0, 12.0),
                box(6.0, 4.0, 6.0, 10.0, 6.0, 10.0),
                box(7.0, 2.0, 7.0, 9.0, 4.0, 9.0),
                box(5.0, 1.0, 5.0, 6.0, 5.0, 6.0),
                box(10.0, 1.0, 5.0, 11.0, 5.0, 6.0),
                box(5.0, 1.0, 10.0, 6.0, 5.0, 11.0),
                box(10.0, 1.0, 10.0, 11.0, 5.0, 11.0),
                box(6.0, 1.0, 6.0, 10.0, 2.0, 10.0),
                box(1.0, 5.0, 1.0, 15.0, 6.0, 15.0)
        ), ADVANCED_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(0, 6, 0, 16, 8, 16),
                box(3, 0, 3, 13, 1, 13),
                box(6, 4, 6, 10, 6, 10),
                box(7, 2, 7, 9, 4, 9),
                box(5, 2, 5, 6, 5, 6),
                box(10, 2, 5, 11, 5, 6),
                box(5, 2, 10, 6, 5, 11),
                box(10, 2, 10, 11, 5, 11),
                box(4, 1, 4, 5, 5, 5),
                box(11, 1, 4, 12, 5, 5),
                box(4, 1, 11, 5, 5, 12),
                box(11, 1, 11, 12, 5, 12),
                box(5, 1, 5, 11, 2, 11),
                box(1, 5, 1, 15, 6, 15)
        ), HYBRID_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(2, 0, 2, 14, 1, 14),
                box(3, 1, 3, 13, 2, 13),
                box(6, 5, 6, 10, 6, 10),
                box(6.5, 3, 6.5, 9.5, 5, 9.5),
                box(4, 2, 4, 6, 6, 6),
                box(10, 2, 4, 12, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(5, 2, 5, 11, 3, 11),
                box(1, 6, 1, 15, 8.5, 15),
                box(0, 7, 0, 1, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(1, 7, 15, 15, 9, 16)
        ), ULTIMATE_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(2, 0, 2, 14, 1, 14),
                box(3, 1, 3, 13, 2, 13),
                box(6, 5, 6, 10, 6, 10),
                box(6.5, 3, 6.5, 9.5, 5, 9.5),
                box(4, 2, 4, 6, 6, 6),
                box(10, 2, 4, 12, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(5, 2, 5, 11, 3, 11),
                box(1, 6, 1, 15, 8.5, 15),
                box(0, 7, 0, 1, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(1, 7, 15, 15, 9, 16)
        ), QUANTUM_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(2, 0, 2, 14, 1, 14),
                box(3, 1, 3, 13, 2, 13),
                box(4, 2, 4, 6, 6, 6),
                box(10, 2, 4, 12, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(5, 2, 5, 11, 6, 11),
                box(1, 6, 1, 15, 8.5, 15),
                box(0, 7, 0, 1, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(1, 7, 15, 15, 9, 16)
        ), SPECTRAL_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(2, 0, 2, 14, 1, 14),
                box(3, 1, 3, 13, 2, 13),
                box(4, 2, 4, 6, 6, 6),
                box(10, 2, 4, 12, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(5, 2, 5, 11, 6, 11),
                box(1, 6, 1, 15, 8.5, 15),
                box(1, 0, 1, 5, 1, 5),
                box(1, 0, 11, 5, 1, 15),
                box(11, 0, 1, 15, 1, 5),
                box(11, 0, 11, 15, 1, 15),
                box(0, 7, 0, 1, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(1, 7, 15, 15, 9, 16)
        ), SINGULAR_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(2, 0, 2, 14, 1, 14),
                box(3, 1, 3, 13, 2, 13),
                box(4, 2, 4, 6, 6, 6),
                box(10, 2, 4, 12, 6, 6),
                box(4, 2, 10, 6, 6, 12),
                box(10, 2, 10, 12, 6, 12),
                box(5, 2, 5, 11, 6, 11),
                box(1, 6, 1, 15, 8.5, 15),
                box(1, 0, 1, 6, 1, 6),
                box(10, 0, 1, 15, 1, 6),
                box(1, 0, 10, 6, 1, 15),
                box(10, 0, 10, 15, 1, 15),
                box(0, 7, 0, 1, 9, 16),
                box(15, 7, 0, 16, 9, 16),
                box(1, 7, 0, 15, 9, 1),
                box(1, 7, 15, 15, 9, 16)
        ), LIGHT_ABSORBING_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(1.9, 0, 1.9, 14.1, 2, 14.1),
                box(3, 2, 3, 13, 3, 13),
                box(4, 3, 4, 12, 7, 12),
                box(1, 7, 1, 15, 9.5, 15),
                box(1, 1, 1, 6, 2, 6),
                box(10, 1, 1, 15, 2, 6),
                box(1, 1, 10, 6, 2, 15),
                box(10, 1, 10, 15, 2, 15),
                box(0, 0, 0, 6, 1, 6),
                box(10, 0, 0, 16, 1, 6),
                box(0, 0, 10, 6, 1, 16),
                box(10, 0, 10, 16, 1, 16),
                box(0, 8, 0, 1, 10, 16),
                box(15, 8, 0, 16, 10, 16),
                box(1, 8, 0, 15, 10, 1),
                box(1, 8, 15, 15, 10, 16)
        ), PHOTONIC_SOLAR_PANEL);

        VoxelShapeUtils.setShape(VoxelShapeUtils.combine(
                box(1.9, 0, 1.9, 14.1, 2, 14.1),
                box(3, 2, 3, 13, 3, 13),
                box(1, 2, 6.5, 4, 7, 9.5),
                box(6.5, 2, 1, 9.5, 7, 4),
                box(12, 2, 6.5, 15, 7, 9.5),
                box(6.5, 2, 12, 9.5, 7, 15),
                box(4, 3, 4, 12, 7, 12),
                box(1, 7, 1, 15, 9.5, 15),
                box(0, 0, 0, 6, 1, 6),
                box(10, 0, 0, 16, 1, 6),
                box(0, 0, 10, 6, 1, 16),
                box(10, 0, 10, 16, 1, 16),
                box(0, 8, 0, 1, 10, 16),
                box(15, 8, 0, 16, 10, 16),
                box(1, 8, 0, 15, 10, 1),
                box(1, 8, 15, 15, 10, 16)
        ), CREATIVE_SOLAR_PANEL);
    }
}
