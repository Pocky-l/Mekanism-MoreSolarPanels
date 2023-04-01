package su.gamepoint.solarpanels.client;

import mekanism.client.ClientRegistrationUtil;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import su.gamepoint.solarpanels.SolarPanelsMod;
import su.gamepoint.solarpanels.client.gui.*;
import su.gamepoint.solarpanels.registers.SolarContainerTypes;
import su.gamepoint.solarpanels.tiles.panels.*;

/**
 * @author Dudko Roman
 */
@Mod.EventBusSubscriber(modid = SolarPanelsMod.MODID, value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PanelsClientRegistration {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registry.MENU_REGISTRY, helper -> {
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.ADVANCED_SOLAR_PANEL, (MekanismTileContainer<AdvancedSolarPanelTile> container, Inventory inv, Component title) -> new GuiAdvancedSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.HYBRID_SOLAR_PANEL, (MekanismTileContainer<HybridSolarPanelTile> container, Inventory inv, Component title) -> new GuiHybridSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.ULTIMATE_HYBRID_SOLAR_PANEL, (MekanismTileContainer<UltimateHybridSolarPanelTile> container, Inventory inv, Component title) -> new GuiUltimateHybridSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.QUANTUM_SOLAR_PANEL, (MekanismTileContainer<QuantumSolarPanelTile> container, Inventory inv, Component title) -> new GuiQuantumSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.SPECTRAL_SOLAR_PANEL, (MekanismTileContainer<SpectralSolarPanelTile> container, Inventory inv, Component title) -> new GuiSpectralSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.SINGULAR_SOLAR_PANEL, (MekanismTileContainer<SingularSolarPanelTile> container, Inventory inv, Component title) -> new GuiSingularSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.LIGHT_ABSORBING_SOLAR_PANEL, (MekanismTileContainer<LightAbsorbingSolarPanelTile> container, Inventory inv, Component title) -> new GuiLightAbsorbingSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.PHOTONIC_SOLAR_PANEL, (MekanismTileContainer<PhotonicSolarPanelTile> container, Inventory inv, Component title) -> new GuiPhotonicSolarPanel<>(container, inv, title));
            ClientRegistrationUtil.registerScreen(SolarContainerTypes.CREATIVE_SOLAR_PANEL, (MekanismTileContainer<CreativeSolarPanelTile> container, Inventory inv, Component title) -> new GuiCreativeSolarPanel<>(container, inv, title));
        });

    }
}
