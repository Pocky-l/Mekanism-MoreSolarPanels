package com.pocky.solarpanels.client;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.client.gui.GuiAdvancedEnergyCube;
import com.pocky.solarpanels.client.gui.GuiSolarGenerator;
import com.pocky.solarpanels.registries.SolarBlocks;
import com.pocky.solarpanels.registries.SolarContainerTypes;
import com.pocky.solarpanels.registries.SolarTileEntityTypes;
import com.pocky.solarpanels.tile.TileEntitySolarGenerator;
import mekanism.client.ClientRegistration;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.client.ClientRegistrationUtil;
import mekanism.client.model.baked.ExtensionBakedModel.TransformedBakedModel;
import mekanism.client.render.RenderPropertiesProvider.MekRenderProperties;
import mekanism.client.render.item.TransmitterTypeDecorator;
import mekanism.client.render.item.block.RenderEnergyCubeItem;
import mekanism.client.render.lib.QuadTransformation;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = SolarPanelsMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class SolarClientRegistration {

    private SolarClientRegistration() {
    }

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        GeneratorClientSoundManager.register();
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
        // Emissive (fullbright) rendering for advanced cables — textures glow regardless of world lighting.
        // Uses FullbrightCableModel instead of TransformedBakedModel so that ModelData-driven connection
        // state changes (which sides the cable connects to) are not broken by caching.
        ClientRegistration.addCustomModel(SolarBlocks.COSMIC_CABLE, (orig, evt) -> new FullbrightCableModel(orig));
        ClientRegistration.addCustomModel(SolarBlocks.SUPREME_CABLE, (orig, evt) -> new FullbrightCableModel(orig));
        ClientRegistration.addCustomModel(SolarBlocks.INFINITY_CABLE, (orig, evt) -> new FullbrightCableModel(orig));
        ClientRegistration.addCustomModel(SolarBlocks.GALACTIC_CABLE, (orig, evt) -> new FullbrightCableModel(orig));
        // Same fullbright treatment for advanced energy cubes. renderBlockItem in RenderEnergyCubeItem
        // fetches the model via getBlockModelShaper, so this wrapper intercepts both in-world block
        // rendering and item rendering through the same path used for cables.
        ClientRegistration.addCustomModel(SolarBlocks.COSMIC_ENERGY_CUBE, (orig, evt) -> new FullbrightCableModel(orig));
        ClientRegistration.addCustomModel(SolarBlocks.SUPREME_ENERGY_CUBE, (orig, evt) -> new FullbrightCableModel(orig));
        ClientRegistration.addCustomModel(SolarBlocks.INFINITY_ENERGY_CUBE, (orig, evt) -> new FullbrightCableModel(orig));
        ClientRegistration.addCustomModel(SolarBlocks.GALACTIC_ENERGY_CUBE, (orig, evt) -> new FullbrightCableModel(orig));
    }

    @SubscribeEvent
    public static void registerItemDecorations(RegisterItemDecorationsEvent event) {
        TransmitterTypeDecorator.registerDecorators(event,
                SolarBlocks.COSMIC_CABLE, SolarBlocks.SUPREME_CABLE,
                SolarBlocks.INFINITY_CABLE, SolarBlocks.GALACTIC_CABLE);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(SolarTileEntityTypes.COSMIC_CABLE.get(), RenderAdvancedCable::new);
        event.registerBlockEntityRenderer(SolarTileEntityTypes.SUPREME_CABLE.get(), RenderAdvancedCable::new);
        event.registerBlockEntityRenderer(SolarTileEntityTypes.INFINITY_CABLE.get(), RenderAdvancedCable::new);
        event.registerBlockEntityRenderer(SolarTileEntityTypes.GALACTIC_CABLE.get(), RenderAdvancedCable::new);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        ClientRegistrationUtil.registerItemExtensions(event, new MekRenderProperties(RenderEnergyCubeItem.RENDERER),
                SolarBlocks.COSMIC_ENERGY_CUBE, SolarBlocks.SUPREME_ENERGY_CUBE,
                SolarBlocks.INFINITY_ENERGY_CUBE, SolarBlocks.GALACTIC_ENERGY_CUBE);
    }

    @SuppressWarnings("Convert2MethodRef")
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        ClientRegistrationUtil.registerScreen(event, SolarContainerTypes.ADVANCED_ENERGY_CUBE,
                (MekanismTileContainer<TileEntityEnergyCube> container, Inventory inv, Component title) -> new GuiAdvancedEnergyCube(container, inv, title));
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
