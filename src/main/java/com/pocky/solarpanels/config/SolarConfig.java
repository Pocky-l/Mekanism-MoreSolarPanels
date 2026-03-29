package com.pocky.solarpanels.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.common.ModConfigSpec;

public class SolarConfig extends BaseMekanismConfig {

    private final ModConfigSpec configSpec;

    public final CachedLongValue advancedSolarGeneration;
    public final CachedLongValue hybridSolarGeneration;
    public final CachedLongValue ultimateSolarGeneration;
    public final CachedLongValue quantumSolarGeneration;
    public final CachedLongValue spectralSolarGeneration;
    public final CachedLongValue singularSolarGeneration;
    public final CachedLongValue lightAbsorbingSolarGeneration;
    public final CachedLongValue photonicSolarGeneration;
    public final CachedLongValue creativeSolarGeneration;

    public final CachedLongValue bigAdvancedSolarGeneration;
    public final CachedLongValue bigHybridSolarGeneration;
    public final CachedLongValue bigUltimateSolarGeneration;
    public final CachedLongValue bigQuantumSolarGeneration;
    public final CachedLongValue bigSpectralSolarGeneration;
    public final CachedLongValue bigSingularSolarGeneration;
    public final CachedLongValue bigLightAbsorbingSolarGeneration;
    public final CachedLongValue bigPhotonicSolarGeneration;
    public final CachedLongValue bigCreativeSolarGeneration;

    SolarConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        SolarConfigTranslations.SERVER_GENERATOR_SOLAR.applyToBuilder(builder).push("solar_generators");
        advancedSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "advancedSolarGeneration", 150L);
        hybridSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "hybridSolarGeneration", 450L);
        ultimateSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "ultimateSolarGeneration", 1_350L);
        quantumSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "quantumSolarGeneration", 4_050L);
        spectralSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "spectralSolarGeneration", 12_150L);
        singularSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "singularSolarGeneration", 36_450L);
        lightAbsorbingSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "lightAbsorbingSolarGeneration", 109_350L);
        photonicSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "photonicSolarGeneration", 328_050L);
        creativeSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "creativeSolarGeneration", 10_000_000L);
        builder.pop();

        SolarConfigTranslations.SERVER_GENERATOR_SOLAR.applyToBuilder(builder).push("big_solar_generators");
        bigAdvancedSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigAdvancedSolarGeneration", 900L);
        bigHybridSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigHybridSolarGeneration", 2_700L);
        bigUltimateSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigUltimateSolarGeneration", 8_100L);
        bigQuantumSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigQuantumSolarGeneration", 24_300L);
        bigSpectralSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigSpectralSolarGeneration", 72_900L);
        bigSingularSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigSingularSolarGeneration", 218_700L);
        bigLightAbsorbingSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigLightAbsorbingSolarGeneration", 656_100L);
        bigPhotonicSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigPhotonicSolarGeneration", 1_968_300L);
        bigCreativeSolarGeneration = CachedLongValue.definePositive(this, builder, SolarConfigTranslations.SERVER_SOLAR_GENERATION, "bigCreativeSolarGeneration", 60_000_000L);
        builder.pop();

        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "mekanismadvancedgenerators";
    }

    @Override
    public String getTranslation() {
        return "General Config";
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
