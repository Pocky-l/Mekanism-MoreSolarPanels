package com.pocky.solarpanels.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.MekanismConfigTranslations;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.common.ModConfigSpec;

public class SolarGearConfig extends BaseMekanismConfig {

    private final ModConfigSpec configSpec;

    public final CachedLongValue improvedTabletMaxEnergy;
    public final CachedLongValue improvedTabletChargeRate;
    public final CachedLongValue quantumTabletMaxEnergy;
    public final CachedLongValue quantumTabletChargeRate;
    public final CachedLongValue spectralTabletMaxEnergy;
    public final CachedLongValue spectralTabletChargeRate;
    public final CachedLongValue singularTabletMaxEnergy;
    public final CachedLongValue singularTabletChargeRate;
    public final CachedLongValue lightAbsorbingTabletMaxEnergy;
    public final CachedLongValue lightAbsorbingTabletChargeRate;
    public final CachedLongValue photonicTabletMaxEnergy;
    public final CachedLongValue photonicTabletChargeRate;
    public final CachedLongValue creativeTabletMaxEnergy;
    public final CachedLongValue creativeTabletChargeRate;

    SolarGearConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        MekanismConfigTranslations.GEAR_ENERGY_TABLET.applyToBuilder(builder).push("improved_energy_tablet");
        improvedTabletMaxEnergy = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_MAX_ENERGY, "maxEnergy", 3_000_000L);
        improvedTabletChargeRate = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_CHARGE_RATE, "chargeRate", 15_000L);
        builder.pop();

        MekanismConfigTranslations.GEAR_ENERGY_TABLET.applyToBuilder(builder).push("quantum_energy_tablet");
        quantumTabletMaxEnergy = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_MAX_ENERGY, "maxEnergy", 9_000_000L);
        quantumTabletChargeRate = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_CHARGE_RATE, "chargeRate", 45_000L);
        builder.pop();

        MekanismConfigTranslations.GEAR_ENERGY_TABLET.applyToBuilder(builder).push("spectral_energy_tablet");
        spectralTabletMaxEnergy = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_MAX_ENERGY, "maxEnergy", 27_000_000L);
        spectralTabletChargeRate = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_CHARGE_RATE, "chargeRate", 135_000L);
        builder.pop();

        MekanismConfigTranslations.GEAR_ENERGY_TABLET.applyToBuilder(builder).push("singular_energy_tablet");
        singularTabletMaxEnergy = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_MAX_ENERGY, "maxEnergy", 81_000_000L);
        singularTabletChargeRate = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_CHARGE_RATE, "chargeRate", 405_000L);
        builder.pop();

        MekanismConfigTranslations.GEAR_ENERGY_TABLET.applyToBuilder(builder).push("light_absorbing_energy_tablet");
        lightAbsorbingTabletMaxEnergy = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_MAX_ENERGY, "maxEnergy", 243_000_000L);
        lightAbsorbingTabletChargeRate = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_CHARGE_RATE, "chargeRate", 1_215_000L);
        builder.pop();

        MekanismConfigTranslations.GEAR_ENERGY_TABLET.applyToBuilder(builder).push("photonic_energy_tablet");
        photonicTabletMaxEnergy = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_MAX_ENERGY, "maxEnergy", 729_000_000L);
        photonicTabletChargeRate = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_CHARGE_RATE, "chargeRate", 3_645_000L);
        builder.pop();

        MekanismConfigTranslations.GEAR_ENERGY_TABLET.applyToBuilder(builder).push("creative_energy_tablet");
        creativeTabletMaxEnergy = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_MAX_ENERGY, "maxEnergy", 2_000_000_000L);
        creativeTabletChargeRate = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.GEAR_ENERGY_TABLET_CHARGE_RATE, "chargeRate", 10_000_000L);
        builder.pop();

        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "solarpanels-gear";
    }

    @Override
    public String getTranslation() {
        return "Gear Config";
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
