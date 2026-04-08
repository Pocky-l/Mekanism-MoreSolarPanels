package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.text.ILangEntry;
import net.minecraft.Util;

@NothingNullByDefault
public enum SolarLang implements ILangEntry {
    MEKANISM_ADVANCED_GENERATORS("constants", "mod_name"),
    DESCRIPTION_SOLAR_GENERATOR("description", "solar_generator"),
    DESCRIPTION_ADVANCED_CABLE("description", "advanced_cable"),
    PRODUCING_AMOUNT("gui", "producing.amount"),
    OUTPUT_RATE_SHORT("gui", "output_rate.short"),
    ;

    private final String key;

    SolarLang(String type, String path) {
        this(Util.makeDescriptionId(type, SolarPanelsMod.rl(path)));
    }

    SolarLang(String key) {
        this.key = key;
    }

    @Override
    public String getTranslationKey() {
        return key;
    }
}
