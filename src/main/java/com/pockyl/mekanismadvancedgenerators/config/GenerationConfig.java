package com.pockyl.mekanismadvancedgenerators.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

import com.pockyl.mekanismadvancedgenerators.tier.SolarSize;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.EnumMap;
import java.util.Map;

/**
 * Peak generation of every solar block ({@code mekanismadvancedgenerators.toml}).
 */
public final class GenerationConfig extends BaseMekanismConfig {
    private final ModConfigSpec spec;
    private final Map<SolarSize, Map<SolarTier, CachedLongValue>> generation = new EnumMap<>(SolarSize.class);

    GenerationConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        defineSection(builder, SolarSize.PANEL, "solar_generators", "Solar Panels");
        defineSection(builder, SolarSize.BIG, "big_solar_generators", "Big Solar Generators");
        spec = builder.build();
    }

    private void defineSection(ModConfigSpec.Builder builder, SolarSize size, String section, String title) {
        ConfigTranslations.section("generation." + section, title, "Peak energy generation of the " + title.toLowerCase())
                .applyToBuilder(builder).push(section);
        Map<SolarTier, CachedLongValue> values = new EnumMap<>(SolarTier.class);
        for (SolarTier tier : SolarTier.values()) {
            String name = size.displayName(tier);
            values.put(tier, CachedLongValue.definePositive(this, builder,
                    ConfigTranslations.value("generation." + size.registryName(tier), name,
                            "Peak energy generation in Joules/t of the " + name + " at noon in a temperate biome. "
                                    + "Hot, dry biomes give more, cold and rainy ones less."),
                    size.configKey(tier) + "Generation", tier.defaultGeneration(size)));
        }
        generation.put(size, values);
        builder.pop();
    }

    public CachedLongValue generation(SolarTier tier, SolarSize size) {
        return generation.get(size).get(tier);
    }

    @Override
    public String getFileName() {
        return "mekanismadvancedgenerators";
    }

    @Override
    public String getTranslation() {
        return "Generation Config";
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
