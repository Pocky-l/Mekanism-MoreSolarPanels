package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.api.functions.ConstantPredicates;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.energy.EnergyContainersBuilder;
import mekanism.common.item.ItemEnergized;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;
import com.pockyl.mekanismadvancedgenerators.tier.EnergyTabletTier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Crafting components and energy tablets. Registry names are part of saved worlds: never rename them
 * ({@code carbone} is an old spelling that has to stay).
 */
public final class ModItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismAdvancedGenerators.MOD_ID);

    /** Solar elements in crafting order, from the cheapest. */
    public static final List<ItemRegistryObject<Item>> SOLAR_ELEMENTS;
    public static final Map<EnergyTabletTier, ItemRegistryObject<ItemEnergized>> ENERGY_TABLETS = new EnumMap<>(EnergyTabletTier.class);

    static {
        List<ItemRegistryObject<Item>> elements = new ArrayList<>();
        for (String name : List.of("carbone", "hybrid", "improved_hybrid", "quantum", "spectral", "singular", "light_absorbing",
                "photonic", "creative")) {
            elements.add(ITEMS.register(name + "_solar_element"));
        }
        SOLAR_ELEMENTS = Collections.unmodifiableList(elements);

        for (EnergyTabletTier tier : EnergyTabletTier.values()) {
            ENERGY_TABLETS.put(tier, ITEMS
                    .register(tier.registryName(), () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    ModConfigs.GEAR.chargeRate(tier), ModConfigs.GEAR.maxEnergy(tier))
                            .build(), ModConfigs.GEAR));
        }
    }

    private ModItems() {
    }
}
