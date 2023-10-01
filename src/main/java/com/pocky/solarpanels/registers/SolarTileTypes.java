package com.pocky.solarpanels.registers;

import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.tiles.panels.*;

/**
 * @author Dudko Roman
 */
public class SolarTileTypes {

    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(SolarPanelsMod.MODID);

    public static final TileEntityTypeRegistryObject<AdvancedSolarPanelTile> ADVANCED_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.ADVANCED_SOLAR_PANEL, AdvancedSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<HybridSolarPanelTile> HYBRID_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.HYBRID_SOLAR_PANEL, HybridSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<UltimateHybridSolarPanelTile> ULTIMATE_HYBRID_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.ULTIMATE_HYBRID_SOLAR_PANEL, UltimateHybridSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<QuantumSolarPanelTile> QUANTUM_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.QUANTUM_SOLAR_PANEL, QuantumSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<SpectralSolarPanelTile> SPECTRAL_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.SPECTRAL_SOLAR_PANEL, SpectralSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<SingularSolarPanelTile> SINGULAR_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.SINGULAR_SOLAR_PANEL, SingularSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<LightAbsorbingSolarPanelTile> LIGHT_ABSORBING_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.LIGHT_ABSORBING_SOLAR_PANEL, LightAbsorbingSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<PhotonicSolarPanelTile> PHOTONIC_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.PHOTONIC_SOLAR_PANEL, PhotonicSolarPanelTile::new);
    public static final TileEntityTypeRegistryObject<CreativeSolarPanelTile> CREATIVE_SOLAR_PANEL = TILE_ENTITY_TYPES.register(BlockRegister.CREATIVE_SOLAR_PANEL, CreativeSolarPanelTile::new);

}
