package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import mekanism.common.registration.impl.SoundEventDeferredRegister;
import mekanism.common.registration.impl.SoundEventRegistryObject;
import net.minecraft.sounds.SoundEvent;

public class SolarSounds {

    private SolarSounds() {
    }

    public static final SoundEventDeferredRegister SOUND_EVENTS = new SoundEventDeferredRegister(SolarPanelsMod.MODID);

    public static final SoundEventRegistryObject<SoundEvent> SOLAR_GENERATOR = SOUND_EVENTS.register("tile.generator.solar");
}
