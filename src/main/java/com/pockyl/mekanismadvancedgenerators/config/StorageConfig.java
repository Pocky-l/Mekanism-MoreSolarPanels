package com.pockyl.mekanismadvancedgenerators.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;
import com.pockyl.mekanismadvancedgenerators.tier.SolarSize;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.EnumMap;
import java.util.Map;

/**
 * Energy buffers of the solar blocks, energy cube tiers and cable tiers ({@code solarpanels-storage.toml}).
 * The solar values stay at the root of the file, where versions before 2.3 put them.
 */
public final class StorageConfig extends BaseMekanismConfig {
    private final ModConfigSpec spec;
    private final Map<SolarSize, Map<SolarTier, CachedLongValue>> solarStorage = new EnumMap<>(SolarSize.class);
    private final Map<AdvancedEnergyCubeTier, CachedLongValue> cubeStorage = new EnumMap<>(AdvancedEnergyCubeTier.class);
    private final Map<AdvancedEnergyCubeTier, CachedLongValue> cubeOutput = new EnumMap<>(AdvancedEnergyCubeTier.class);
    private final Map<AdvancedCableTier, CachedLongValue> cableCapacity = new EnumMap<>(AdvancedCableTier.class);

    StorageConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        for (SolarSize size : SolarSize.values()) {
            Map<SolarTier, CachedLongValue> values = new EnumMap<>(SolarTier.class);
            for (SolarTier tier : SolarTier.values()) {
                String name = size.displayName(tier);
                values.put(tier, CachedLongValue.definedMin(this, builder,
                        ConfigTranslations.value("storage." + size.registryName(tier), name,
                                "Energy buffer in Joules of the " + name + "."),
                        size.configKey(tier) + "Generator", tier.defaultStorage(size), 1));
            }
            solarStorage.put(size, values);
        }

        ConfigTranslations.section("storage.energy_cubes", "Energy Cubes", "Capacity and output rate of the energy cubes")
                .applyToBuilder(builder).push("energy_cubes");
        for (AdvancedEnergyCubeTier tier : AdvancedEnergyCubeTier.values()) {
            String name = tier.displayName();
            cubeStorage.put(tier, CachedLongValue.definedMin(this, builder,
                    ConfigTranslations.value("storage.energy_cubes." + tier.prefix() + ".storage", name + " Storage",
                            "Maximum number of Joules " + name + " energy cubes can store. "
                                    + "Placed cubes pick up a change when they are loaded again."),
                    tier.prefix() + "Storage", tier.defaultStorage(), 1));
            cubeOutput.put(tier, CachedLongValue.definedMin(this, builder,
                    ConfigTranslations.value("storage.energy_cubes." + tier.prefix() + ".rate", name + " Output Rate",
                            "Output rate in Joules/t of " + name + " energy cubes."),
                    tier.prefix() + "Output", tier.defaultOutput(), 1));
        }
        builder.pop();

        ConfigTranslations.section("storage.universal_cables", "Universal Cables", "Transfer capacity of the universal cables")
                .applyToBuilder(builder).push("universal_cables");
        for (AdvancedCableTier tier : AdvancedCableTier.values()) {
            String name = tier.displayName();
            cableCapacity.put(tier, CachedLongValue.definedMin(this, builder,
                    ConfigTranslations.value("storage.universal_cables." + tier.prefix(), name + " Capacity",
                            "Joules/t one " + name + " Universal Cable can transfer. "
                                    + "Placed cables pick up a change when they are loaded again."),
                    tier.prefix() + "Capacity", tier.defaultCapacity(), 1));
        }
        builder.pop();

        spec = builder.build();
    }

    public CachedLongValue solarStorage(SolarTier tier, SolarSize size) {
        return solarStorage.get(size).get(tier);
    }

    public CachedLongValue energyCubeStorage(AdvancedEnergyCubeTier tier) {
        return cubeStorage.get(tier);
    }

    public CachedLongValue energyCubeOutput(AdvancedEnergyCubeTier tier) {
        return cubeOutput.get(tier);
    }

    public CachedLongValue cableCapacity(AdvancedCableTier tier) {
        return cableCapacity.get(tier);
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
        return spec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }
}
