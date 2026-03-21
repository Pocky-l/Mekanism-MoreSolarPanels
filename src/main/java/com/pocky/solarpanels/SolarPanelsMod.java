package com.pocky.solarpanels;

import com.pocky.solarpanels.config.SolarPanelsConfig;
import com.pocky.solarpanels.registries.SolarBlocks;
import com.pocky.solarpanels.registries.SolarContainerTypes;
import com.pocky.solarpanels.registries.SolarCreativeTabs;
import com.pocky.solarpanels.registries.SolarItems;
import com.pocky.solarpanels.registries.SolarSounds;
import com.pocky.solarpanels.registries.SolarTileEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(SolarPanelsMod.MODID)
public class SolarPanelsMod {

    public static final String MODID = "mekanismadvancedgenerators";

    public SolarPanelsMod(ModContainer modContainer, IEventBus modEventBus) {
        SolarPanelsConfig.registerConfigs(modContainer);
        modEventBus.addListener(SolarPanelsConfig::onConfigLoad);

        SolarItems.ITEMS.register(modEventBus);
        SolarBlocks.BLOCKS.register(modEventBus);
        SolarCreativeTabs.CREATIVE_TABS.register(modEventBus);
        SolarSounds.SOUND_EVENTS.register(modEventBus);
        SolarContainerTypes.CONTAINER_TYPES.register(modEventBus);
        SolarTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
