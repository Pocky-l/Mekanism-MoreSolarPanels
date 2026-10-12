package com.pockyl.mekanismadvancedgenerators.client.gui;

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

import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.registry.ModLang;

import java.util.List;

/**
 * Screen of every solar panel and big solar generator, laid out like Mekanism's Solar Generator.
 */
public class SolarGeneratorScreen extends GuiMekanismTile<SolarGeneratorBlockEntity, MekanismTileContainer<SolarGeneratorBlockEntity>> {

    public SolarGeneratorScreen(MekanismTileContainer<SolarGeneratorBlockEntity> container, Inventory inventory, Component title) {
        super(container, inventory, title);
        dynamicSlots = true;
    }

    @Override
    protected void addGuiElements() {
        addRenderableWidget(GuiSideHolder.create(this, -26, 6, 98, true, true, SpecialColors.TAB_ARMOR_SLOTS));
        super.addGuiElements();
        addRenderableWidget(new GuiInnerScreen(this, 40, 23, 96, 40, () -> List.of(
                EnergyDisplay.of(tile.getEnergyContainer()).getTextComponent(),
                ModLang.PRODUCING.translate(EnergyDisplay.of(tile.getProductionRate())),
                ModLang.OUTPUT_RATE_SHORT.translate(EnergyDisplay.of(tile.getMaxOutput())))));
        addRenderableWidget(new GuiEnergyTab(this, () -> List.of(
                ModLang.PRODUCING.translate(EnergyDisplay.of(tile.getProductionRate())),
                MekanismLang.MAX_OUTPUT.translate(EnergyDisplay.of(tile.getMaxOutput())))));
        addRenderableWidget(new GuiVerticalPowerBar(this, tile.getEnergyContainer(), 164, 15));
        addRenderableWidget(new SunIndicator(this, 18, 35, tile::canSeeSun));
    }

    @Override
    protected void drawForegroundText(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        renderTitleText(graphics);
        renderInventoryText(graphics);
        super.drawForegroundText(graphics, mouseX, mouseY);
    }
}
