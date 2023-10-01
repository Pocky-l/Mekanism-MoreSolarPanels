package com.pocky.solarpanels.registers;

import mekanism.common.block.prefab.BlockTile;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.item.block.machine.ItemBlockMachine;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.generators.common.content.blocktype.Generator;
import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.tiles.panels.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class BlockRegister {

    public static final BlockDeferredRegister REGISTRY_BLOCK = new BlockDeferredRegister(SolarPanelsMod.MODID);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<AdvancedSolarPanelTile,
            Generator<AdvancedSolarPanelTile>>,
            ItemBlockMachine> ADVANCED_SOLAR_PANEL = REGISTRY_BLOCK.register("advanced_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.ADVANCED_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<HybridSolarPanelTile,
            Generator<HybridSolarPanelTile>>,
            ItemBlockMachine> HYBRID_SOLAR_PANEL = REGISTRY_BLOCK.register("hybrid_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.HYBRID_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<UltimateHybridSolarPanelTile,
            Generator<UltimateHybridSolarPanelTile>>,
            ItemBlockMachine> ULTIMATE_HYBRID_SOLAR_PANEL = REGISTRY_BLOCK.register("ultimate_hybrid_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.ULTIMATE_HYBRID_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<QuantumSolarPanelTile,
            Generator<QuantumSolarPanelTile>>,
            ItemBlockMachine> QUANTUM_SOLAR_PANEL = REGISTRY_BLOCK.register("quantum_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.QUANTUM_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<SpectralSolarPanelTile,
            Generator<SpectralSolarPanelTile>>,
            ItemBlockMachine> SPECTRAL_SOLAR_PANEL = REGISTRY_BLOCK.register("spectral_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.SPECTRAL_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<SingularSolarPanelTile,
            Generator<SingularSolarPanelTile>>,
            ItemBlockMachine> SINGULAR_SOLAR_PANEL = REGISTRY_BLOCK.register("singular_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.SINGULAR_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<LightAbsorbingSolarPanelTile,
            Generator<LightAbsorbingSolarPanelTile>>,
            ItemBlockMachine> LIGHT_ABSORBING_SOLAR_PANEL = REGISTRY_BLOCK.register("light_absorbing_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.LIGHT_ABSORBING_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<PhotonicSolarPanelTile,
            Generator<PhotonicSolarPanelTile>>,
            ItemBlockMachine> PHOTONIC_SOLAR_PANEL = REGISTRY_BLOCK.register("photonic_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.PHOTONIC_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<CreativeSolarPanelTile,
            Generator<CreativeSolarPanelTile>>,
            ItemBlockMachine> CREATIVE_SOLAR_PANEL = REGISTRY_BLOCK.register("creative_solar_panel",
            () -> new BlockTile.BlockTileModel<>(SolarTypes.CREATIVE_SOLAR_PANEL_TYPE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), ItemBlockMachine::new);
}
