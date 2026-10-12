package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;
import mekanism.common.tile.TileEntityEnergyCube;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.tier.SolarSize;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.EnumMap;
import java.util.Map;

public final class ModContainers {
    public static final ContainerTypeDeferredRegister CONTAINERS = new ContainerTypeDeferredRegister(MekanismAdvancedGenerators.MOD_ID);

    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityEnergyCube>> ADVANCED_ENERGY_CUBE =
            CONTAINERS.custom("advanced_energy_cube", TileEntityEnergyCube.class).armorSideBar(180, 41, 0).build();

    public static final Map<SolarTier, ContainerTypeRegistryObject<MekanismTileContainer<SolarGeneratorBlockEntity>>> SOLAR_PANELS =
            new EnumMap<>(SolarTier.class);
    public static final Map<SolarTier, ContainerTypeRegistryObject<MekanismTileContainer<SolarGeneratorBlockEntity>>>
            BIG_SOLAR_GENERATORS = new EnumMap<>(SolarTier.class);

    static {
        for (SolarTier tier : SolarTier.values()) {
            SOLAR_PANELS.put(tier, solar(SolarSize.PANEL.registryName(tier)));
            BIG_SOLAR_GENERATORS.put(tier, solar(SolarSize.BIG.registryName(tier)));
        }
    }

    private ModContainers() {
    }

    private static ContainerTypeRegistryObject<MekanismTileContainer<SolarGeneratorBlockEntity>> solar(String name) {
        return CONTAINERS.custom(name, SolarGeneratorBlockEntity.class).armorSideBar(-20, 11, 0).build();
    }
}
