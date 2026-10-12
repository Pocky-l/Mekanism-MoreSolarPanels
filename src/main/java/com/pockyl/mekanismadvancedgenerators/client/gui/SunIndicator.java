package com.pockyl.mekanismadvancedgenerators.client.gui;

import mekanism.client.gui.IGuiWrapper;
import mekanism.client.gui.element.GuiTexturedElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.registry.ModLang;

import java.util.function.BooleanSupplier;

/**
 * A sun or a crossed-out sun in a slot frame, with a tooltip: whether the generator sees the sky.
 */
public class SunIndicator extends GuiTexturedElement {
    private static final ResourceLocation FRAME = MekanismAdvancedGenerators.id("gui/state_holder.png");
    private static final ResourceLocation SUN = MekanismAdvancedGenerators.id("gui/sees_sun.png");
    private static final ResourceLocation NO_SUN = MekanismAdvancedGenerators.id("gui/no_sun.png");

    private final BooleanSupplier seesSun;

    public SunIndicator(IGuiWrapper gui, int x, int y, BooleanSupplier seesSun) {
        super(FRAME, gui, x, y, 16, 16);
        this.seesSun = seesSun;
    }

    @Override
    public void drawBackground(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        graphics.blit(getResource(), relativeX, relativeY, 0, 0, width, height, width, height);
        ResourceLocation icon = seesSun.getAsBoolean() ? SUN : NO_SUN;
        graphics.blit(icon, relativeX + 2, relativeY + 2, 0, 0, width - 4, height - 4, width - 4, height - 4);
    }

    @Override
    public void updateTooltip(int mouseX, int mouseY) {
        setTooltip(seesSun.getAsBoolean() ? ModLang.SEES_SUN : ModLang.NO_SUN);
    }
}
