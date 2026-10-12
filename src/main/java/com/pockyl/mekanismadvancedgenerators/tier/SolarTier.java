package com.pockyl.mekanismadvancedgenerators.tier;

import java.util.Locale;

/**
 * The nine solar tiers. Each tier exists as a one-block {@link SolarSize#PANEL} and a 3x3 {@link SolarSize#BIG} generator.
 * Registry names and config keys are derived from {@link #prefix()} and must never change: worlds and server configs
 * of earlier versions refer to them.
 */
public enum SolarTier {
    ADVANCED("Advanced", 150L, 288_000L),
    HYBRID("Hybrid", 450L, 864_000L),
    ULTIMATE("Ultimate", 1_350L, 2_592_000L),
    QUANTUM("Quantum", 4_050L, 7_776_000L),
    SPECTRAL("Spectral", 12_150L, 23_328_000L),
    SINGULAR("Singular", 36_450L, 69_984_000L),
    LIGHT_ABSORBING("Light Absorbing", 109_350L, 209_952_000L),
    PHOTONIC("Photonic", 328_050L, 629_856_000L),
    CREATIVE("Creative", 10_000_000L, 2_000_000_000L);

    private final String displayName;
    private final long panelGeneration;
    private final long panelStorage;

    SolarTier(String displayName, long panelGeneration, long panelStorage) {
        this.displayName = displayName;
        this.panelGeneration = panelGeneration;
        this.panelStorage = panelStorage;
    }

    /** {@code advanced}, {@code light_absorbing}, ... */
    public String prefix() {
        return name().toLowerCase(Locale.ROOT);
    }

    /** {@code advanced}, {@code lightAbsorbing}, ...: the start of the config keys. */
    public String camelPrefix() {
        String[] words = prefix().split("_");
        StringBuilder result = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            result.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1));
        }
        return result.toString();
    }

    /** English tier name for config comments. */
    public String displayName() {
        return displayName;
    }

    /** Default peak generation in J/t. */
    public long defaultGeneration(SolarSize size) {
        return panelGeneration * size.multiplier();
    }

    /** Default energy buffer in J. */
    public long defaultStorage(SolarSize size) {
        return panelStorage * size.multiplier();
    }
}
