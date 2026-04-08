package com.pocky.solarpanels.content.cable;

import com.pocky.solarpanels.registries.SolarLang;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

public class ItemBlockAdvancedCable extends BlockItem {

    public ItemBlockAdvancedCable(BlockAdvancedCable block, Item.Properties properties) {
        super(block, properties.rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(SolarLang.DESCRIPTION_ADVANCED_CABLE.translate());
    }
}
