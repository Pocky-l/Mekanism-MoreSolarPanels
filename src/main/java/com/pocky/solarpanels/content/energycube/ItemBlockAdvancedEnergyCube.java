package com.pocky.solarpanels.content.energycube;

import java.util.List;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.functions.ConstantPredicates;
import mekanism.api.text.EnumColor;
import mekanism.client.key.MekKeyHandler;
import mekanism.client.key.MekanismKeyHandler;
import mekanism.common.MekanismLang;
import mekanism.common.attachments.containers.energy.ComponentBackedEnergyContainer;
import mekanism.common.attachments.containers.energy.EnergyContainersBuilder;
import mekanism.common.block.BlockEnergyCube;
import mekanism.common.item.block.ItemBlockEnergyCube;
import mekanism.common.util.StorageUtils;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

@NothingNullByDefault
public class ItemBlockAdvancedEnergyCube extends ItemBlockEnergyCube {

    private final AdvancedEnergyCubeTier advancedTier;

    public ItemBlockAdvancedEnergyCube(BlockEnergyCube block, Item.Properties properties, AdvancedEnergyCubeTier tier) {
        super(block, properties);
        this.advancedTier = tier;
    }

    @Override
    protected EnergyContainersBuilder addDefaultEnergyContainers(EnergyContainersBuilder builder) {
        AdvancedEnergyCubeTier tier = advancedTier;
        return builder.addContainer((type, attachedTo, containerIndex) ->
                new ComponentBackedEnergyContainer(attachedTo, containerIndex,
                        ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(),
                        tier::getOutput, tier::getMaxEnergy));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context,
            @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        StorageUtils.addStoredEnergy(stack, tooltip, true);
        tooltip.add(MekanismLang.CAPACITY.translateColored(EnumColor.INDIGO, EnumColor.GRAY,
                EnergyDisplay.of(advancedTier.getMaxEnergy())));
        if (MekKeyHandler.isKeyPressed(MekanismKeyHandler.descriptionKey)) {
            tooltip.add(getBlock().getDescription().translate());
        } else if (MekKeyHandler.isKeyPressed(MekanismKeyHandler.detailsKey)) {
            addDetails(stack, context, tooltip, flag);
        } else {
            tooltip.add(MekanismLang.HOLD_FOR_DETAILS.translateColored(EnumColor.GRAY, EnumColor.INDIGO,
                    MekanismKeyHandler.detailsKey.getTranslatedKeyMessage()));
            tooltip.add(MekanismLang.HOLD_FOR_DESCRIPTION.translateColored(EnumColor.GRAY, EnumColor.AQUA,
                    MekanismKeyHandler.descriptionKey.getTranslatedKeyMessage()));
        }
    }
}
