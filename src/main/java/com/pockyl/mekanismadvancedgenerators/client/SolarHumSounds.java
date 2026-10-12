package com.pockyl.mekanismadvancedgenerators.client;

import mekanism.common.config.MekanismConfig;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.Nullable;

import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.registry.ModSounds;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * The hum of working solar generators, played by the client (see {@link SolarGeneratorBlockEntity#canPlaySound()} why
 * Mekanism's sound handling is not used). Respects Mekanism's machine sound settings and the muffling upgrade.
 */
final class SolarHumSounds {
    private static final double HEARING_DISTANCE_SQR = 8.0 * 8.0;
    private static final Map<SolarGeneratorBlockEntity, Hum> HUMS = new WeakHashMap<>();

    private SolarHumSounds() {
    }

    static void register() {
        SolarGeneratorBlockEntity.setClientHandlers(SolarHumSounds::tick, SolarHumSounds::stop);
    }

    private static void tick(SolarGeneratorBlockEntity generator) {
        if (!MekanismConfig.client.enableMachineSounds.get()) {
            return;
        }
        Hum hum = HUMS.computeIfAbsent(generator, key -> new Hum());
        Minecraft minecraft = Minecraft.getInstance();
        if (!generator.getActive() || generator.isRemoved()) {
            if (hum.sound != null) {
                minecraft.getSoundManager().stop(hum.sound);
                hum.sound = null;
                hum.cooldown = 0;
            }
            return;
        }
        if (--hum.cooldown > 0) {
            return;
        }
        hum.cooldown = SharedConstants.TICKS_PER_SECOND;
        if (hum.sound != null && minecraft.getSoundManager().isActive(hum.sound)) {
            return;
        }
        BlockPos pos = generator.getHumPosition();
        LocalPlayer player = minecraft.player;
        if (player == null || player.distanceToSqr(pos.getCenter()) >= HEARING_DISTANCE_SQR) {
            return;
        }
        hum.sound = new SimpleSoundInstance(ModSounds.SOLAR_GENERATOR.get().getLocation(), generator.getHumCategory(),
                MekanismConfig.client.baseSoundVolume.get() * generator.getHumVolume(), 1.0F, SoundInstance.createUnseededRandom(),
                true, 0, SoundInstance.Attenuation.LINEAR, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, false);
        minecraft.getSoundManager().play(hum.sound);
    }

    private static void stop(SolarGeneratorBlockEntity generator) {
        Hum hum = HUMS.remove(generator);
        if (hum != null && hum.sound != null) {
            Minecraft.getInstance().getSoundManager().stop(hum.sound);
        }
    }

    private static final class Hum {
        @Nullable
        private SoundInstance sound;
        private int cooldown;
    }
}
