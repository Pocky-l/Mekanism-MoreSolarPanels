package com.pockyl.mekanismadvancedgenerators.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

import com.pockyl.mekanismadvancedgenerators.tier.EnergyTabletTier;

import java.util.EnumMap;
import java.util.Map;

/**
 * Capacity and charge rate of the energy tablets ({@code solarpanels-gear.toml}).
 */
public final class GearConfig extends BaseMekanismConfig {
    private final ModConfigSpec spec;
    private final Map<EnergyTabletTier, CachedLongValue> maxEnergy = new EnumMap<>(EnergyTabletTier.class);
    private final Map<EnergyTabletTier, CachedLongValue> chargeRate = new EnumMap<>(EnergyTabletTier.class);

    GearConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        for (EnergyTabletTier tier : EnergyTabletTier.values()) {
            String name = tier.displayName() + " Energy Tablet";
            String path = "gear." + tier.registryName();
            ConfigTranslations.section(path, name, "Settings of the " + name).applyToBuilder(builder).push(tier.registryName());
            maxEnergy.put(tier, CachedLongValue.definePositive(this, builder,
                    ConfigTranslations.value(path + ".max_energy", "Max Energy", "Maximum amount of Joules the " + name + " can store."),
                    "maxEnergy", tier.defaultMaxEnergy()));
            chargeRate.put(tier, CachedLongValue.definePositive(this, builder,
                    ConfigTranslations.value(path + ".charge_rate", "Charge Rate", "Joules/t the " + name + " can receive or give."),
                    "chargeRate", tier.defaultChargeRate()));
            builder.pop();
        }
        spec = builder.build();
    }

    public CachedLongValue maxEnergy(EnergyTabletTier tier) {
        return maxEnergy.get(tier);
    }

    public CachedLongValue chargeRate(EnergyTabletTier tier) {
        return chargeRate.get(tier);
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
        return spec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }
}
