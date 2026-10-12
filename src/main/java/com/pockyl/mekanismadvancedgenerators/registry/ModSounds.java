package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.common.registration.impl.SoundEventDeferredRegister;
import mekanism.common.registration.impl.SoundEventRegistryObject;
import net.minecraft.sounds.SoundEvent;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;

public final class ModSounds {
    public static final SoundEventDeferredRegister SOUNDS = new SoundEventDeferredRegister(MekanismAdvancedGenerators.MOD_ID);

    public static final SoundEventRegistryObject<SoundEvent> SOLAR_GENERATOR = SOUNDS.register("tile.generator.solar");

    private ModSounds() {
    }
}
