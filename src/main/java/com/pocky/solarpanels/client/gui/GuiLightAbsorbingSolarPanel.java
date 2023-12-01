package com.pocky.solarpanels.client.gui;

import com.pocky.solarpanels.tiles.panels.LightAbsorbingSolarPanelTile;
import mekanism.client.gui.GuiMekanismTile;
import mekanism.client.gui.element.GuiInnerScreen;
import mekanism.client.gui.element.bar.GuiVerticalPowerBar;
import mekanism.client.gui.element.tab.GuiEnergyTab;
import mekanism.common.MekanismLang;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.text.EnergyDisplay;
import mekanism.generators.client.gui.element.GuiStateTexture;
import mekanism.generators.common.GeneratorsLang;
import mekanism.generators.common.MekanismGenerators;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

/**
 * @author Dudko Roman
 */
public class GuiLightAbsorbingSolarPanel<TILE extends LightAbsorbingSolarPanelTile> extends GuiMekanismTile<TILE, MekanismTileContainer<TILE>> {

    public GuiLightAbsorbingSolarPanel(MekanismTileContainer<TILE> container, Inventory inv, Component title) {
        super(container, inv, title);
        this.dynamicSlots = true;
    }

    @Override
    protected void addGuiElements() {
        super.addGuiElements();
        addRenderableWidget(new GuiInnerScreen(this, 48, 23, 80, 40, () -> List.of(
                EnergyDisplay.of(tile.getEnergyContainer()).getTextComponent(),
                GeneratorsLang.PRODUCING_AMOUNT.translate(EnergyDisplay.of(tile.getProductionRate())),
                GeneratorsLang.OUTPUT_RATE_SHORT.translate(EnergyDisplay.of(tile.getMaxOutput()))
        )));
        addRenderableWidget(new GuiEnergyTab(this, () -> List.of(GeneratorsLang.PRODUCING_AMOUNT.translate(EnergyDisplay.of(tile.getProductionRate())),
                MekanismLang.MAX_OUTPUT.translate(EnergyDisplay.of(tile.getMaxOutput())))));
        addRenderableWidget(new GuiVerticalPowerBar(this, tile.getEnergyContainer(), 164, 15));
        addRenderableWidget(new GuiStateTexture(this, 18, 35, tile::canSeeSun, MekanismGenerators.rl(MekanismUtils.ResourceType.GUI.getPrefix() + "sees_sun.png"),
                MekanismGenerators.rl(MekanismUtils.ResourceType.GUI.getPrefix() + "no_sun.png")));
    }
}
