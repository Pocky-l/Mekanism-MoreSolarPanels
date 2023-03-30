package su.gamepoint.solarpanels.config;

import mekanism.api.math.FloatingLong;
import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedFloatingLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import su.gamepoint.solarpanels.SolarPanelsMod;

public class SolarConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;
    public final CachedFloatingLongValue advancedSolarPanel;
    public final CachedFloatingLongValue hybridSolarPanel;
    public final CachedFloatingLongValue ultimateHybridSolarPanel;
    public final CachedFloatingLongValue quantumSolarPanel;
    public final CachedFloatingLongValue spectralSolarPanel;
    public final CachedFloatingLongValue singularSolarPanel;
    public final CachedFloatingLongValue lightAbsorbingSolarPanel;
    public final CachedFloatingLongValue photonicSolarPanel;
    public final CachedFloatingLongValue creativeSolarPanel;

    public SolarConfig() {
        final String note = "Peak output for the Solar Generator. Note: It can go higher than this value in some extreme environments.";
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("MoreSolarPanels Config. This config is synced between server and client.").push(SolarPanelsMod.MODID);
        this.advancedSolarPanel = CachedFloatingLongValue.define(this, builder, note, "advancedSolarPanel", FloatingLong.createConst(150L));
        this.hybridSolarPanel = CachedFloatingLongValue.define(this, builder, note, "hybridSolarPanel", FloatingLong.createConst(450L));
        this.ultimateHybridSolarPanel = CachedFloatingLongValue.define(this, builder, note, "ultimateHybridSolarPanel", FloatingLong.createConst(1350L));
        this.quantumSolarPanel = CachedFloatingLongValue.define(this, builder, note, "quantumSolarPanel", FloatingLong.createConst(4050L));
        this.spectralSolarPanel = CachedFloatingLongValue.define(this, builder, note, "spectralSolarPanel", FloatingLong.createConst(12150L));
        this.singularSolarPanel = CachedFloatingLongValue.define(this, builder, note, "singularSolarPanel", FloatingLong.createConst(36450L));
        this.lightAbsorbingSolarPanel = CachedFloatingLongValue.define(this, builder, note, "lightAbsorbingSolarPanel", FloatingLong.createConst(109350L));
        this.photonicSolarPanel = CachedFloatingLongValue.define(this, builder, note, "photonicSolarPanel", FloatingLong.createConst(328050L));
        this.creativeSolarPanel = CachedFloatingLongValue.define(this, builder, note, "creativeSolarPanel", FloatingLong.createConst(10000000L));

        builder.pop();
        this.configSpec = builder.build();
    }

    public String getFileName() {
        return SolarPanelsMod.MODID;
    }

    public ForgeConfigSpec getConfigSpec() {
        return this.configSpec;
    }

    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }
}
