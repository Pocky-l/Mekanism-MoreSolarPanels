package com.pocky.solarpanels.content.cable;

import com.pocky.solarpanels.registries.SolarBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TileEntityAdvancedCables {

    public static class Cosmic extends TileEntityAdvancedCable {
        public Cosmic(BlockPos pos, BlockState state) {
            super(SolarBlocks.COSMIC_CABLE, pos, state);
        }
    }

    public static class Supreme extends TileEntityAdvancedCable {
        public Supreme(BlockPos pos, BlockState state) {
            super(SolarBlocks.SUPREME_CABLE, pos, state);
        }
    }

    public static class Infinity extends TileEntityAdvancedCable {
        public Infinity(BlockPos pos, BlockState state) {
            super(SolarBlocks.INFINITY_CABLE, pos, state);
        }
    }

    public static class Galactic extends TileEntityAdvancedCable {
        public Galactic(BlockPos pos, BlockState state) {
            super(SolarBlocks.GALACTIC_CABLE, pos, state);
        }
    }
}
