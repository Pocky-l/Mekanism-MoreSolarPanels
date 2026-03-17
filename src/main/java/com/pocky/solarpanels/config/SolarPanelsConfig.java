package com.pocky.solarpanels.config;

import com.pocky.solarpanels.SolarPanelsMod;
import mekanism.common.config.IMekanismConfig;
import mekanism.common.config.MekanismConfigHelper;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.event.config.ModConfigEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SolarPanelsConfig {

    private SolarPanelsConfig() {
    }

    private static final Map<IConfigSpec, IMekanismConfig> KNOWN_CONFIGS = new HashMap<>();
    public static final SolarConfig generators = new SolarConfig();
    public static final SolarStorageConfig storageConfig = new SolarStorageConfig();
    public static final SolarGearConfig gear = new SolarGearConfig();

    public static void registerConfigs(ModContainer modContainer) {
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, generators);
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, storageConfig);
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, gear);
    }

    public static void onConfigLoad(ModConfigEvent configEvent) {
        MekanismConfigHelper.onConfigLoad(configEvent, SolarPanelsMod.MODID, KNOWN_CONFIGS);
    }

    public static Collection<IMekanismConfig> getConfigs() {
        return Collections.unmodifiableCollection(KNOWN_CONFIGS.values());
    }
}
