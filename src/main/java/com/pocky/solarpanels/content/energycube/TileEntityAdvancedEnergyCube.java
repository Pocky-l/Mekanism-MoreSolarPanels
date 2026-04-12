package com.pocky.solarpanels.content.energycube;

import java.lang.reflect.Field;
import com.mojang.logging.LogUtils;
import java.util.function.LongSupplier;
import mekanism.api.IContentsListener;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.capabilities.energy.EnergyCubeEnergyContainer;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.component.TileComponentEjector;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

@NothingNullByDefault
public class TileEntityAdvancedEnergyCube extends TileEntityEnergyCube {

    private static final Field MAX_ENERGY_FIELD;
    private static final Field CONTAINER_RATE_FIELD;
    private static final Field EJECTOR_RATE_FIELD;

    static {
        Field maxEnergy = null;
        Field containerRate = null;
        Field ejectorRate = null;
        try {
            maxEnergy = BasicEnergyContainer.class.getDeclaredField("maxEnergy");
            maxEnergy.setAccessible(true);
            containerRate = EnergyCubeEnergyContainer.class.getDeclaredField("rate");
            containerRate.setAccessible(true);
            ejectorRate = TileComponentEjector.class.getDeclaredField("energyEjectRate");
            ejectorRate.setAccessible(true);
        } catch (NoSuchFieldException e) {
            LogUtils.getLogger().error("[AdvancedEnergyCube] Failed to find fields via reflection", e);
        }
        MAX_ENERGY_FIELD = maxEnergy;
        CONTAINER_RATE_FIELD = containerRate;
        EJECTOR_RATE_FIELD = ejectorRate;
    }

    public TileEntityAdvancedEnergyCube(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
        // Fix ejector output rate — super() set it to EnergyCubeTier.ULTIMATE's rate
        AdvancedEnergyCubeTier tier = getAdvancedTier();
        if (tier != null && EJECTOR_RATE_FIELD != null) {
            try {
                EJECTOR_RATE_FIELD.set(ejectorComponent, (LongSupplier) tier::getOutput);
            } catch (IllegalAccessException e) {
                LogUtils.getLogger().error("[AdvancedEnergyCube] Failed to set ejector rate", e);
            }
        }
    }

    @Override
    protected IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener) {
        IEnergyContainerHolder holder = super.getInitialEnergyContainers(listener);
        // super() created the container using EnergyCubeTier.ULTIMATE — replace with our values
        AdvancedEnergyCubeTier tier = getAdvancedTier();
        if (tier != null) {
            EnergyCubeEnergyContainer container = getEnergyContainer();
            setContainerCapacity(container, tier);
        }
        return holder;
    }

    private static void setContainerCapacity(EnergyCubeEnergyContainer container, AdvancedEnergyCubeTier tier) {
        try {
            if (MAX_ENERGY_FIELD != null) {
                MAX_ENERGY_FIELD.setLong(container, tier.getMaxEnergy());
            }
            if (CONTAINER_RATE_FIELD != null) {
                CONTAINER_RATE_FIELD.set(container, (LongSupplier) tier::getOutput);
            }
        } catch (IllegalAccessException e) {
            LogUtils.getLogger().error("[AdvancedEnergyCube] Failed to set container capacity/rate", e);
        }
    }

    @Nullable
    private AdvancedEnergyCubeTier getAdvancedTier() {
        AttributeAdvancedTier attr = Attribute.get(getBlockHolder(), AttributeAdvancedTier.class);
        return attr != null ? attr.tier() : null;
    }
}
