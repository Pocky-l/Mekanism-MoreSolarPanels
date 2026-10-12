package com.pockyl.mekanismadvancedgenerators.client.gui;

import mekanism.api.annotations.NothingNullByDefault;
import mekanism.client.SpecialColors;
import mekanism.client.gui.GuiConfigurableTile;
import mekanism.client.gui.element.GuiSideHolder;
import mekanism.client.gui.element.gauge.GaugeType;
import mekanism.client.gui.element.gauge.GuiEnergyGauge;
import mekanism.client.gui.element.tab.GuiEnergyTab;
import mekanism.client.gui.element.tab.GuiSecurityTab;
import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import com.pockyl.mekanismadvancedgenerators.tier.EnergyCubeAttribute;

import java.util.List;

/**
 * Mekanism's energy cube screen, but the energy tab shows the output rate of our tier instead of Mekanism's Ultimate.
 */
@NothingNullByDefault
public class AdvancedEnergyCubeScreen extends GuiConfigurableTile<TileEntityEnergyCube, MekanismTileContainer<TileEntityEnergyCube>> {

    public AdvancedEnergyCubeScreen(MekanismTileContainer<TileEntityEnergyCube> container, Inventory inventory, Component title) {
        super(container, inventory, title);
        dynamicSlots = true;
    }

    @Override
    protected void addSecurityTab() {
        addRenderableWidget(new GuiSecurityTab(this, tile, 6));
    }

    @Override
    protected void addGuiElements() {
        addRenderableWidget(GuiSideHolder.create(this, imageWidth, 36, 98, false, true, SpecialColors.TAB_ARMOR_SLOTS));
        super.addGuiElements();
        addRenderableWidget(new GuiEnergyGauge(tile.getEnergyContainer(), GaugeType.WIDE, this, 55, 18));
        addRenderableWidget(new GuiEnergyTab(this, () -> List.of(
                MekanismLang.MATRIX_INPUT_RATE.translate(EnergyDisplay.of(tile.getInputRate())),
                MekanismLang.MAX_OUTPUT.translate(EnergyDisplay.of(outputRate())))));
    }

    private long outputRate() {
        EnergyCubeAttribute attribute = Attribute.get(tile.getBlockHolder(), EnergyCubeAttribute.class);
        return attribute != null ? attribute.tier().output() : tile.getTier().getOutput();
    }

    @Override
    protected void drawForegroundText(GuiGraphics graphics, int mouseX, int mouseY) {
        renderTitleText(graphics);
        renderInventoryText(graphics);
        super.drawForegroundText(graphics, mouseX, mouseY);
    }
}
