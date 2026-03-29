package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.config.SolarPanelsConfig;
import com.pocky.solarpanels.content.blocktype.BlockShapes;
import com.pocky.solarpanels.content.blocktype.Generator;
import com.pocky.solarpanels.tile.TileEntityBigSolarGenerators;
import com.pocky.solarpanels.tile.TileEntitySolarGenerators;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.Attributes;

public class SolarBlockTypes {

    private SolarBlockTypes() {
    }

    public static final Generator<TileEntitySolarGenerators.Advanced> ADVANCED_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.ADVANCED_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.ADVANCED_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.advancedSolarGenerator)
            .withCustomShape(BlockShapes.ADVANCED_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.Hybrid> HYBRID_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.HYBRID_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.HYBRID_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.hybridSolarGenerator)
            .withCustomShape(BlockShapes.HYBRID_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.Ultimate> ULTIMATE_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.ULTIMATE_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.ULTIMATE_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.ultimateSolarGenerator)
            .withCustomShape(BlockShapes.ULTIMATE_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.Quantum> QUANTUM_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.QUANTUM_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.QUANTUM_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.quantumSolarGenerator)
            .withCustomShape(BlockShapes.QUANTUM_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.Spectral> SPECTRAL_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.SPECTRAL_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.SPECTRAL_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.spectralSolarGenerator)
            .withCustomShape(BlockShapes.SPECTRAL_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.Singular> SINGULAR_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.SINGULAR_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.SINGULAR_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.singularSolarGenerator)
            .withCustomShape(BlockShapes.SINGULAR_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.LightAbsorbing> LIGHT_ABSORBING_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.LIGHT_ABSORBING_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.LIGHT_ABSORBING_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.lightAbsorbingSolarGenerator)
            .withCustomShape(BlockShapes.LIGHT_ABSORBING_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.Photonic> PHOTONIC_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.PHOTONIC_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.PHOTONIC_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.photonicSolarGenerator)
            .withCustomShape(BlockShapes.PHOTONIC_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntitySolarGenerators.Creative> CREATIVE_SOLAR_PANEL = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.CREATIVE_SOLAR_PANEL, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.CREATIVE_SOLAR_PANEL)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.creativeSolarGenerator)
            .withCustomShape(BlockShapes.CREATIVE_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Advanced> BIG_ADVANCED_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_ADVANCED_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigAdvancedSolarGenerator)
            .withCustomShape(BlockShapes.ADVANCED_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Hybrid> BIG_HYBRID_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_HYBRID_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_HYBRID_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigHybridSolarGenerator)
            .withCustomShape(BlockShapes.HYBRID_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Ultimate> BIG_ULTIMATE_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_ULTIMATE_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_ULTIMATE_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigUltimateSolarGenerator)
            .withCustomShape(BlockShapes.ULTIMATE_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Quantum> BIG_QUANTUM_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_QUANTUM_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_QUANTUM_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigQuantumSolarGenerator)
            .withCustomShape(BlockShapes.QUANTUM_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Spectral> BIG_SPECTRAL_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_SPECTRAL_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_SPECTRAL_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigSpectralSolarGenerator)
            .withCustomShape(BlockShapes.SPECTRAL_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Singular> BIG_SINGULAR_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_SINGULAR_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_SINGULAR_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigSingularSolarGenerator)
            .withCustomShape(BlockShapes.SINGULAR_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.LightAbsorbing> BIG_LIGHT_ABSORBING_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigLightAbsorbingSolarGenerator)
            .withCustomShape(BlockShapes.LIGHT_ABSORBING_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Photonic> BIG_PHOTONIC_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_PHOTONIC_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_PHOTONIC_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigPhotonicSolarGenerator)
            .withCustomShape(BlockShapes.PHOTONIC_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Creative> BIG_CREATIVE_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_CREATIVE_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_CREATIVE_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigCreativeSolarGenerator)
            .withCustomShape(BlockShapes.CREATIVE_SOLAR_PANEL)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();
}
