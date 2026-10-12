package com.pockyl.mekanismadvancedgenerators.integration.jade;

import mekanism.api.text.EnumColor;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.registry.ModLang;

/**
 * Adds the current production and whether the generator sees the sun under Mekanism's energy bar in Jade.
 * The values only exist on the server, so they travel in Jade's server data.
 */
enum SolarGeneratorProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    static final ResourceLocation UID = MekanismAdvancedGenerators.id("solar_generator");
    private static final String PRODUCTION = "production";
    private static final String SEES_SUN = "sees_sun";

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor) {
        if (accessor.getBlockEntity() instanceof SolarGeneratorBlockEntity generator) {
            data.putLong(PRODUCTION, generator.getProductionRate());
            data.putBoolean(SEES_SUN, generator.canSeeSun());
        }
    }

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        CompoundTag data = accessor.getServerData();
        if (!data.contains(PRODUCTION)) {
            return;
        }
        tooltip.add(ModLang.PRODUCING.translateColored(EnumColor.GRAY, EnergyDisplay.of(data.getLong(PRODUCTION))));
        Component sun = data.getBoolean(SEES_SUN) ? ModLang.SEES_SUN.translateColored(EnumColor.YELLOW)
                : ModLang.NO_SUN.translateColored(EnumColor.RED);
        tooltip.add(sun);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }
}
