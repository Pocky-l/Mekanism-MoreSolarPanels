package com.pockyl.mekanismadvancedgenerators.item;

import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import com.pockyl.mekanismadvancedgenerators.block.AdvancedCableBlock;

import java.util.List;

/**
 * Cable item with a tooltip in the style of Mekanism's Universal Cable.
 */
@NothingNullByDefault
public class AdvancedCableItem extends ItemBlockTooltip<AdvancedCableBlock> {

    public AdvancedCableItem(AdvancedCableBlock block, Item.Properties properties) {
        super(block, true, properties.rarity(Rarity.EPIC));
    }

    @Override
    protected void addStats(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(MekanismLang.CAPACITY_PER_TICK.translateColored(EnumColor.INDIGO, EnumColor.GRAY,
                EnergyDisplay.of(getBlock().getAdvancedTier().capacity())));
    }

    @Override
    protected void addDetails(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.addDetails(stack, context, tooltip, flag);
        tooltip.add(MekanismLang.CAPABLE_OF_TRANSFERRING.translateColored(EnumColor.DARK_GRAY));
        tooltip.add(MekanismLang.GENERIC_TRANSFER.translateColored(EnumColor.PURPLE, MekanismLang.ENERGY_FORGE_SHORT, MekanismLang.FORGE));
        tooltip.add(MekanismLang.GENERIC_TRANSFER.translateColored(EnumColor.PURPLE, MekanismLang.ENERGY_JOULES_PLURAL,
                MekanismLang.MEKANISM));
    }
}
