package su.gamepoint.solarpanels.registers;

import mekanism.api.Upgrade;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.Attributes;
import mekanism.generators.common.GeneratorsLang;
import mekanism.generators.common.content.blocktype.BlockShapes;
import mekanism.generators.common.content.blocktype.Generator;
import mekanism.generators.common.registries.GeneratorsSounds;
import su.gamepoint.solarpanels.SolarPanelsMod;
import su.gamepoint.solarpanels.tiles.panels.*;

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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
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
            .withCustomShape(BlockShapes.SOLAR_GENERATOR))
            .withSound(GeneratorsSounds.SOLAR_GENERATOR)
            .withSupportedUpgrades(EnumSet.of(Upgrade.MUFFLING))
            .withComputerSupport("solarGenerator")
            .replace(new Attribute[]{Attributes.ACTIVE}).build();
}
