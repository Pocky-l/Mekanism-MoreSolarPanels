package com.pocky.solarpanels.tile;

import com.pocky.solarpanels.config.SolarPanelsConfig;
import com.pocky.solarpanels.registries.SolarBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TileEntityBigSolarGenerators {

    public static class Advanced extends TileEntityBigSolarGenerator {
        public Advanced(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_ADVANCED_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigAdvancedSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigAdvancedSolarGeneration.get();
        }
    }

    public static class Hybrid extends TileEntityBigSolarGenerator {
        public Hybrid(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_HYBRID_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigHybridSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigHybridSolarGeneration.get();
        }
    }

    public static class Ultimate extends TileEntityBigSolarGenerator {
        public Ultimate(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_ULTIMATE_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigUltimateSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigUltimateSolarGeneration.get();
        }
    }

    public static class Quantum extends TileEntityBigSolarGenerator {
        public Quantum(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_QUANTUM_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigQuantumSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigQuantumSolarGeneration.get();
        }
    }

    public static class Spectral extends TileEntityBigSolarGenerator {
        public Spectral(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_SPECTRAL_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigSpectralSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigSpectralSolarGeneration.get();
        }
    }

    public static class Singular extends TileEntityBigSolarGenerator {
        public Singular(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_SINGULAR_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigSingularSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigSingularSolarGeneration.get();
        }
    }

    public static class LightAbsorbing extends TileEntityBigSolarGenerator {
        public LightAbsorbing(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigLightAbsorbingSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigLightAbsorbingSolarGeneration.get();
        }
    }

    public static class Photonic extends TileEntityBigSolarGenerator {
        public Photonic(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_PHOTONIC_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigPhotonicSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigPhotonicSolarGeneration.get();
        }
    }

    public static class Creative extends TileEntityBigSolarGenerator {
        public Creative(BlockPos pos, BlockState state) {
            super(SolarBlocks.BIG_CREATIVE_SOLAR_GENERATOR, pos, state, SolarPanelsConfig.generators.bigCreativeSolarGeneration);
        }

        @Override
        protected long getConfiguredMax() {
            return SolarPanelsConfig.generators.bigCreativeSolarGeneration.get();
        }
    }
}
