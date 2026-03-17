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
