package su.gamepoint.solarpanels.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
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
import su.gamepoint.solarpanels.tiles.panels.LightAbsorbingSolarPanelTile;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

/**
 * @author Dudko Roman
 */
public class GuiLightAbsorbingSolarPanel<TILE extends LightAbsorbingSolarPanelTile> extends GuiMekanismTile<TILE, MekanismTileContainer<TILE>> {

    public GuiLightAbsorbingSolarPanel(MekanismTileContainer<TILE> container, Inventory inv, Component title) {
        super(container, inv, title);
        this.dynamicSlots = true;
    }

    protected void addGuiElements() {
        super.addGuiElements();
        this.addRenderableWidget(new GuiInnerScreen(this, 48, 23, 80, 40, () -> {
            return List.of(EnergyDisplay.of(this.tile.getEnergyContainer()).getTextComponent(), GeneratorsLang.PRODUCING_AMOUNT.translate(EnergyDisplay.of(this.tile.getLastProductionAmount())), GeneratorsLang.OUTPUT_RATE_SHORT.translate(EnergyDisplay.of(this.tile.getMaxOutput())));
        }));
        this.addRenderableWidget(new GuiEnergyTab(this, () -> {
            return List.of(GeneratorsLang.PRODUCING_AMOUNT.translate(EnergyDisplay.of(this.tile.getLastProductionAmount())), MekanismLang.MAX_OUTPUT.translate(EnergyDisplay.of(this.tile.getMaxOutput())));
        }));
        this.addRenderableWidget(new GuiVerticalPowerBar(this, this.tile.getEnergyContainer(), 164, 15));
        LightAbsorbingSolarPanelTile var10006 = this.tile;
        Objects.requireNonNull(var10006);
        this.addRenderableWidget(new GuiStateTexture(this, 18, 35, var10006::canSeeSun, MekanismGenerators.rl(MekanismUtils.ResourceType.GUI.getPrefix() + "sees_sun.png"), MekanismGenerators.rl(MekanismUtils.ResourceType.GUI.getPrefix() + "no_sun.png")));
    }

    protected void drawForegroundText(@Nonnull PoseStack matrix, int mouseX, int mouseY) {
        this.renderTitleText(matrix);
        this.drawString(matrix, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, this.titleTextColor());
        super.drawForegroundText(matrix, mouseX, mouseY);
    }
}
