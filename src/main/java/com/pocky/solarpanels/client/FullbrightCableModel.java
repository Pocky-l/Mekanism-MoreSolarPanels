package com.pocky.solarpanels.client;

import java.util.ArrayList;
import java.util.List;
import mekanism.client.render.lib.Quad;
import mekanism.client.render.lib.QuadTransformation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.NeoForgeRenderTypes;
import net.neoforged.neoforge.client.model.BakedModelWrapper;
import net.neoforged.neoforge.client.model.data.ModelData;

/**
 * Wraps a transmitter baked model and applies fullbright rendering to all quads.
 *
 * For in-world block rendering: fullbright lightmap + shade:false ensures cables
 * glow regardless of world lighting. ModelData-driven connection state (which sides
 * the cable connects to) is preserved by delegating every getQuads call directly to
 * TransmitterBakedModel without any caching of our own.
 *
 * For item rendering (inventory / hand / frame): the entity_cutout shader used by
 * Sheets.cutoutBlockSheet() applies directional lighting via minecraft_mix_light()
 * on vertex normals, which makes side-facing faces dark regardless of the fullbright
 * lightmap. We bypass this entirely by switching to
 * NeoForgeRenderTypes.ITEM_UNLIT_TRANSLUCENT, whose shader sets vertexColor = Color
 * with no directional computation. Combined with fullbright lightmap UV and white
 * vertex colors, every face of the item renders at full texture brightness.
 *
 * getRenderPasses is also overridden to wrap each render pass, because
 * TransmitterBakedModel.getRenderPasses returns its own (unwrapped) models,
 * bypassing this class's getQuads entirely when rendering items.
 */
@OnlyIn(Dist.CLIENT)
public class FullbrightCableModel extends BakedModelWrapper<BakedModel> {

    public FullbrightCableModel(BakedModel wrapped) {
        super(wrapped);
    }

    // Block rendering — with ModelData for connection state
    @Override
    public List<BakedQuad> getQuads(BlockState state, Direction side, RandomSource rand,
                                    ModelData data, RenderType renderType) {
        return applyFullbright(super.getQuads(state, side, rand, data, renderType));
    }

    // Fallback path used by some item rendering contexts
    @Override
    public List<BakedQuad> getQuads(BlockState state, Direction side, RandomSource rand) {
        return applyFullbright(super.getQuads(state, side, rand));
    }

    /**
     * For item rendering, use the unlit translucent render type so the item appears
     * fully bright without directional shading. In-world block rendering continues
     * to use the transmitter's own render types (cutout + translucent for glass).
     *
     * The entity_cutout shader multiplies vertex color by a directional light factor
     * computed from vertex normals (minecraft_mix_light). Even with normals forced to
     * (0,1,0), the GUI flat-light setup transforms the light directions so lightAccum
     * is not guaranteed to saturate. The unlit shader skips this entirely.
     */
    @Override
    public List<RenderType> getRenderTypes(ItemStack itemStack, boolean fabulous) {
        return List.of(NeoForgeRenderTypes.ITEM_UNLIT_TRANSLUCENT.get());
    }

    /**
     * BakedModelWrapper.applyTransform returns originalModel.applyTransform(...),
     * which is TransmitterBakedModel — our wrapper is discarded and all subsequent
     * getQuads/getRenderPasses calls bypass fullbright entirely.
     * We apply the transform side-effect (PoseStack mutation) but return `this`.
     */
    @Override
    public BakedModel applyTransform(ItemDisplayContext ctx, PoseStack poseStack, boolean leftHand) {
        originalModel.applyTransform(ctx, poseStack, leftHand);
        return this;
    }

    /**
     * TransmitterBakedModel overrides getRenderPasses and returns its own model
     * instances, not ours — so our getQuads would never be called for item rendering.
     * We wrap every pass so fullbright is applied there too.
     */
    @Override
    public List<BakedModel> getRenderPasses(ItemStack stack, boolean fabulous) {
        List<BakedModel> passes = super.getRenderPasses(stack, fabulous);
        List<BakedModel> result = new ArrayList<>(passes.size());
        for (BakedModel pass : passes) {
            result.add(pass instanceof FullbrightCableModel ? pass : new FullbrightCableModel(pass));
        }
        return result;
    }

    private List<BakedQuad> applyFullbright(List<BakedQuad> original) {
        if (original.isEmpty()) {
            return original;
        }
        List<BakedQuad> result = new ArrayList<>(original.size());
        for (BakedQuad bakedQuad : original) {
            Quad q = new Quad(bakedQuad);
            // fullbright = packedLight(LightTexture.FULL_BRIGHT): per-vertex lightmap
            // at max for world/hand/frame rendering. For item rendering the combinedLight
            // passed to putBulkData is already FULL_BRIGHT, but applyBakedLighting takes
            // max(combinedLight, bakedLight), so this is redundant yet harmless there.
            q.transform(QuadTransformation.fullbright);
            q.setShade(false);
            q.setHasAmbientOcclusion(false);
            // White vertex colors: the unlit item shader multiplies texture by Color,
            // so non-white colors would dim the output. Baked OBJ quads should already
            // be white, but force it explicitly for safety.
            // Normal (0,1,0): used for world rendering's directional lighting and AO.
            q.vertexTransform(v -> {
                v.color(255, 255, 255, 255);
                v.normal(0.0f, 1.0f, 0.0f);
            });
            result.add(q.bake());
        }
        return result;
    }
}
