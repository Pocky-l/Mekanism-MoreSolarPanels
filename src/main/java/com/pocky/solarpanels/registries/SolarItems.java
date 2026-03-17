package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.config.SolarPanelsConfig;
import mekanism.api.functions.ConstantPredicates;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.energy.EnergyContainersBuilder;
import mekanism.common.config.MekanismConfig;
import mekanism.common.item.ItemEnergized;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SolarItems {

    private SolarItems() {
    }

    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(SolarPanelsMod.MODID);

    // Solar element crafting ingredients
    public static final ItemRegistryObject<Item> CARBONE_SOLAR_ELEMENT = ITEMS.register("carbone_solar_element");
    public static final ItemRegistryObject<Item> HYBRID_SOLAR_ELEMENT = ITEMS.register("hybrid_solar_element");
    public static final ItemRegistryObject<Item> IMPROVED_HYBRID_SOLAR_ELEMENT = ITEMS.register("improved_hybrid_solar_element");
    public static final ItemRegistryObject<Item> QUANTUM_SOLAR_ELEMENT = ITEMS.register("quantum_solar_element");
    public static final ItemRegistryObject<Item> SPECTRAL_SOLAR_ELEMENT = ITEMS.register("spectral_solar_element");
    public static final ItemRegistryObject<Item> SINGULAR_SOLAR_ELEMENT = ITEMS.register("singular_solar_element");
    public static final ItemRegistryObject<Item> LIGHT_ABSORBING_SOLAR_ELEMENT = ITEMS.register("light_absorbing_solar_element");
    public static final ItemRegistryObject<Item> PHOTONIC_SOLAR_ELEMENT = ITEMS.register("photonic_solar_element");
    public static final ItemRegistryObject<Item> CREATIVE_SOLAR_ELEMENT = ITEMS.register("creative_solar_element");

    // Energy tablets
    public static final ItemRegistryObject<ItemEnergized> IMPROVED_ENERGY_TABLET =
            ITEMS.register("improved_energy_tablet", () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    SolarPanelsConfig.gear.improvedTabletChargeRate, SolarPanelsConfig.gear.improvedTabletMaxEnergy)
                            .build(), MekanismConfig.gear);

    public static final ItemRegistryObject<ItemEnergized> QUANTUM_ENERGY_TABLET =
            ITEMS.register("quantum_energy_tablet", () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    SolarPanelsConfig.gear.quantumTabletChargeRate, SolarPanelsConfig.gear.quantumTabletMaxEnergy)
                            .build(), MekanismConfig.gear);

    public static final ItemRegistryObject<ItemEnergized> SPECTRAL_ENERGY_TABLET =
            ITEMS.register("spectral_energy_tablet", () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    SolarPanelsConfig.gear.spectralTabletChargeRate, SolarPanelsConfig.gear.spectralTabletMaxEnergy)
                            .build(), MekanismConfig.gear);

    public static final ItemRegistryObject<ItemEnergized> SINGULAR_ENERGY_TABLET =
            ITEMS.register("singular_energy_tablet", () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    SolarPanelsConfig.gear.singularTabletChargeRate, SolarPanelsConfig.gear.singularTabletMaxEnergy)
                            .build(), MekanismConfig.gear);

    public static final ItemRegistryObject<ItemEnergized> LIGHT_ABSORBING_ENERGY_TABLET =
            ITEMS.register("light_absorbing_energy_tablet", () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    SolarPanelsConfig.gear.lightAbsorbingTabletChargeRate, SolarPanelsConfig.gear.lightAbsorbingTabletMaxEnergy)
                            .build(), MekanismConfig.gear);

    public static final ItemRegistryObject<ItemEnergized> PHOTONIC_ENERGY_TABLET =
            ITEMS.register("photonic_energy_tablet", () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    SolarPanelsConfig.gear.photonicTabletChargeRate, SolarPanelsConfig.gear.photonicTabletMaxEnergy)
                            .build(), MekanismConfig.gear);

    public static final ItemRegistryObject<ItemEnergized> CREATIVE_ENERGY_TABLET =
            ITEMS.register("creative_energy_tablet", () -> new ItemEnergized(new Item.Properties().rarity(Rarity.UNCOMMON)))
                    .addAttachedContainerCapabilities(ContainerType.ENERGY, () -> EnergyContainersBuilder.builder()
                            .addBasic(ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                                    SolarPanelsConfig.gear.creativeTabletChargeRate, SolarPanelsConfig.gear.creativeTabletMaxEnergy)
                            .build(), MekanismConfig.gear);
}
