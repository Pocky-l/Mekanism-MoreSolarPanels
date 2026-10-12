package com.pockyl.mekanismadvancedgenerators.config;

import mekanism.common.config.IMekanismConfig;
import mekanism.common.config.MekanismConfigHelper;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.event.config.ModConfigEvent;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;

import java.util.HashMap;
import java.util.Map;

/**
 * The mod's configs. They are Mekanism configs (cached values, files under {@code Mekanism/}) and server configs, so
 * every world has its own copy in {@code serverconfig/Mekanism/}.
 */
public final class ModConfigs {
    public static final GenerationConfig GENERATION = new GenerationConfig();
    public static final StorageConfig STORAGE = new StorageConfig();
    public static final GearConfig GEAR = new GearConfig();

    private static final Map<IConfigSpec, IMekanismConfig> KNOWN_CONFIGS = new HashMap<>();

    private ModConfigs() {
    }

    public static void register(ModContainer container) {
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, container, GENERATION);
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, container, STORAGE);
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, container, GEAR);
    }

    public static void onConfigLoad(ModConfigEvent event) {
        MekanismConfigHelper.onConfigLoad(event, MekanismAdvancedGenerators.MOD_ID, KNOWN_CONFIGS);
    }
}
