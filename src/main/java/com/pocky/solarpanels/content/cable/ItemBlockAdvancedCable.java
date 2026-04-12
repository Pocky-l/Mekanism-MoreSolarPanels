package com.pocky.solarpanels.content.cable;

import java.util.List;
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
import org.jetbrains.annotations.NotNull;

@NothingNullByDefault
public class ItemBlockAdvancedCable extends ItemBlockTooltip<BlockAdvancedCable> {

    public ItemBlockAdvancedCable(BlockAdvancedCable block, Item.Properties properties) {
        super(block, true, properties.rarity(Rarity.EPIC));
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context,
            @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        AdvancedCableTier tier = getBlock().getAdvancedTier();
        tooltip.add(MekanismLang.CAPACITY_PER_TICK.translateColored(EnumColor.INDIGO, EnumColor.GRAY,
                EnergyDisplay.of(tier.getCapacity())));
    }

    @Override
    protected void addDetails(@NotNull ItemStack stack, @NotNull Item.TooltipContext context,
            @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.addDetails(stack, context, tooltip, flag);
        tooltip.add(MekanismLang.CAPABLE_OF_TRANSFERRING.translateColored(EnumColor.DARK_GRAY));
        tooltip.add(MekanismLang.GENERIC_TRANSFER.translateColored(EnumColor.PURPLE,
                MekanismLang.ENERGY_FORGE_SHORT, MekanismLang.FORGE));
        tooltip.add(MekanismLang.GENERIC_TRANSFER.translateColored(EnumColor.PURPLE,
                MekanismLang.ENERGY_JOULES_PLURAL, MekanismLang.MEKANISM));
    }
}
