package com.pocky.solarpanels.content.cable;

import mekanism.api.text.ILangEntry;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

public class ItemBlockAdvancedCable extends BlockItem {

    private final ILangEntry description;

    public ItemBlockAdvancedCable(BlockAdvancedCable block, Item.Properties properties, ILangEntry description) {
        super(block, properties.rarity(Rarity.EPIC));
        this.description = description;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(description.translate());
    }
}
