package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Collection;

/**
 * Everything goes into the shared "Pocky Mods" tab; machines, tools and components also into the vanilla tabs.
 * Mekanism's helper adds energy items charged, the way Mekanism shows its own.
 */
public final class ModCreativeTabs {

    private ModCreativeTabs() {
    }

    public static void register(IEventBus modBus) {
        PockyModsTab.register(modBus, () -> new ItemStack(ModBlocks.SOLAR_PANELS.values().iterator().next()), event -> {
            // Mekanism's helper hides items added through the event from the search tab; this tab is where they get there.
            CreativeModeTab.Output output = (stack, visibility) ->
                    event.accept(stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            addMachines(output);
            addItems(output, ModItems.ENERGY_TABLETS.values());
            addItems(output, ModItems.SOLAR_ELEMENTS);
        });
        modBus.addListener(ModCreativeTabs::addToVanillaTabs);
    }

    private static void addToVanillaTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            addMachines(event);
        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            addItems(event, ModItems.ENERGY_TABLETS.values());
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            addItems(event, ModItems.SOLAR_ELEMENTS);
        }
    }

    private static void addMachines(CreativeModeTab.Output output) {
        addBlocks(output, ModBlocks.SOLAR_PANELS.values());
        addBlocks(output, ModBlocks.BIG_SOLAR_GENERATORS.values());
        addBlocks(output, ModBlocks.ENERGY_CUBES.values());
        addBlocks(output, ModBlocks.CABLES.values());
    }

    private static void addBlocks(CreativeModeTab.Output output, Collection<? extends BlockRegistryObject<?, ?>> blocks) {
        for (BlockRegistryObject<?, ?> block : blocks) {
            CreativeTabDeferredRegister.addToDisplay(output, block.getItemHolder());
        }
    }

    private static void addItems(CreativeModeTab.Output output, Collection<? extends Holder<Item>> items) {
        for (Holder<Item> item : items) {
            CreativeTabDeferredRegister.addToDisplay(output, item);
        }
    }
}
