package com.pocky.solarpanels.registers;

import mekanism.api.Upgrade;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.Attributes;
import mekanism.generators.common.GeneratorsLang;
import mekanism.generators.common.content.blocktype.Generator;
import mekanism.generators.common.registries.GeneratorsSounds;
import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.tiles.panels.*;

import java.util.EnumSet;

/**
 * @author Dudko Roman
 */
public class SolarTypes {

    public static final Generator<AdvancedSolarPanelTile> ADVANCED_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
        return SolarTileTypes.ADVANCED_SOLAR_PANEL;
    }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
        return SolarContainerTypes.ADVANCED_SOLAR_PANEL;
    })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().advancedSolarPanel)
            .withCustomShape(SolarShapes.ADVANCED_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<HybridSolarPanelTile> HYBRID_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.HYBRID_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.HYBRID_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().hybridSolarPanel)
            .withCustomShape(SolarShapes.HYBRID_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<UltimateHybridSolarPanelTile> ULTIMATE_HYBRID_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.ULTIMATE_HYBRID_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.ULTIMATE_HYBRID_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().ultimateHybridSolarPanel)
            .withCustomShape(SolarShapes.ULTIMATE_HYBRID_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<QuantumSolarPanelTile> QUANTUM_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.QUANTUM_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.QUANTUM_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().quantumSolarPanel)
            .withCustomShape(SolarShapes.QUANTUM_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<SpectralSolarPanelTile> SPECTRAL_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.SPECTRAL_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.SPECTRAL_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().spectralSolarPanel)
            .withCustomShape(SolarShapes.SPECTRAL_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<SingularSolarPanelTile> SINGULAR_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.SINGULAR_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.SINGULAR_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().singularSolarPanel)
            .withCustomShape(SolarShapes.SINGULAR_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<LightAbsorbingSolarPanelTile> LIGHT_ABSORBING_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.LIGHT_ABSORBING_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.LIGHT_ABSORBING_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().lightAbsorbingSolarPanel)
            .withCustomShape(SolarShapes.LIGHT_ABSORBING_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<PhotonicSolarPanelTile> PHOTONIC_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.PHOTONIC_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.PHOTONIC_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().photonicSolarPanel)
            .withCustomShape(SolarShapes.PHOTONIC_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();

    public static final Generator<CreativeSolarPanelTile> CREATIVE_SOLAR_PANEL_TYPE = (Generator.GeneratorBuilder.createGenerator(() -> {
                return SolarTileTypes.CREATIVE_SOLAR_PANEL;
            }, GeneratorsLang.DESCRIPTION_SOLAR_GENERATOR).withGui(() -> {
                return SolarContainerTypes.CREATIVE_SOLAR_PANEL;
            })
            .withEnergyConfig(SolarPanelsMod.getServerConfig().creativeSolarPanel)
            .withCustomShape(SolarShapes.CREATIVE_SOLAR_PANEL))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();
}
