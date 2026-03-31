package com.pocky.solarpanels.content.cable;

import mekanism.common.content.network.transmitter.UniversalCable;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public class AdvancedUniversalCable extends UniversalCable {

    // Used to pass the custom capacity into getCapacity() which is
    // called from the UniversalCable constructor before our field is initialized.
    private static final ThreadLocal<Long> PENDING_CAPACITY = new ThreadLocal<>();

    private final long advancedCapacity;

    private static Holder<Block> initCapacity(Holder<Block> blockProvider, long capacity) {
        PENDING_CAPACITY.set(capacity);
        return blockProvider;
    }

    public AdvancedUniversalCable(Holder<Block> blockProvider, TileEntityTransmitter tile, long capacity) {
        super(initCapacity(blockProvider, capacity), tile);
        this.advancedCapacity = capacity;
        PENDING_CAPACITY.remove();
    }

    @Override
    public long getCapacity() {
        Long pending = PENDING_CAPACITY.get();
        if (pending != null) {
            return pending;
        }
        return advancedCapacity;
    }
}
