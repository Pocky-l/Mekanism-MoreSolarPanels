package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.tile.TileEntitySolarGenerators;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

public class SolarTileEntityTypes {

    private SolarTileEntityTypes() {
    }

    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(SolarPanelsMod.MODID);

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Advanced> ADVANCED_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.ADVANCED_SOLAR_PANEL, TileEntitySolarGenerators.Advanced::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Hybrid> HYBRID_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.HYBRID_SOLAR_PANEL, TileEntitySolarGenerators.Hybrid::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Ultimate> ULTIMATE_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.ULTIMATE_SOLAR_PANEL, TileEntitySolarGenerators.Ultimate::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Quantum> QUANTUM_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.QUANTUM_SOLAR_PANEL, TileEntitySolarGenerators.Quantum::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Spectral> SPECTRAL_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.SPECTRAL_SOLAR_PANEL, TileEntitySolarGenerators.Spectral::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Singular> SINGULAR_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.SINGULAR_SOLAR_PANEL, TileEntitySolarGenerators.Singular::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.LightAbsorbing> LIGHT_ABSORBING_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.LIGHT_ABSORBING_SOLAR_PANEL, TileEntitySolarGenerators.LightAbsorbing::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Photonic> PHOTONIC_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.PHOTONIC_SOLAR_PANEL, TileEntitySolarGenerators.Photonic::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntitySolarGenerators.Creative> CREATIVE_SOLAR_PANEL =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.CREATIVE_SOLAR_PANEL, TileEntitySolarGenerators.Creative::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();
}
