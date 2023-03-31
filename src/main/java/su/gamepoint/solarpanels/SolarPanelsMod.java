package su.gamepoint.solarpanels;

import mekanism.common.config.MekanismConfigHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import su.gamepoint.solarpanels.config.SolarConfig;
import su.gamepoint.solarpanels.config.SolarStorageConfig;
import su.gamepoint.solarpanels.registers.BlockRegister;
import su.gamepoint.solarpanels.registers.ItemRegister;
import su.gamepoint.solarpanels.registers.SolarContainerTypes;
import su.gamepoint.solarpanels.registers.SolarTileTypes;

@Mod(SolarPanelsMod.MODID)
public class SolarPanelsMod {

    public static final String MODID = "solarpanels";

    private static SolarStorageConfig serverConfig = new SolarStorageConfig();
    private static SolarConfig config = new SolarConfig();

    public SolarPanelsMod() {

        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModContainer modContainer = ModLoadingContext.get().getActiveContainer();
        MekanismConfigHelper.registerConfig(modContainer, serverConfig);
        MekanismConfigHelper.registerConfig(modContainer, config);

        BlockRegister.REGISTRY_BLOCK.register(eventBus);
        ItemRegister.ITEMS.register(eventBus);

        SolarTileTypes.TILE_ENTITY_TYPES.register(eventBus);
        SolarContainerTypes.CONTAINER_TYPES.register(eventBus);

        eventBus.register(this);
    }

    public static SolarStorageConfig getServerConfig() {
        return serverConfig;
    }

    public static SolarConfig getConfig() {
        return config;
    }
}
