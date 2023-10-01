package com.pocky.solarpanels.registers;

import mekanism.api.math.FloatingLong;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.item.ItemEnergized;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import com.pocky.solarpanels.SolarPanelsMod;

public class ItemRegister {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(SolarPanelsMod.MODID);

    public static final ItemRegistryObject<Item> CARBONE_SOLAR_ELEMENT = ITEMS.register("carbone_solar_element");
    public static final ItemRegistryObject<Item> HYBRID_SOLAR_ELEMENT = ITEMS.register("hybrid_solar_element");
    public static final ItemRegistryObject<Item> IMPROVED_HYBRID_SOLAR_ELEMENT = ITEMS.register("improved_hybrid_solar_element");
    public static final ItemRegistryObject<Item> QUANTUM_SOLAR_ELEMENT = ITEMS.register("quantum_solar_element");
    public static final ItemRegistryObject<Item> SPECTRAL_SOLAR_ELEMENT = ITEMS.register("spectral_solar_element");
    public static final ItemRegistryObject<Item> SINGULAR_SOLAR_ELEMENT = ITEMS.register("singular_solar_element");
    public static final ItemRegistryObject<Item> LIGHT_ABSORBING_SOLAR_ELEMENT = ITEMS.register("light_absorbing_solar_element");
    public static final ItemRegistryObject<Item> PHOTONIC_SOLAR_ELEMENT = ITEMS.register("photonic_solar_element");
    public static final ItemRegistryObject<Item> CREATIVE_SOLAR_ELEMENT = ITEMS.register("creative_solar_element");

    public static final ItemRegistryObject<ItemEnergized> IMPROVED_ENERGY_TABLET = ITEMS.register("improved_energy_tablet", () -> new ItemEnergized(() -> FloatingLong.create(15000), () -> FloatingLong.create(3_000_000), BasicEnergyContainer.alwaysTrue, BasicEnergyContainer.alwaysTrue, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final ItemRegistryObject<ItemEnergized> QUANTUM_ENERGY_TABLET = ITEMS.register("quantum_energy_tablet", () -> new ItemEnergized(() -> FloatingLong.create(45000), () -> FloatingLong.create(9_000_000), BasicEnergyContainer.alwaysTrue, BasicEnergyContainer.alwaysTrue, new Item.Properties().rarity(Rarity.EPIC)));
    public static final ItemRegistryObject<ItemEnergized> SPECTRAL_ENERGY_TABLET = ITEMS.register("spectral_energy_tablet", () -> new ItemEnergized(() -> FloatingLong.create(135000), () -> FloatingLong.create(27_000_000), BasicEnergyContainer.alwaysTrue, BasicEnergyContainer.alwaysTrue, new Item.Properties().rarity(Rarity.EPIC)));
    public static final ItemRegistryObject<ItemEnergized> SINGULAR_ENERGY_TABLET = ITEMS.register("singular_energy_tablet", () -> new ItemEnergized(() -> FloatingLong.create(405000), () -> FloatingLong.create(81_000_000), BasicEnergyContainer.alwaysTrue, BasicEnergyContainer.alwaysTrue, new Item.Properties().rarity(Rarity.EPIC)));
    public static final ItemRegistryObject<ItemEnergized> LIGHT_ABSORBING_ENERGY_TABLET = ITEMS.register("light_absorbing_energy_tablet", () -> new ItemEnergized(() -> FloatingLong.create(1215000), () -> FloatingLong.create(243_000_000), BasicEnergyContainer.alwaysTrue, BasicEnergyContainer.alwaysTrue, new Item.Properties().rarity(Rarity.EPIC)));
    public static final ItemRegistryObject<ItemEnergized> PHOTONIC_ENERGY_TABLET = ITEMS.register("photonic_energy_tablet", () -> new ItemEnergized(() -> FloatingLong.create(3645000), () -> FloatingLong.create(729_000_000), BasicEnergyContainer.alwaysTrue, BasicEnergyContainer.alwaysTrue, new Item.Properties().rarity(Rarity.EPIC)));
    public static final ItemRegistryObject<ItemEnergized> CREATIVE_ENERGY_TABLET = ITEMS.register("creative_energy_tablet", () -> new ItemEnergized(() -> FloatingLong.create(10_000_000), () -> FloatingLong.create(2_000_000_000), BasicEnergyContainer.alwaysTrue, BasicEnergyContainer.alwaysTrue, new Item.Properties().rarity(Rarity.EPIC)));

}
