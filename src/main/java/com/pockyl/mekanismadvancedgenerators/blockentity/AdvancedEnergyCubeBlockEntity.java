package com.pockyl.mekanismadvancedgenerators.blockentity;

import mekanism.api.IContentsListener;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;
import com.pockyl.mekanismadvancedgenerators.tier.EnergyCubeAttribute;

import java.lang.reflect.Field;
import java.util.function.LongSupplier;

/**
 * Mekanism's Energy Cube with the capacity and output of an {@link AdvancedEnergyCubeTier}.
 * <p>
 * Mekanism's cube takes both values from its own tier enum, which cannot be extended, so the block carries Mekanism's
 * Ultimate tier and this class overwrites three private final values after Mekanism created them: the container's
 * capacity and rate and the ejector's rate. Reusing the real cube keeps Mekanism's GUI, side config, renderer,
 * upgrade data and save format working.
 * <p>
 * Should a future Mekanism rename one of these fields, the cubes keep working with the values of Mekanism's Ultimate
 * cube and the log says why, instead of crashing every world that contains a cube. The game test
 * {@code energyCubesUseTheirTier} catches that case in development.
 */
public class AdvancedEnergyCubeBlockEntity extends TileEntityEnergyCube {
    @Nullable
    private static final Field CONTAINER_MAX_ENERGY = findField(BasicEnergyContainer.class, "maxEnergy");
    @Nullable
    private static final Field CONTAINER_RATE = findField(EnergyCubeEnergyContainer.class, "rate");
    @Nullable
    private static final Field EJECTOR_RATE = findField(TileComponentEjector.class, "energyEjectRate");

    public AdvancedEnergyCubeBlockEntity(Holder<Block> block, BlockPos pos, BlockState state) {
        super(block, pos, state);
        AdvancedEnergyCubeTier tier = getAdvancedTier();
        setField(EJECTOR_RATE, ejectorComponent, (LongSupplier) tier::output);
    }

    public AdvancedEnergyCubeTier getAdvancedTier() {
        return Attribute.getOrThrow(getBlockHolder(), EnergyCubeAttribute.class).tier();
    }

    @NotNull
    @Override
    protected IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener) {
        IEnergyContainerHolder holder = super.getInitialEnergyContainers(listener);
        AdvancedEnergyCubeTier tier = getAdvancedTier();
        EnergyCubeEnergyContainer container = getEnergyContainer();
        setField(CONTAINER_MAX_ENERGY, container, tier.storage());
        setField(CONTAINER_RATE, container, (LongSupplier) tier::output);
        return holder;
    }

    @Nullable
    private static Field findField(Class<?> owner, String name) {
        try {
            Field field = owner.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (ReflectiveOperationException | RuntimeException e) {
            MekanismAdvancedGenerators.LOGGER.error("Mekanism no longer has {}.{}: energy cubes of {} fall back to the values "
                    + "of Mekanism's Ultimate Energy Cube until the mod is updated", owner.getName(), name,
                    MekanismAdvancedGenerators.MOD_ID, e);
            return null;
        }
    }

    private static void setField(@Nullable Field field, Object target, Object value) {
        if (field == null) {
            return;
        }
        try {
            field.set(target, value);
        } catch (ReflectiveOperationException | RuntimeException e) {
            MekanismAdvancedGenerators.LOGGER.error("Cannot set {}", field, e);
        }
    }
}
