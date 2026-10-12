package com.pockyl.mekanismadvancedgenerators;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;
import com.pockyl.mekanismadvancedgenerators.registry.ModBlockEntities;
import com.pockyl.mekanismadvancedgenerators.registry.ModBlocks;
import com.pockyl.mekanismadvancedgenerators.registry.ModContainers;
import com.pockyl.mekanismadvancedgenerators.registry.ModCreativeTabs;
import com.pockyl.mekanismadvancedgenerators.registry.ModItems;
import com.pockyl.mekanismadvancedgenerators.registry.ModSounds;

@Mod(MekanismAdvancedGenerators.MOD_ID)
public final class MekanismAdvancedGenerators {
    public static final String MOD_ID = "mekanismadvancedgenerators";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MekanismAdvancedGenerators(IEventBus modBus, ModContainer container) {
        ModConfigs.register(container);
        modBus.addListener(ModConfigs::onConfigLoad);

        ModItems.ITEMS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modBus);
        ModContainers.CONTAINERS.register(modBus);
        ModSounds.SOUNDS.register(modBus);
        ModCreativeTabs.register(modBus);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
