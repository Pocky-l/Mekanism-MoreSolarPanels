package com.pockyl.mekanismadvancedgenerators.config;

import mekanism.common.config.IConfigTranslation;
import mekanism.common.config.IConfigTranslation.ConfigTranslation;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Builds the titles and tooltips of the config screen. Every translation created here needs entries in the lang files
 * ({@code <key>}, {@code <key>.tooltip} and, for sections, {@code <key>.button}); a game test checks that.
 */
public final class ConfigTranslations {
    private static final List<IConfigTranslation> ALL = new ArrayList<>();

    private ConfigTranslations() {
    }

    static IConfigTranslation section(String path, String title, String tooltip) {
        return add(new ConfigTranslation(key(path), title, tooltip, true));
    }

    static IConfigTranslation value(String path, String title, String tooltip) {
        return add(new ConfigTranslation(key(path), title, tooltip));
    }

    public static List<IConfigTranslation> all() {
        return Collections.unmodifiableList(ALL);
    }

    private static String key(String path) {
        return "configuration." + MekanismAdvancedGenerators.MOD_ID + "." + path;
    }

    private static IConfigTranslation add(IConfigTranslation translation) {
        ALL.add(translation);
        return translation;
    }
}
