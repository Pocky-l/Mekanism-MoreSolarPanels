package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.content.cable.TileEntityAdvancedCable;
import com.pocky.solarpanels.content.cable.TileEntityAdvancedCables;
import com.pocky.solarpanels.tile.TileEntityBigSolarGenerators;
import com.pocky.solarpanels.tile.TileEntitySolarGenerators;
import mekanism.common.block.BlockEnergyCube;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.integration.energy.EnergyCompatUtils;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.neoforged.neoforge.registries.DeferredHolder;

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

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Advanced> BIG_ADVANCED_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_ADVANCED_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Advanced::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Hybrid> BIG_HYBRID_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_HYBRID_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Hybrid::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Ultimate> BIG_ULTIMATE_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_ULTIMATE_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Ultimate::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Quantum> BIG_QUANTUM_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_QUANTUM_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Quantum::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Spectral> BIG_SPECTRAL_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_SPECTRAL_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Spectral::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Singular> BIG_SINGULAR_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_SINGULAR_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Singular::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.LightAbsorbing> BIG_LIGHT_ABSORBING_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, TileEntityBigSolarGenerators.LightAbsorbing::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Photonic> BIG_PHOTONIC_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_PHOTONIC_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Photonic::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityBigSolarGenerators.Creative> BIG_CREATIVE_SOLAR_GENERATOR =
            TILE_ENTITY_TYPES.mekBuilder(SolarBlocks.BIG_CREATIVE_SOLAR_GENERATOR, TileEntityBigSolarGenerators.Creative::new)
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityAdvancedCable> COSMIC_CABLE = registerAdvancedCable(SolarBlocks.COSMIC_CABLE, TileEntityAdvancedCables.Cosmic::new);
    public static final TileEntityTypeRegistryObject<TileEntityAdvancedCable> SUPREME_CABLE = registerAdvancedCable(SolarBlocks.SUPREME_CABLE, TileEntityAdvancedCables.Supreme::new);
    public static final TileEntityTypeRegistryObject<TileEntityAdvancedCable> INFINITY_CABLE = registerAdvancedCable(SolarBlocks.INFINITY_CABLE, TileEntityAdvancedCables.Infinity::new);
    public static final TileEntityTypeRegistryObject<TileEntityAdvancedCable> GALACTIC_CABLE = registerAdvancedCable(SolarBlocks.GALACTIC_CABLE, TileEntityAdvancedCables.Galactic::new);

    private static TileEntityTypeRegistryObject<TileEntityAdvancedCable> registerAdvancedCable(
            net.neoforged.neoforge.registries.DeferredHolder<net.minecraft.world.level.block.Block, ?> block,
            net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier<TileEntityAdvancedCable> factory) {
        var builder = TILE_ENTITY_TYPES.builder(block, factory)
                .serverTicker(TileEntityTransmitter::tickServer)
                .withSimple(Capabilities.ALLOY_INTERACTION)
                .with(Capabilities.CONFIGURABLE, TileEntityTransmitter.CONFIGURABLE_PROVIDER);
        EnergyCompatUtils.addBlockCapabilities(builder);
        return builder.build();
    }

    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> COSMIC_ENERGY_CUBE = registerAdvancedEnergyCube(SolarBlocks.COSMIC_ENERGY_CUBE);
    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> SUPREME_ENERGY_CUBE = registerAdvancedEnergyCube(SolarBlocks.SUPREME_ENERGY_CUBE);
    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> INFINITY_ENERGY_CUBE = registerAdvancedEnergyCube(SolarBlocks.INFINITY_ENERGY_CUBE);
    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> GALACTIC_ENERGY_CUBE = registerAdvancedEnergyCube(SolarBlocks.GALACTIC_ENERGY_CUBE);

    private static TileEntityTypeRegistryObject<TileEntityEnergyCube> registerAdvancedEnergyCube(
            DeferredHolder<net.minecraft.world.level.block.Block, BlockEnergyCube> block) {
        return TILE_ENTITY_TYPES.mekBuilder(block, (pos, state) -> new TileEntityEnergyCube(block, pos, state))
                .serverTicker(TileEntityMekanism::tickServer)
                .withSimple(Capabilities.CONFIG_CARD)
                .build();
    }
}
