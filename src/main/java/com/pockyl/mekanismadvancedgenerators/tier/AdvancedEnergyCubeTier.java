package com.pockyl.mekanismadvancedgenerators.tier;

import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;

import java.util.Locale;

/**
 * Energy cubes above Mekanism's Ultimate tier. Each tier stores and outputs 8x the previous one.
 */
public enum AdvancedEnergyCubeTier {
    COSMIC("Cosmic", 2_048_000_000L, 4_096_000L),
    SUPREME("Supreme", 16_384_000_000L, 32_768_000L),
    INFINITY("Infinity", 131_072_000_000L, 262_144_000L),
    GALACTIC("Galactic", 1_048_576_000_000L, 2_097_152_000L);

    private final String displayName;
    private final long defaultStorage;
    private final long defaultOutput;

    AdvancedEnergyCubeTier(String displayName, long defaultStorage, long defaultOutput) {
        this.displayName = displayName;
        this.defaultStorage = defaultStorage;
        this.defaultOutput = defaultOutput;
    }

    /** {@code cosmic}, ... */
    public String prefix() {
        return name().toLowerCase(Locale.ROOT);
    }

    /** {@code cosmic_energy_cube}, ... */
    public String registryName() {
        return prefix() + "_energy_cube";
    }

    public String displayName() {
        return displayName;
    }

    public long defaultStorage() {
        return defaultStorage;
    }

    public long defaultOutput() {
        return defaultOutput;
    }

    /** Configured capacity in J. */
    public long storage() {
        return ModConfigs.STORAGE.energyCubeStorage(this).getOrDefault();
    }

    /** Configured output rate in J/t. */
    public long output() {
        return ModConfigs.STORAGE.energyCubeOutput(this).getOrDefault();
    }
}
