package com.pocky.solarpanels.client.gui;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.client.gui.element.GuiStateTexture;
import com.pocky.solarpanels.registries.SolarLang;
import com.pocky.solarpanels.tile.TileEntitySolarGenerator;
import mekanism.client.SpecialColors;
import mekanism.client.gui.GuiMekanismTile;
import mekanism.client.gui.element.GuiInnerScreen;
import mekanism.client.gui.element.GuiSideHolder;
import mekanism.client.gui.element.bar.GuiVerticalPowerBar;
import mekanism.client.gui.element.tab.GuiEnergyTab;
import mekanism.common.MekanismLang;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuiSolarGenerator<TILE extends TileEntitySolarGenerator> extends GuiMekanismTile<TILE, MekanismTileContainer<TILE>> {

    public GuiSolarGenerator(MekanismTileContainer<TILE> container, Inventory inv, Component title) {
        super(container, inv, title);
        dynamicSlots = true;
    }

    @Override
    protected void addGuiElements() {
        addRenderableWidget(GuiSideHolder.create(this, -26, 6, 98, true, true, SpecialColors.TAB_ARMOR_SLOTS));
        super.addGuiElements();
        addRenderableWidget(new GuiInnerScreen(this, 40, 23, 96, 40, () -> List.of(
                EnergyDisplay.of(tile.getEnergyContainer()).getTextComponent(),
                SolarLang.PRODUCING_AMOUNT.translate(EnergyDisplay.of(tile.getProductionRate())),
                SolarLang.OUTPUT_RATE_SHORT.translate(EnergyDisplay.of(tile.getMaxOutput()))
        )));
        addRenderableWidget(new GuiEnergyTab(this, () -> List.of(
                SolarLang.PRODUCING_AMOUNT.translate(EnergyDisplay.of(tile.getProductionRate())),
                MekanismLang.MAX_OUTPUT.translate(EnergyDisplay.of(tile.getMaxOutput()))
        )));
        addRenderableWidget(new GuiVerticalPowerBar(this, tile.getEnergyContainer(), 164, 15));
        addRenderableWidget(new GuiStateTexture(this, 18, 35, tile::canSeeSun,
                SolarPanelsMod.rl("gui/sees_sun.png"),
                SolarPanelsMod.rl("gui/no_sun.png")));
    }

    @Override
    protected void drawForegroundText(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        renderTitleText(guiGraphics);
        renderInventoryText(guiGraphics);
        super.drawForegroundText(guiGraphics, mouseX, mouseY);
    }
}
