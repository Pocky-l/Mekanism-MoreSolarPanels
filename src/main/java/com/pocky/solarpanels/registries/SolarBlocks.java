package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.content.blocktype.Generator;
import com.pocky.solarpanels.content.cable.AdvancedCableTier;
import com.pocky.solarpanels.content.cable.BlockAdvancedCable;
import com.pocky.solarpanels.tile.TileEntityBigSolarGenerators;
import com.pocky.solarpanels.tile.TileEntitySolarGenerators;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.item.ItemSlotsBuilder;
import mekanism.common.block.prefab.BlockTile.BlockTileModel;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.world.item.BlockItem;
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

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Advanced, Generator<TileEntityBigSolarGenerators.Advanced>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Advanced, Generator<TileEntityBigSolarGenerators.Advanced>>>> BIG_ADVANCED_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_advanced_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_ADVANCED_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Hybrid, Generator<TileEntityBigSolarGenerators.Hybrid>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Hybrid, Generator<TileEntityBigSolarGenerators.Hybrid>>>> BIG_HYBRID_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_hybrid_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_HYBRID_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Ultimate, Generator<TileEntityBigSolarGenerators.Ultimate>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Ultimate, Generator<TileEntityBigSolarGenerators.Ultimate>>>> BIG_ULTIMATE_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_ultimate_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_ULTIMATE_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Quantum, Generator<TileEntityBigSolarGenerators.Quantum>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Quantum, Generator<TileEntityBigSolarGenerators.Quantum>>>> BIG_QUANTUM_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_quantum_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_QUANTUM_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Spectral, Generator<TileEntityBigSolarGenerators.Spectral>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Spectral, Generator<TileEntityBigSolarGenerators.Spectral>>>> BIG_SPECTRAL_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_spectral_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_SPECTRAL_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Singular, Generator<TileEntityBigSolarGenerators.Singular>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Singular, Generator<TileEntityBigSolarGenerators.Singular>>>> BIG_SINGULAR_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_singular_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_SINGULAR_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.LightAbsorbing, Generator<TileEntityBigSolarGenerators.LightAbsorbing>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.LightAbsorbing, Generator<TileEntityBigSolarGenerators.LightAbsorbing>>>> BIG_LIGHT_ABSORBING_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_light_absorbing_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Photonic, Generator<TileEntityBigSolarGenerators.Photonic>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Photonic, Generator<TileEntityBigSolarGenerators.Photonic>>>> BIG_PHOTONIC_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_photonic_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_PHOTONIC_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockTileModel<TileEntityBigSolarGenerators.Creative, Generator<TileEntityBigSolarGenerators.Creative>>,
            ItemBlockTooltip<BlockTileModel<TileEntityBigSolarGenerators.Creative, Generator<TileEntityBigSolarGenerators.Creative>>>> BIG_CREATIVE_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_creative_solar_generator", () -> new BlockTileModel<>(SolarBlockTypes.BIG_CREATIVE_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockAdvancedCable, BlockItem> COSMIC_CABLE =
            BLOCKS.register("cosmic_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.COSMIC_CABLE, AdvancedCableTier.COSMIC));

    public static final BlockRegistryObject<BlockAdvancedCable, BlockItem> SUPREME_CABLE =
            BLOCKS.register("supreme_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.SUPREME_CABLE, AdvancedCableTier.SUPREME));

    public static final BlockRegistryObject<BlockAdvancedCable, BlockItem> INFINITY_CABLE =
            BLOCKS.register("infinity_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.INFINITY_CABLE, AdvancedCableTier.INFINITY));

    public static final BlockRegistryObject<BlockAdvancedCable, BlockItem> GALACTIC_CABLE =
            BLOCKS.register("galactic_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.GALACTIC_CABLE, AdvancedCableTier.GALACTIC));
}
