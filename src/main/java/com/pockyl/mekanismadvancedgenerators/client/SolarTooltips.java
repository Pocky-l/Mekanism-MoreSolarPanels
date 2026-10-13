package com.pockyl.mekanismadvancedgenerators.client;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;
import com.pockyl.mekanismadvancedgenerators.registry.ModLang;
import com.pockyl.mekanismadvancedgenerators.tier.SolarAttribute;

import java.util.List;

/**
 * Peak generation and buffer of solar panels and big solar generators right under the item name, from the current
 * config, so the tiers can be compared in the inventory.
 */
final class SolarTooltips {
    private SolarTooltips() {
    }

    static void onTooltip(ItemTooltipEvent event) {
        if (!(event.getItemStack().getItem() instanceof BlockItem item)) {
            return;
        }
        SolarAttribute solar = Attribute.get(item.getBlock().builtInRegistryHolder(), SolarAttribute.class);
        if (solar == null) {
            return;
        }
        List<Component> tooltip = event.getToolTip();
        int at = Math.min(1, tooltip.size());
        tooltip.add(at, MekanismLang.CAPACITY.translateColored(EnumColor.INDIGO, EnumColor.GRAY,
                EnergyDisplay.of(ModConfigs.STORAGE.solarStorage(solar.tier(), solar.size()).get())));
        tooltip.add(at, ModLang.PEAK_GENERATION.translateColored(EnumColor.INDIGO, EnumColor.GRAY,
                EnergyDisplay.of(ModConfigs.GENERATION.generation(solar.tier(), solar.size()).get())));
    }
}
