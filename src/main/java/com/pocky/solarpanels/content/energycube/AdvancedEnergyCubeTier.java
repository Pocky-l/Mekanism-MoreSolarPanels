package com.pocky.solarpanels.content.energycube;

public enum AdvancedEnergyCubeTier {
    COSMIC(2_048_000_000L,   4_096_000L),
    SUPREME(16_384_000_000L, 32_768_000L),
    INFINITY(131_072_000_000L, 262_144_000L),
    GALACTIC(1_048_576_000_000L, 2_097_152_000L);

    private final long maxEnergy;
    private final long output;

    AdvancedEnergyCubeTier(long maxEnergy, long output) {
        this.maxEnergy = maxEnergy;
        this.output = output;
    }

    public long getMaxEnergy() {
        return maxEnergy;
    }

    public long getOutput() {
        return output;
    }
}
