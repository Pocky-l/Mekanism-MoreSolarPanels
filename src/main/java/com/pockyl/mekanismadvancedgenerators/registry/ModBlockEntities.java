package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.common.capabilities.Capabilities;
import mekanism.common.integration.energy.EnergyCompatUtils;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister.BlockEntityTypeBuilder;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.transmitter.TileEntityTransmitter;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.blockentity.AdvancedCableBlockEntity;
import com.pockyl.mekanismadvancedgenerators.blockentity.AdvancedEnergyCubeBlockEntity;
import com.pockyl.mekanismadvancedgenerators.blockentity.BigSolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.EnumMap;
import java.util.Map;

/**
 * Block entity types; each is named after its block.
 */
public final class ModBlockEntities {
    public static final TileEntityTypeDeferredRegister BLOCK_ENTITIES =
            new TileEntityTypeDeferredRegister(MekanismAdvancedGenerators.MOD_ID);

    public static final Map<SolarTier, TileEntityTypeRegistryObject<SolarGeneratorBlockEntity>> SOLAR_PANELS =
            new EnumMap<>(SolarTier.class);
    public static final Map<SolarTier, TileEntityTypeRegistryObject<BigSolarGeneratorBlockEntity>> BIG_SOLAR_GENERATORS =
            new EnumMap<>(SolarTier.class);
    public static final Map<AdvancedCableTier, TileEntityTypeRegistryObject<AdvancedCableBlockEntity>> CABLES =
            new EnumMap<>(AdvancedCableTier.class);
    public static final Map<AdvancedEnergyCubeTier, TileEntityTypeRegistryObject<TileEntityEnergyCube>> ENERGY_CUBES =
            new EnumMap<>(AdvancedEnergyCubeTier.class);

    static {
        for (SolarTier tier : SolarTier.values()) {
            var panel = ModBlocks.SOLAR_PANELS.get(tier);
            SOLAR_PANELS.put(tier, BLOCK_ENTITIES
                    .<SolarGeneratorBlockEntity>mekBuilder(panel, (pos, state) -> new SolarGeneratorBlockEntity(panel, pos, state))
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build());
            var big = ModBlocks.BIG_SOLAR_GENERATORS.get(tier);
            BIG_SOLAR_GENERATORS.put(tier, BLOCK_ENTITIES
                    .<BigSolarGeneratorBlockEntity>mekBuilder(big, (pos, state) -> new BigSolarGeneratorBlockEntity(big, pos, state))
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.EVAPORATION_SOLAR)
                    .build());
        }
        for (AdvancedCableTier tier : AdvancedCableTier.values()) {
            var cable = ModBlocks.CABLES.get(tier);
            BlockEntityTypeBuilder<AdvancedCableBlockEntity> builder = BLOCK_ENTITIES
                    .<AdvancedCableBlockEntity>builder(cable, (pos, state) -> new AdvancedCableBlockEntity(cable, pos, state))
                    .serverTicker(TileEntityTransmitter::tickServer)
                    .withSimple(Capabilities.ALLOY_INTERACTION)
                    .with(Capabilities.CONFIGURABLE, TileEntityTransmitter.CONFIGURABLE_PROVIDER);
            EnergyCompatUtils.addBlockCapabilities(builder);
            CABLES.put(tier, builder.build());
        }
        for (AdvancedEnergyCubeTier tier : AdvancedEnergyCubeTier.values()) {
            var cube = ModBlocks.ENERGY_CUBES.get(tier);
            ENERGY_CUBES.put(tier, BLOCK_ENTITIES
                    .<TileEntityEnergyCube>mekBuilder(cube, (pos, state) -> new AdvancedEnergyCubeBlockEntity(cube, pos, state))
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build());
        }
    }

    private ModBlockEntities() {
    }
}
