package com.pockyl.mekanismadvancedgenerators.client;

import mekanism.client.ClientRegistration;
import mekanism.client.ClientRegistrationUtil;
import mekanism.client.model.baked.ExtensionBakedModel.TransformedBakedModel;
import mekanism.client.render.RenderPropertiesProvider.MekRenderProperties;
import mekanism.client.render.item.TransmitterTypeDecorator;
import mekanism.client.render.item.block.RenderEnergyCubeItem;
import mekanism.client.render.lib.QuadTransformation;
import mekanism.client.render.tileentity.RenderEnergyCube;
import mekanism.client.render.transmitter.RenderUniversalCable;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.client.gui.AdvancedEnergyCubeScreen;
import com.pockyl.mekanismadvancedgenerators.client.gui.SolarGeneratorScreen;
import com.pockyl.mekanismadvancedgenerators.registry.ModBlockEntities;
import com.pockyl.mekanismadvancedgenerators.registry.ModBlocks;
import com.pockyl.mekanismadvancedgenerators.registry.ModContainers;

@Mod(value = MekanismAdvancedGenerators.MOD_ID, dist = Dist.CLIENT)
public final class MekanismAdvancedGeneratorsClient {

    public MekanismAdvancedGeneratorsClient(IEventBus modBus, ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modBus.addListener(MekanismAdvancedGeneratorsClient::setup);
        modBus.addListener(MekanismAdvancedGeneratorsClient::registerRenderers);
        modBus.addListener(MekanismAdvancedGeneratorsClient::registerScreens);
        modBus.addListener(MekanismAdvancedGeneratorsClient::registerItemDecorations);
        modBus.addListener(MekanismAdvancedGeneratorsClient::registerClientExtensions);
    }

    private static void setup(FMLClientSetupEvent event) {
        SolarHumSounds.register();
        // The big generators share the model of Mekanism's Advanced Solar Generator, whose origin is one block lower.
        for (BlockRegistryObject<?, ?> generator : ModBlocks.BIG_SOLAR_GENERATORS.values()) {
            ClientRegistration.addCustomModel(generator, (model, bakingEvent) ->
                    new TransformedBakedModel<Void>(model, QuadTransformation.translate(0, 1, 0)));
        }
        // Cables and cubes glow regardless of the light around them.
        for (BlockRegistryObject<?, ?> cable : ModBlocks.CABLES.values()) {
            ClientRegistration.addCustomModel(cable, (model, bakingEvent) -> new FullbrightModel(model));
        }
        for (BlockRegistryObject<?, ?> cube : ModBlocks.ENERGY_CUBES.values()) {
            ClientRegistration.addCustomModel(cube, (model, bakingEvent) -> new FullbrightModel(model));
        }
    }

    @SuppressWarnings("unchecked")
    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Energy flowing through the cables, as in Mekanism's cables.
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderUniversalCable::new,
                ModBlockEntities.CABLES.values().toArray(TileEntityTypeRegistryObject[]::new));
        // The spinning energy core inside the cube, the same as on Mekanism's cubes.
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderEnergyCube::new,
                ModBlockEntities.ENERGY_CUBES.values().toArray(TileEntityTypeRegistryObject[]::new));
    }

    private static void registerScreens(RegisterMenuScreensEvent event) {
        ClientRegistrationUtil.registerScreen(event, ModContainers.ADVANCED_ENERGY_CUBE, AdvancedEnergyCubeScreen::new);
        for (var type : ModContainers.SOLAR_PANELS.values()) {
            ClientRegistrationUtil.registerScreen(event, type, SolarGeneratorScreen::new);
        }
        for (var type : ModContainers.BIG_SOLAR_GENERATORS.values()) {
            ClientRegistrationUtil.registerScreen(event, type, SolarGeneratorScreen::new);
        }
    }

    private static void registerItemDecorations(RegisterItemDecorationsEvent event) {
        TransmitterTypeDecorator.registerDecorators(event, ModBlocks.CABLES.values().toArray(BlockRegistryObject[]::new));
    }

    private static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        ClientRegistrationUtil.registerItemExtensions(event, new MekRenderProperties(RenderEnergyCubeItem.RENDERER),
                ModBlocks.ENERGY_CUBES.values().toArray(BlockRegistryObject[]::new));
    }
}
