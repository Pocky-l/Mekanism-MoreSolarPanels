package com.pocky.solarpanels.content.cable;

import com.pocky.solarpanels.registries.SolarLang;
import mekanism.api.text.ILangEntry;

public enum AdvancedCableTier {
    COSMIC(65_536_000L, SolarLang.DESCRIPTION_COSMIC_CABLE),
    SUPREME(524_288_000L, SolarLang.DESCRIPTION_SUPREME_CABLE),
    INFINITY(4_194_304_000L, SolarLang.DESCRIPTION_INFINITY_CABLE),
    GALACTIC(33_554_432_000L, SolarLang.DESCRIPTION_GALACTIC_CABLE);

    private final long capacity;
    private final ILangEntry description;

    AdvancedCableTier(long capacity, ILangEntry description) {
        this.capacity = capacity;
        this.description = description;
    }

    public long getCapacity() {
        return capacity;
    }

    public ILangEntry getDescription() {
        return description;
    }
}
