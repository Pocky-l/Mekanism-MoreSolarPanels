package com.pocky.solarpanels.client.gui;

import com.pocky.solarpanels.content.energycube.AdvancedEnergyCubeTier;
import com.pocky.solarpanels.content.energycube.AttributeAdvancedTier;
import java.util.List;
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
import org.jetbrains.annotations.NotNull;

@NothingNullByDefault
public class GuiAdvancedEnergyCube extends GuiConfigurableTile<TileEntityEnergyCube, MekanismTileContainer<TileEntityEnergyCube>> {

    public GuiAdvancedEnergyCube(MekanismTileContainer<TileEntityEnergyCube> container, Inventory inv, Component title) {
        super(container, inv, title);
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
        long outputRate = getOutputRate();
        addRenderableWidget(new GuiEnergyTab(this, () -> List.of(
                MekanismLang.MATRIX_INPUT_RATE.translate(EnergyDisplay.of(tile.getInputRate())),
                MekanismLang.MAX_OUTPUT.translate(EnergyDisplay.of(outputRate))
        )));
    }

    private long getOutputRate() {
        AttributeAdvancedTier attr = Attribute.get(tile.getBlockHolder(), AttributeAdvancedTier.class);
        if (attr != null) {
            return attr.tier().getOutput();
        }
        return tile.getTier().getOutput();
    }

    @Override
    protected void drawForegroundText(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        renderTitleText(guiGraphics);
        renderInventoryText(guiGraphics);
        super.drawForegroundText(guiGraphics, mouseX, mouseY);
    }
}
