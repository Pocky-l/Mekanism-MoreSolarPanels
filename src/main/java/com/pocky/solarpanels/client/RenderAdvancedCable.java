package com.pocky.solarpanels.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.pocky.solarpanels.content.cable.TileEntityAdvancedCable;
import mekanism.client.render.transmitter.RenderUniversalCable;
import mekanism.common.tile.transmitter.TileEntityUniversalCable;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Delegates to Mekanism's RenderUniversalCable so that our advanced cables
 * show energy flowing inside them, just like vanilla Mekanism cables.
 * TileEntityAdvancedCable extends TileEntityUniversalCable, so the cast is safe.
 */
@OnlyIn(Dist.CLIENT)
public class RenderAdvancedCable implements BlockEntityRenderer<TileEntityAdvancedCable> {

    private final RenderUniversalCable delegate;

    public RenderAdvancedCable(BlockEntityRendererProvider.Context ctx) {
        this.delegate = new RenderUniversalCable(ctx);
    }

    @Override
    public void render(TileEntityAdvancedCable te, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        // TileEntityAdvancedCable IS-A TileEntityUniversalCable, so this is safe
        delegate.render((TileEntityUniversalCable) te, partialTick, poseStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public boolean shouldRender(TileEntityAdvancedCable te, Vec3 cameraPos) {
        return delegate.shouldRender((TileEntityUniversalCable) te, cameraPos);
    }

    @Override
    public int getViewDistance() {
        return delegate.getViewDistance();
    }
}
