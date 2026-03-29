package com.pocky.solarpanels.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.common.ModConfigSpec;

public class SolarStorageConfig extends BaseMekanismConfig {

    private final ModConfigSpec configSpec;

    public final CachedLongValue advancedSolarGenerator;
    public final CachedLongValue hybridSolarGenerator;
    public final CachedLongValue ultimateSolarGenerator;
    public final CachedLongValue quantumSolarGenerator;
    public final CachedLongValue spectralSolarGenerator;
    public final CachedLongValue singularSolarGenerator;
    public final CachedLongValue lightAbsorbingSolarGenerator;
    public final CachedLongValue photonicSolarGenerator;
    public final CachedLongValue creativeSolarGenerator;

    public final CachedLongValue bigAdvancedSolarGenerator;
    public final CachedLongValue bigHybridSolarGenerator;
    public final CachedLongValue bigUltimateSolarGenerator;
    public final CachedLongValue bigQuantumSolarGenerator;
    public final CachedLongValue bigSpectralSolarGenerator;
    public final CachedLongValue bigSingularSolarGenerator;
    public final CachedLongValue bigLightAbsorbingSolarGenerator;
    public final CachedLongValue bigPhotonicSolarGenerator;
    public final CachedLongValue bigCreativeSolarGenerator;

    SolarStorageConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        advancedSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "advancedSolarGenerator", 288_000L, 1);
        hybridSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "hybridSolarGenerator", 864_000L, 1);
        ultimateSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "ultimateSolarGenerator", 2_592_000L, 1);
        quantumSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "quantumSolarGenerator", 7_776_000L, 1);
        spectralSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "spectralSolarGenerator", 23_328_000L, 1);
        singularSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "singularSolarGenerator", 69_984_000L, 1);
        lightAbsorbingSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "lightAbsorbingSolarGenerator", 209_952_000L, 1);
        photonicSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "photonicSolarGenerator", 629_856_000L, 1);
        creativeSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "creativeSolarGenerator", 2_000_000_000L, 1);
        bigAdvancedSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigAdvancedSolarGenerator", 1_728_000L, 1);
        bigHybridSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigHybridSolarGenerator", 5_184_000L, 1);
        bigUltimateSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigUltimateSolarGenerator", 15_552_000L, 1);
        bigQuantumSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigQuantumSolarGenerator", 46_656_000L, 1);
        bigSpectralSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigSpectralSolarGenerator", 139_968_000L, 1);
        bigSingularSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigSingularSolarGenerator", 419_904_000L, 1);
        bigLightAbsorbingSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigLightAbsorbingSolarGenerator", 1_259_712_000L, 1);
        bigPhotonicSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigPhotonicSolarGenerator", 3_779_136_000L, 1);
        bigCreativeSolarGenerator = CachedLongValue.definedMin(this, builder, SolarConfigTranslations.ENERGY_STORAGE_GENERATOR_SOLAR, "bigCreativeSolarGenerator", 12_000_000_000L, 1);

        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "solarpanels-storage";
    }

    @Override
    public String getTranslation() {
        return "Storage Config";
    }

    @Override
    public ModConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public Type getConfigType() {
        return Type.SERVER;
    }
}
