package com.pockyl.mekanismadvancedgenerators.item;

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
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;

import java.util.List;

/**
 * Mekanism's energy cube item with the capacity, rate and tooltip of an {@link AdvancedEnergyCubeTier}.
 */
@NothingNullByDefault
public class AdvancedEnergyCubeItem extends ItemBlockEnergyCube {
    private final AdvancedEnergyCubeTier tier;

    public AdvancedEnergyCubeItem(BlockEnergyCube block, Item.Properties properties, AdvancedEnergyCubeTier tier) {
        super(block, properties.rarity(Rarity.EPIC));
        this.tier = tier;
    }

    @Override
    protected EnergyContainersBuilder addDefaultEnergyContainers(EnergyContainersBuilder builder) {
        return builder.addContainer((type, attachedTo, containerIndex) -> new ComponentBackedEnergyContainer(attachedTo, containerIndex,
                ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(), tier::output, tier::storage));
    }

    /** Mekanism's cube tooltip shows the capacity of its own tier; this one shows ours and otherwise matches it. */
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        StorageUtils.addStoredEnergy(stack, tooltip, true);
        tooltip.add(MekanismLang.CAPACITY.translateColored(EnumColor.INDIGO, EnumColor.GRAY, EnergyDisplay.of(tier.storage())));
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
