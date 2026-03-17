package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import mekanism.common.registration.MekanismDeferredHolder;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class SolarCreativeTabs {

    public static final CreativeTabDeferredRegister CREATIVE_TABS =
            new CreativeTabDeferredRegister(SolarPanelsMod.MODID, SolarCreativeTabs::addToExistingTabs);

    public static final MekanismDeferredHolder<CreativeModeTab, CreativeModeTab> SOLAR_PANELS =
            CREATIVE_TABS.registerMain(SolarLang.MEKANISM_ADVANCED_GENERATORS,
                    SolarBlocks.ADVANCED_SOLAR_PANEL.getItemHolder(), builder ->
                            builder.withSearchBar(50)
                                    .displayItems((displayParameters, output) -> {
                                        CreativeTabDeferredRegister.addToDisplay(SolarItems.ITEMS, output);
                                        CreativeTabDeferredRegister.addToDisplay(SolarBlocks.BLOCKS, output);
                                    })
            );

    private static void addToExistingTabs(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            CreativeTabDeferredRegister.addToDisplay(event,
                    SolarBlocks.ADVANCED_SOLAR_PANEL,
                    SolarBlocks.HYBRID_SOLAR_PANEL,
                    SolarBlocks.ULTIMATE_SOLAR_PANEL,
                    SolarBlocks.QUANTUM_SOLAR_PANEL,
                    SolarBlocks.SPECTRAL_SOLAR_PANEL,
                    SolarBlocks.SINGULAR_SOLAR_PANEL,
                    SolarBlocks.LIGHT_ABSORBING_SOLAR_PANEL,
                    SolarBlocks.PHOTONIC_SOLAR_PANEL,
                    SolarBlocks.CREATIVE_SOLAR_PANEL
            );
        } else if (tabKey == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            CreativeTabDeferredRegister.addToDisplay(event,
                    SolarItems.IMPROVED_ENERGY_TABLET,
                    SolarItems.QUANTUM_ENERGY_TABLET,
                    SolarItems.SPECTRAL_ENERGY_TABLET,
                    SolarItems.SINGULAR_ENERGY_TABLET,
                    SolarItems.LIGHT_ABSORBING_ENERGY_TABLET,
                    SolarItems.PHOTONIC_ENERGY_TABLET,
                    SolarItems.CREATIVE_ENERGY_TABLET
            );
        } else if (tabKey == CreativeModeTabs.INGREDIENTS) {
            CreativeTabDeferredRegister.addToDisplay(event,
                    SolarItems.CARBONE_SOLAR_ELEMENT,
                    SolarItems.HYBRID_SOLAR_ELEMENT,
                    SolarItems.IMPROVED_HYBRID_SOLAR_ELEMENT,
                    SolarItems.QUANTUM_SOLAR_ELEMENT,
                    SolarItems.SPECTRAL_SOLAR_ELEMENT,
                    SolarItems.SINGULAR_SOLAR_ELEMENT,
                    SolarItems.LIGHT_ABSORBING_SOLAR_ELEMENT,
                    SolarItems.PHOTONIC_SOLAR_ELEMENT,
                    SolarItems.CREATIVE_SOLAR_ELEMENT
            );
        }
    }
}
