package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.content.blocktype.Generator;
import com.pocky.solarpanels.tile.TileEntitySolarGenerators;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.item.ItemSlotsBuilder;
import mekanism.common.block.prefab.BlockTile.BlockTileModel;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.world.level.material.MapColor;

public class SolarBlocks {

    private SolarBlocks() {
    }

    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(SolarPanelsMod.MODID);

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Advanced, Generator<TileEntitySolarGenerators.Advanced>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Advanced, Generator<TileEntitySolarGenerators.Advanced>>>> ADVANCED_SOLAR_PANEL =
            BLOCKS.registerDetails("advanced_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.ADVANCED_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Hybrid, Generator<TileEntitySolarGenerators.Hybrid>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Hybrid, Generator<TileEntitySolarGenerators.Hybrid>>>> HYBRID_SOLAR_PANEL =
            BLOCKS.registerDetails("hybrid_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.HYBRID_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Ultimate, Generator<TileEntitySolarGenerators.Ultimate>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Ultimate, Generator<TileEntitySolarGenerators.Ultimate>>>> ULTIMATE_SOLAR_PANEL =
            BLOCKS.registerDetails("ultimate_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.ULTIMATE_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Quantum, Generator<TileEntitySolarGenerators.Quantum>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Quantum, Generator<TileEntitySolarGenerators.Quantum>>>> QUANTUM_SOLAR_PANEL =
            BLOCKS.registerDetails("quantum_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.QUANTUM_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Spectral, Generator<TileEntitySolarGenerators.Spectral>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Spectral, Generator<TileEntitySolarGenerators.Spectral>>>> SPECTRAL_SOLAR_PANEL =
            BLOCKS.registerDetails("spectral_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.SPECTRAL_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Singular, Generator<TileEntitySolarGenerators.Singular>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Singular, Generator<TileEntitySolarGenerators.Singular>>>> SINGULAR_SOLAR_PANEL =
            BLOCKS.registerDetails("singular_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.SINGULAR_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.LightAbsorbing, Generator<TileEntitySolarGenerators.LightAbsorbing>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.LightAbsorbing, Generator<TileEntitySolarGenerators.LightAbsorbing>>>> LIGHT_ABSORBING_SOLAR_PANEL =
            BLOCKS.registerDetails("light_absorbing_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.LIGHT_ABSORBING_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Photonic, Generator<TileEntitySolarGenerators.Photonic>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Photonic, Generator<TileEntitySolarGenerators.Photonic>>>> PHOTONIC_SOLAR_PANEL =
            BLOCKS.registerDetails("photonic_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.PHOTONIC_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntitySolarGenerators.Creative, Generator<TileEntitySolarGenerators.Creative>>,
            ItemBlockTooltip<BlockTileModel<TileEntitySolarGenerators.Creative, Generator<TileEntitySolarGenerators.Creative>>>> CREATIVE_SOLAR_PANEL =
            BLOCKS.registerDetails("creative_solar_panel", () -> new BlockTileModel<>(SolarBlockTypes.CREATIVE_SOLAR_PANEL, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));
}
