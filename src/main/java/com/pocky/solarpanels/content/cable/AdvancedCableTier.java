package com.pocky.solarpanels.content.cable;

public enum AdvancedCableTier {
    COSMIC(65_536_000L),
    SUPREME(524_288_000L),
    INFINITY(4_194_304_000L),
    GALACTIC(33_554_432_000L);

    private final long capacity;

    AdvancedCableTier(long capacity) {
        this.capacity = capacity;
    }

    public long getCapacity() {
        return capacity;
    }
}
