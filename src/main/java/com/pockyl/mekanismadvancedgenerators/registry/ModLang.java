package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.text.ILangEntry;
import net.minecraft.Util;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;

/**
 * Translation keys used through Mekanism's text helpers.
 */
@NothingNullByDefault
public enum ModLang implements ILangEntry {
    DESCRIPTION_SOLAR_GENERATOR("description", "solar_generator"),
    PRODUCING("gui", "producing.amount"),
    OUTPUT_RATE_SHORT("gui", "output_rate.short"),
    SEES_SUN("gui", "sees_sun"),
    NO_SUN("gui", "no_sun"),
    PEAK_GENERATION("tooltip", "peak_generation");

    private final String key;

    ModLang(String type, String path) {
        this.key = Util.makeDescriptionId(type, MekanismAdvancedGenerators.id(path));
    }

    @Override
    public String getTranslationKey() {
        return key;
    }

    public static ILangEntry cableDescription(AdvancedCableTier tier) {
        String key = Util.makeDescriptionId("description", MekanismAdvancedGenerators.id(tier.prefix() + "_cable"));
        return () -> key;
    }

    public static ILangEntry energyCubeDescription(AdvancedEnergyCubeTier tier) {
        String key = Util.makeDescriptionId("description", MekanismAdvancedGenerators.id(tier.registryName()));
        return () -> key;
    }
}
