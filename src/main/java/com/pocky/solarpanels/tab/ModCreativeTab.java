package com.pocky.solarpanels.tab;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.registers.BlockRegister;
import com.pocky.solarpanels.registers.ItemRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SolarPanelsMod.MODID);

    public static final RegistryObject<CreativeModeTab> HEXTALE_TAB = CREATIVE_MODE_TABS.register("solarpanels_tab",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.solarpanels.solarpanels_tab"))
            .icon(BlockRegister.QUANTUM_SOLAR_PANEL.getBlock().asItem()::getDefaultInstance)
            .displayItems((displayParameters, output) -> {
                output.accept(ItemRegister.CARBONE_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.HYBRID_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.IMPROVED_HYBRID_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.QUANTUM_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.LIGHT_ABSORBING_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.SINGULAR_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.SPECTRAL_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.PHOTONIC_SOLAR_ELEMENT.get());
                output.accept(ItemRegister.CREATIVE_SOLAR_ELEMENT.get());

                output.accept(ItemRegister.IMPROVED_ENERGY_TABLET.get());
                output.accept(ItemRegister.LIGHT_ABSORBING_ENERGY_TABLET.get());
                output.accept(ItemRegister.SPECTRAL_ENERGY_TABLET.get());
                output.accept(ItemRegister.PHOTONIC_ENERGY_TABLET.get());
                output.accept(ItemRegister.QUANTUM_ENERGY_TABLET.get());
                output.accept(ItemRegister.SINGULAR_ENERGY_TABLET.get());
                output.accept(ItemRegister.CREATIVE_ENERGY_TABLET.get());

                output.accept(BlockRegister.ADVANCED_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.HYBRID_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.ULTIMATE_HYBRID_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.QUANTUM_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.SPECTRAL_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.SINGULAR_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.LIGHT_ABSORBING_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.PHOTONIC_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
                output.accept(BlockRegister.CREATIVE_SOLAR_PANEL.getBlock().asItem().getDefaultInstance());
            })
            .build());

}
