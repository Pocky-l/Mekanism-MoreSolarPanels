package com.pocky.solarpanels.client;

import com.pocky.solarpanels.tile.TileEntityGenerator;
import java.util.Map;
import java.util.WeakHashMap;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.AttributeSound;
import mekanism.common.config.MekanismConfig;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.Nullable;

public class GeneratorClientSoundManager {

    private static final Map<TileEntityGenerator, State> states = new WeakHashMap<>();

    private GeneratorClientSoundManager() {}

    public static void register() {
        TileEntityGenerator.setClientCallbacks(
                GeneratorClientSoundManager::onClientTick,
                GeneratorClientSoundManager::onStop
        );
    }

    private static void onClientTick(TileEntityGenerator generator) {
        if (!generator.hasSound() || !MekanismConfig.client.enableMachineSounds.get()) {
            return;
        }
        State state = states.computeIfAbsent(generator, k -> new State());
        Minecraft mc = Minecraft.getInstance();
        if (generator.getActive() && !generator.isRemoved()) {
            if (--state.cooldown <= 0) {
                if (state.sound == null || !mc.getSoundManager().isActive(state.sound)) {
                    AttributeSound attr = Attribute.get(generator.getBlockHolder(), AttributeSound.class);
                    if (attr != null) {
                        SoundEvent sound = attr.getSound().get();
                        BlockPos pos = generator.getGeneratorSoundPos();
                        var player = mc.player;
                        if (player != null && player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) < 64.0) {
                            state.sound = new SimpleSoundInstance(
                                    sound.getLocation(),
                                    generator.getGeneratorSoundCategory(),
                                    MekanismConfig.client.baseSoundVolume.get() * generator.getGeneratorInitialVolume(),
                                    1.0F,
                                    SoundInstance.createUnseededRandom(),
                                    true,
                                    0,
                                    SoundInstance.Attenuation.LINEAR,
                                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                    false
                            );
                            mc.getSoundManager().play(state.sound);
                        }
                    }
                }
                state.cooldown = SharedConstants.TICKS_PER_SECOND;
            }
        } else if (state.sound != null) {
            mc.getSoundManager().stop(state.sound);
            state.sound = null;
            state.cooldown = 0;
        }
    }

    private static void onStop(TileEntityGenerator generator) {
        State state = states.remove(generator);
        if (state != null && state.sound != null) {
            Minecraft.getInstance().getSoundManager().stop(state.sound);
        }
    }

    private static class State {
        @Nullable SoundInstance sound;
        int cooldown;
    }
}
