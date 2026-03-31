package com.pocky.solarpanels.client;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.client.gui.GuiSolarGenerator;
import com.pocky.solarpanels.registries.SolarBlocks;
import com.pocky.solarpanels.registries.SolarContainerTypes;
import com.pocky.solarpanels.tile.TileEntitySolarGenerator;
import mekanism.client.ClientRegistration;
import mekanism.client.ClientRegistrationUtil;
import mekanism.client.model.baked.ExtensionBakedModel.TransformedBakedModel;
import mekanism.client.render.lib.QuadTransformation;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = SolarPanelsMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class SolarClientRegistration {

    private SolarClientRegistration() {
    }

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        // Big solar generators use a model with Y=-16 base (same as Mekanism's advanced_solar_generator),
        // so they need to be translated up 1 block to render correctly at surface level.
        ClientRegistration.addCustomModel(SolarBlocks.BIG_ADVANCED_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_HYBRID_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_ULTIMATE_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_QUANTUM_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_SPECTRAL_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_SINGULAR_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_PHOTONIC_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
        ClientRegistration.addCustomModel(SolarBlocks.BIG_CREATIVE_SOLAR_GENERATOR, (orig, evt) -> new TransformedBakedModel<Void>(orig, QuadTransformation.translate(0, 1, 0)));
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
