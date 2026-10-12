package com.pockyl.mekanismadvancedgenerators.tier;

import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;

import java.util.Locale;

/**
 * Universal cables above Mekanism's Ultimate tier. Each tier transfers 8x the previous one.
 */
public enum AdvancedCableTier {
    COSMIC("Cosmic", 65_536_000L),
    SUPREME("Supreme", 524_288_000L),
    INFINITY("Infinity", 4_194_304_000L),
    GALACTIC("Galactic", 33_554_432_000L);

    private final String displayName;
    private final long defaultCapacity;

    AdvancedCableTier(String displayName, long defaultCapacity) {
        this.displayName = displayName;
        this.defaultCapacity = defaultCapacity;
    }

    /** {@code cosmic}, ... */
    public String prefix() {
        return name().toLowerCase(Locale.ROOT);
    }

    /** {@code cosmic_universal_cable}, ... */
    public String registryName() {
        return prefix() + "_universal_cable";
    }

    public String displayName() {
        return displayName;
    }

    public long defaultCapacity() {
        return defaultCapacity;
    }

    /** Configured transfer capacity in J/t. */
    public long capacity() {
        return ModConfigs.STORAGE.cableCapacity(this).getOrDefault();
    }
}
