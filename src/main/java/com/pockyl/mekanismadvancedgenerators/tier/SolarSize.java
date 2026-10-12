package com.pockyl.mekanismadvancedgenerators.tier;

/**
 * One-block solar panels and big 3x3 solar generators (the size of Mekanism's Advanced Solar Generator).
 */
public enum SolarSize {
    PANEL(1),
    BIG(6);

    private final int multiplier;

    SolarSize(int multiplier) {
        this.multiplier = multiplier;
    }

    /** How many times more a generator of this size produces and stores than a panel of the same tier. */
    public int multiplier() {
        return multiplier;
    }

    /** {@code advanced_solar_panel}, {@code big_advanced_solar_generator}, ... */
    public String registryName(SolarTier tier) {
        return this == PANEL ? tier.prefix() + "_solar_panel" : "big_" + tier.prefix() + "_solar_generator";
    }

    /** {@code advancedSolar}, {@code bigAdvancedSolar}, ...: the start of the config keys. */
    public String configKey(SolarTier tier) {
        String camel = tier.camelPrefix();
        if (this == PANEL) {
            return camel + "Solar";
        }
        return "big" + Character.toUpperCase(camel.charAt(0)) + camel.substring(1) + "Solar";
    }

    /** English name for config comments: "Advanced Solar Panel", "Big Advanced Solar Generator". */
    public String displayName(SolarTier tier) {
        return this == PANEL ? tier.displayName() + " Solar Panel" : "Big " + tier.displayName() + " Solar Generator";
    }
}
