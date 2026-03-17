package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.tile.TileEntitySolarGenerator;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

public class SolarContainerTypes {

    private SolarContainerTypes() {
    }

    public static final ContainerTypeDeferredRegister CONTAINER_TYPES = new ContainerTypeDeferredRegister(SolarPanelsMod.MODID);

    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> ADVANCED_SOLAR_PANEL =
            CONTAINER_TYPES.custom("advanced_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> HYBRID_SOLAR_PANEL =
            CONTAINER_TYPES.custom("hybrid_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> ULTIMATE_SOLAR_PANEL =
            CONTAINER_TYPES.custom("ultimate_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> QUANTUM_SOLAR_PANEL =
            CONTAINER_TYPES.custom("quantum_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> SPECTRAL_SOLAR_PANEL =
            CONTAINER_TYPES.custom("spectral_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> SINGULAR_SOLAR_PANEL =
            CONTAINER_TYPES.custom("singular_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> LIGHT_ABSORBING_SOLAR_PANEL =
            CONTAINER_TYPES.custom("light_absorbing_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> PHOTONIC_SOLAR_PANEL =
            CONTAINER_TYPES.custom("photonic_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySolarGenerator>> CREATIVE_SOLAR_PANEL =
            CONTAINER_TYPES.custom("creative_solar_panel", TileEntitySolarGenerator.class).armorSideBar(-20, 11, 0).build();
}
