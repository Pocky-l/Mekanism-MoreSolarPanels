package com.pockyl.mekanismadvancedgenerators.tier;

import java.util.Locale;

/**
 * Energy tablets above Mekanism's own tablet; each tier holds 3x the previous one.
 */
public enum EnergyTabletTier {
    IMPROVED("Improved", 3_000_000L, 15_000L),
    QUANTUM("Quantum", 9_000_000L, 45_000L),
    SPECTRAL("Spectral", 27_000_000L, 135_000L),
    SINGULAR("Singular", 81_000_000L, 405_000L),
    LIGHT_ABSORBING("Light Absorbing", 243_000_000L, 1_215_000L),
    PHOTONIC("Photonic", 729_000_000L, 3_645_000L),
    CREATIVE("Creative", 2_000_000_000L, 10_000_000L);

    private final String displayName;
    private final long defaultMaxEnergy;
    private final long defaultChargeRate;

    EnergyTabletTier(String displayName, long defaultMaxEnergy, long defaultChargeRate) {
        this.displayName = displayName;
        this.defaultMaxEnergy = defaultMaxEnergy;
        this.defaultChargeRate = defaultChargeRate;
    }

    /** {@code improved_energy_tablet}, ...; also the name of the tablet's config section. */
    public String registryName() {
        return name().toLowerCase(Locale.ROOT) + "_energy_tablet";
    }

    public String displayName() {
        return displayName;
    }

    public long defaultMaxEnergy() {
        return defaultMaxEnergy;
    }

    public long defaultChargeRate() {
        return defaultChargeRate;
    }
}
