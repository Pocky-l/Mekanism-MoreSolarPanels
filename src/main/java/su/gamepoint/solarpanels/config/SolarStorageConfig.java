package su.gamepoint.solarpanels.config;

import mekanism.api.math.FloatingLong;
import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedFloatingLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import su.gamepoint.solarpanels.SolarPanelsMod;

public class SolarStorageConfig extends BaseMekanismConfig {

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

    public SolarStorageConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Generator Energy Storage Config. This config is synced from server to client.").push("storage");
        this.advancedSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "advancedSolarPanel", FloatingLong.createConst(288000L));
        this.hybridSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "hybridSolarPanel", FloatingLong.createConst(864000L));
        this.ultimateHybridSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "ultimateHybridSolarPanel", FloatingLong.createConst(2592000L));
        this.quantumSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "quantumSolarPanel", FloatingLong.createConst(7776000L));
        this.spectralSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "spectralSolarPanel", FloatingLong.createConst(23328000L));
        this.singularSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "singularSolarPanel", FloatingLong.createConst(69984000L));
        this.lightAbsorbingSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "lightAbsorbingSolarPanel", FloatingLong.createConst(209952000L));
        this.photonicSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "photonicSolarPanel", FloatingLong.createConst(629856000L));
        this.creativeSolarPanel = CachedFloatingLongValue.define(this, builder, "Base energy storage (Joules).", "creativeSolarPanel", FloatingLong.createConst(2000000000L));

        builder.pop();
        this.configSpec = builder.build();
    }

    public String getFileName() {
        return SolarPanelsMod.MODID + "-storage";
    }

    public ForgeConfigSpec getConfigSpec() {
        return this.configSpec;
    }

    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }

    public boolean addToContainer() {
        return false;
    }
}
