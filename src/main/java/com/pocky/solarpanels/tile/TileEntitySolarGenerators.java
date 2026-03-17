package com.pocky.solarpanels.tile;

import com.pocky.solarpanels.config.SolarPanelsConfig;
import com.pocky.solarpanels.registries.SolarBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TileEntitySolarGenerators {

    public static class Advanced extends TileEntitySolarGenerator {
        public Advanced(BlockPos pos, BlockState state) {
            super(SolarBlocks.ADVANCED_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.advancedSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.advancedSolarGeneration.get();
        }
    }

    public static class Hybrid extends TileEntitySolarGenerator {
        public Hybrid(BlockPos pos, BlockState state) {
            super(SolarBlocks.HYBRID_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.hybridSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.hybridSolarGeneration.get();
        }
    }

    public static class Ultimate extends TileEntitySolarGenerator {
        public Ultimate(BlockPos pos, BlockState state) {
            super(SolarBlocks.ULTIMATE_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.ultimateSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.ultimateSolarGeneration.get();
        }
    }

    public static class Quantum extends TileEntitySolarGenerator {
        public Quantum(BlockPos pos, BlockState state) {
            super(SolarBlocks.QUANTUM_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.quantumSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.quantumSolarGeneration.get();
        }
    }

    public static class Spectral extends TileEntitySolarGenerator {
        public Spectral(BlockPos pos, BlockState state) {
            super(SolarBlocks.SPECTRAL_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.spectralSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.spectralSolarGeneration.get();
        }
    }

    public static class Singular extends TileEntitySolarGenerator {
        public Singular(BlockPos pos, BlockState state) {
            super(SolarBlocks.SINGULAR_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.singularSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.singularSolarGeneration.get();
        }
    }

    public static class LightAbsorbing extends TileEntitySolarGenerator {
        public LightAbsorbing(BlockPos pos, BlockState state) {
            super(SolarBlocks.LIGHT_ABSORBING_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.lightAbsorbingSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.lightAbsorbingSolarGeneration.get();
        }
    }

    public static class Photonic extends TileEntitySolarGenerator {
        public Photonic(BlockPos pos, BlockState state) {
            super(SolarBlocks.PHOTONIC_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.photonicSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.photonicSolarGeneration.get();
        }
    }

    public static class Creative extends TileEntitySolarGenerator {
        public Creative(BlockPos pos, BlockState state) {
            super(SolarBlocks.CREATIVE_SOLAR_PANEL, pos, state, SolarPanelsConfig.generators.creativeSolarGeneration);
        }
        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.creativeSolarGeneration.get();
        }
    }
}
