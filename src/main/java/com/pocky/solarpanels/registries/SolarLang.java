package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.text.ILangEntry;
import net.minecraft.Util;

@NothingNullByDefault
public enum SolarLang implements ILangEntry {
    MEKANISM_ADVANCED_GENERATORS("constants", "mod_name"),
    DESCRIPTION_SOLAR_GENERATOR("description", "solar_generator"),
    DESCRIPTION_COSMIC_CABLE("description", "cosmic_cable"),
    DESCRIPTION_SUPREME_CABLE("description", "supreme_cable"),
    DESCRIPTION_INFINITY_CABLE("description", "infinity_cable"),
    DESCRIPTION_GALACTIC_CABLE("description", "galactic_cable"),
    CABLE_TRANSFER_RATE("tooltip", "cable.transfer_rate"),
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
