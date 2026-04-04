package com.pocky.solarpanels.content.energycube;

public enum AdvancedEnergyCubeTier {
    COSMIC(2_048_000_000L),
    SUPREME(16_384_000_000L),
    INFINITY(131_072_000_000L),
    GALACTIC(1_048_576_000_000L);

    private final long maxEnergy;

    AdvancedEnergyCubeTier(long maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public long getMaxEnergy() {
        return maxEnergy;
    }
}
