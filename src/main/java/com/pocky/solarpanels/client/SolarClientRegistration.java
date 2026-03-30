package com.pocky.solarpanels.client;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.client.gui.GuiSolarGenerator;
import com.pocky.solarpanels.registries.SolarContainerTypes;
import com.pocky.solarpanels.tile.TileEntitySolarGenerator;
import mekanism.client.ClientRegistrationUtil;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = SolarPanelsMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class SolarClientRegistration {

    private SolarClientRegistration() {
    }

    @SuppressWarnings("Convert2MethodRef")
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.ADVANCED_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.HYBRID_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.ULTIMATE_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.QUANTUM_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.SPECTRAL_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.SINGULAR_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.LIGHT_ABSORBING_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.PHOTONIC_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.CREATIVE_SOLAR_PANEL, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_ADVANCED_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_HYBRID_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_ULTIMATE_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_QUANTUM_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_SPECTRAL_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_SINGULAR_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_PHOTONIC_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.BIG_CREATIVE_SOLAR_GENERATOR, (MekanismTileContainer<TileEntitySolarGenerator> container, Inventory inv, Component title) -> new GuiSolarGenerator<>(container, inv, title));
    }
}
