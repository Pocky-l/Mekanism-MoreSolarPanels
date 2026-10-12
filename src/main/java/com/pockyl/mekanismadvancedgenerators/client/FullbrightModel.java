package com.pockyl.mekanismadvancedgenerators.client;

import com.mojang.blaze3d.vertex.PoseStack;
import mekanism.client.render.lib.Quad;
import mekanism.client.render.lib.QuadTransformation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.NeoForgeRenderTypes;
import net.neoforged.neoforge.client.model.BakedModelWrapper;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Renders a cable or energy cube model at full brightness, in the world and as an item.
 * <p>
 * In the world every quad gets the full-bright lightmap, no shading and no ambient occlusion. Quads are transformed on
 * every call, never cached, so the connection state that Mekanism passes in {@link ModelData} keeps working.
 * <p>
 * Items need more: the item shader darkens side faces by their normals whatever the lightmap says, so items use
 * NeoForge's unlit translucent render type. Mekanism's transmitter model returns its own unwrapped models from
 * {@link #applyTransform} and {@link #getRenderPasses}; both are overridden to keep this wrapper in place.
 */
public final class FullbrightModel extends BakedModelWrapper<BakedModel> {

    public FullbrightModel(BakedModel wrapped) {
        super(wrapped);
    }

    @NotNull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource random,
            @NotNull ModelData data, @Nullable RenderType renderType) {
        return fullbright(super.getQuads(state, side, random, data, renderType));
    }

    @NotNull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource random) {
        return fullbright(super.getQuads(state, side, random));
    }

    @NotNull
    @Override
    public List<RenderType> getRenderTypes(@NotNull ItemStack stack, boolean fabulous) {
        return List.of(NeoForgeRenderTypes.ITEM_UNLIT_TRANSLUCENT.get());
    }

    @NotNull
    @Override
    public BakedModel applyTransform(@NotNull ItemDisplayContext context, @NotNull PoseStack poseStack, boolean leftHand) {
        originalModel.applyTransform(context, poseStack, leftHand);
        return this;
    }

    @NotNull
    @Override
    public List<BakedModel> getRenderPasses(@NotNull ItemStack stack, boolean fabulous) {
        List<BakedModel> passes = super.getRenderPasses(stack, fabulous);
        List<BakedModel> wrapped = new ArrayList<>(passes.size());
        for (BakedModel pass : passes) {
            wrapped.add(pass instanceof FullbrightModel ? pass : new FullbrightModel(pass));
        }
        return wrapped;
    }

    private static List<BakedQuad> fullbright(List<BakedQuad> quads) {
        if (quads.isEmpty()) {
            return quads;
        }
        List<BakedQuad> result = new ArrayList<>(quads.size());
        for (BakedQuad bakedQuad : quads) {
            Quad quad = new Quad(bakedQuad);
            quad.transform(QuadTransformation.fullbright);
            quad.setShade(false);
            quad.setHasAmbientOcclusion(false);
            // The unlit item shader multiplies the texture by the vertex color, so force white; the up normal keeps
            // world rendering from shading the faces.
            quad.vertexTransform(vertex -> {
                vertex.color(255, 255, 255, 255);
                vertex.normal(0.0F, 1.0F, 0.0F);
            });
            result.add(quad.bake());
        }
        return result;
    }
}
