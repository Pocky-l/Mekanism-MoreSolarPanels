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
        VoxelShape SOLAR_PANEL_SHAPE = VoxelShapeUtils.combine(
                box(0, 6, 0, 16, 8, 16), // solarPanel
                box(4, 0, 4, 12, 1, 12), // solarPanelPort
                box(6, 4, 6, 10, 6, 10), // solarPanelConnector
                box(7, 2, 7, 9, 4, 9), // solarPanelRod1
                box(5, 1, 5, 6, 5, 6), // solarPanelRod2
                box(10, 1, 5, 11, 5, 6), // solarPanelRod3
                box(5, 1, 10, 6, 5, 11), // solarPanelRod4
                box(10, 1, 10, 11, 5, 11), // solarPanelRod5
                box(6, 1, 6, 10, 2, 10), // solarPanelPipeBase
                box(1, 5, 1, 15, 6, 15) // solarPanelBottom
        );

        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, ADVANCED_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, HYBRID_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, ULTIMATE_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, QUANTUM_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, SPECTRAL_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, SINGULAR_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, LIGHT_ABSORBING_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, PHOTONIC_SOLAR_PANEL);
        VoxelShapeUtils.setShape(SOLAR_PANEL_SHAPE, CREATIVE_SOLAR_PANEL);
    }
}
