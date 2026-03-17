package com.pocky.solarpanels.config;

import com.pocky.solarpanels.SolarPanelsMod;
import mekanism.common.config.IConfigTranslation;
import mekanism.common.config.TranslationPreset;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum SolarConfigTranslations implements IConfigTranslation {
    SERVER_GENERATOR_SOLAR("server.generator.solar", "Solar Generators", "Settings for configuring Solar Generators", true),
    SERVER_SOLAR_GENERATION("server.generator.solar.gen", "Energy Generation",
          "Peak energy generation in Joules/t for the Solar Generator. Note: It can go higher than this value in some extreme environments."),

    ENERGY_STORAGE_GENERATOR_SOLAR(TranslationPreset.ENERGY_STORAGE, "Solar Generator"),

    GEAR_ENERGY_TABLET_IMPROVED("gear.energy_tablet.improved", "Improved Energy Tablet", "Settings for Improved Energy Tablet"),
    GEAR_ENERGY_TABLET_QUANTUM("gear.energy_tablet.quantum", "Quantum Energy Tablet", "Settings for Quantum Energy Tablet"),
    GEAR_ENERGY_TABLET_SPECTRAL("gear.energy_tablet.spectral", "Spectral Energy Tablet", "Settings for Spectral Energy Tablet"),
    GEAR_ENERGY_TABLET_SINGULAR("gear.energy_tablet.singular", "Singular Energy Tablet", "Settings for Singular Energy Tablet"),
    GEAR_ENERGY_TABLET_LIGHT_ABSORBING("gear.energy_tablet.light_absorbing", "Light Absorbing Energy Tablet", "Settings for Light Absorbing Energy Tablet"),
    GEAR_ENERGY_TABLET_PHOTONIC("gear.energy_tablet.photonic", "Photonic Energy Tablet", "Settings for Photonic Energy Tablet"),
    GEAR_ENERGY_TABLET_CREATIVE("gear.energy_tablet.creative", "Creative Energy Tablet", "Settings for Creative Energy Tablet"),
    ;

    private final String key;
    private final String title;
    private final String tooltip;
    @Nullable
    private final String button;

    SolarConfigTranslations(TranslationPreset preset, String type) {
        this(preset.path(type), preset.title(type), preset.tooltip(type));
    }

    SolarConfigTranslations(String path, String title, String tooltip) {
        this(path, title, tooltip, false);
    }

    SolarConfigTranslations(String path, String title, String tooltip, boolean isSection) {
        this(path, title, tooltip, IConfigTranslation.getSectionTitle(title, isSection));
    }

    SolarConfigTranslations(String path, String title, String tooltip, @Nullable String button) {
        this.key = Util.makeDescriptionId("configuration", SolarPanelsMod.rl(path));
        this.title = title;
        this.tooltip = tooltip;
        this.button = button;
    }

    @NotNull
    @Override
    public String getTranslationKey() {
        return key;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String tooltip() {
        return tooltip;
    }

    @Nullable
    @Override
    public String button() {
        return button;
    }
}
