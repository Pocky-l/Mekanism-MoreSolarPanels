package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.config.SolarPanelsConfig;
import com.pocky.solarpanels.content.blocktype.BlockShapes;
import com.pocky.solarpanels.content.blocktype.Generator;
import com.pocky.solarpanels.content.cable.TileEntityAdvancedCable;
import com.pocky.solarpanels.content.energycube.AdvancedEnergyCubeTier;
import com.pocky.solarpanels.content.energycube.AttributeAdvancedTier;
import com.pocky.solarpanels.tile.TileEntityBigSolarGenerators;
import com.pocky.solarpanels.tile.TileEntitySolarGenerators;
import java.util.function.Supplier;
import mekanism.api.text.ILangEntry;
import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeHasBounding.HandleBoundingBlock;
import mekanism.common.block.attribute.AttributeHasBounding.TriBooleanFunction;
import mekanism.common.block.attribute.AttributeParticleFX;
import mekanism.common.block.attribute.AttributeStateActive;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.Attributes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.BlockTypeTile.BlockTileBuilder;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.content.blocktype.Machine.MachineBuilder;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tier.CableTier;
import mekanism.common.tier.EnergyCubeTier;
import mekanism.common.tile.TileEntityEnergyCube;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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

    private static final HandleBoundingBlock BIG_SOLAR_BOUNDING = new HandleBoundingBlock() {
        @Override
        public <DATA> boolean handle(Level level, BlockPos pos, BlockState state, DATA data, TriBooleanFunction<Level, BlockPos, DATA> consumer) {
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
            if (!consumer.accept(level, mutable.setWithOffset(pos, 0, 1, 0), data)) {
                return false;
            }
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    mutable.setWithOffset(pos, x, 2, z);
                    if (!consumer.accept(level, mutable, data)) {
                        return false;
                    }
                }
            }
            return true;
        }
    };

    public static final Generator<TileEntityBigSolarGenerators.Advanced> BIG_ADVANCED_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_ADVANCED_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigAdvancedSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Hybrid> BIG_HYBRID_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_HYBRID_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_HYBRID_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigHybridSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Ultimate> BIG_ULTIMATE_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_ULTIMATE_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_ULTIMATE_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigUltimateSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Quantum> BIG_QUANTUM_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_QUANTUM_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_QUANTUM_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigQuantumSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Spectral> BIG_SPECTRAL_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_SPECTRAL_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_SPECTRAL_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigSpectralSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Singular> BIG_SINGULAR_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_SINGULAR_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_SINGULAR_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigSingularSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.LightAbsorbing> BIG_LIGHT_ABSORBING_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigLightAbsorbingSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Photonic> BIG_PHOTONIC_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_PHOTONIC_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_PHOTONIC_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigPhotonicSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final Generator<TileEntityBigSolarGenerators.Creative> BIG_CREATIVE_SOLAR_GENERATOR = Generator.GeneratorBuilder
            .createGenerator(() -> SolarTileEntityTypes.BIG_CREATIVE_SOLAR_GENERATOR, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
            .withGui(() -> SolarContainerTypes.BIG_CREATIVE_SOLAR_GENERATOR)
            .withEnergyConfig(SolarPanelsConfig.storageConfig.bigCreativeSolarGenerator)
            .withCustomShape(BlockShapes.BIG_ADVANCED_SOLAR_GENERATOR)
            .withBounding(BIG_SOLAR_BOUNDING)
            .withSound(SolarSounds.SOLAR_GENERATOR)
            .with(AttributeUpgradeSupport.MUFFLING_ONLY)
            .replace(Attributes.ACTIVE)
            .build();

    public static final BlockTypeTile<TileEntityAdvancedCable> COSMIC_CABLE = createCable(() -> SolarTileEntityTypes.COSMIC_CABLE);
    public static final BlockTypeTile<TileEntityAdvancedCable> SUPREME_CABLE = createCable(() -> SolarTileEntityTypes.SUPREME_CABLE);
    public static final BlockTypeTile<TileEntityAdvancedCable> INFINITY_CABLE = createCable(() -> SolarTileEntityTypes.INFINITY_CABLE);
    public static final BlockTypeTile<TileEntityAdvancedCable> GALACTIC_CABLE = createCable(() -> SolarTileEntityTypes.GALACTIC_CABLE);

    private static BlockTypeTile<TileEntityAdvancedCable> createCable(java.util.function.Supplier<mekanism.common.registration.impl.TileEntityTypeRegistryObject<TileEntityAdvancedCable>> tile) {
        return BlockTileBuilder.createBlock(tile, SolarLang.DESCRIPTION_SOLAR_GENERATOR)
                .with(new AttributeTier<>(CableTier.ULTIMATE))
                .build();
    }

    public static final Machine<TileEntityEnergyCube> COSMIC_ENERGY_CUBE = createAdvancedEnergyCube(AdvancedEnergyCubeTier.COSMIC, SolarLang.DESCRIPTION_COSMIC_ENERGY_CUBE, () -> SolarTileEntityTypes.COSMIC_ENERGY_CUBE);
    public static final Machine<TileEntityEnergyCube> SUPREME_ENERGY_CUBE = createAdvancedEnergyCube(AdvancedEnergyCubeTier.SUPREME, SolarLang.DESCRIPTION_SUPREME_ENERGY_CUBE, () -> SolarTileEntityTypes.SUPREME_ENERGY_CUBE);
    public static final Machine<TileEntityEnergyCube> INFINITY_ENERGY_CUBE = createAdvancedEnergyCube(AdvancedEnergyCubeTier.INFINITY, SolarLang.DESCRIPTION_INFINITY_ENERGY_CUBE, () -> SolarTileEntityTypes.INFINITY_ENERGY_CUBE);
    public static final Machine<TileEntityEnergyCube> GALACTIC_ENERGY_CUBE = createAdvancedEnergyCube(AdvancedEnergyCubeTier.GALACTIC, SolarLang.DESCRIPTION_GALACTIC_ENERGY_CUBE, () -> SolarTileEntityTypes.GALACTIC_ENERGY_CUBE);

    private static Machine<TileEntityEnergyCube> createAdvancedEnergyCube(AdvancedEnergyCubeTier tier, ILangEntry description,
            Supplier<TileEntityTypeRegistryObject<TileEntityEnergyCube>> tile) {
        return MachineBuilder.<TileEntityEnergyCube>createMachine(tile, description)
                .withGui(() -> SolarContainerTypes.ADVANCED_ENERGY_CUBE)
                .withEnergyConfig(tier::getMaxEnergy)
                .with(new AttributeTier<>(EnergyCubeTier.ULTIMATE), new AttributeStateFacing(BlockStateProperties.FACING), new AttributeAdvancedTier(tier))
                .withSideConfig(TransmissionType.ENERGY, TransmissionType.ITEM)
                .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                .build();
    }
}
