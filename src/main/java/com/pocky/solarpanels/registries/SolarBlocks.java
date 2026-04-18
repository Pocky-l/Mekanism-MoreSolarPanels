package com.pocky.solarpanels.registries;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.content.block.BlockBigSolarGenerator;
import com.pocky.solarpanels.content.blocktype.Generator;
import com.pocky.solarpanels.content.cable.AdvancedCableTier;
import com.pocky.solarpanels.content.cable.BlockAdvancedCable;
import com.pocky.solarpanels.content.cable.ItemBlockAdvancedCable;
import com.pocky.solarpanels.content.energycube.AdvancedEnergyCubeTier;
import com.pocky.solarpanels.content.energycube.ItemBlockAdvancedEnergyCube;
import com.pocky.solarpanels.tile.TileEntityBigSolarGenerators;
import com.pocky.solarpanels.tile.TileEntitySolarGenerators;
import mekanism.common.block.BlockEnergyCube;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.item.ItemSlotsBuilder;
import mekanism.common.block.prefab.BlockTile.BlockTileModel;
import mekanism.common.item.block.ItemBlockEnergyCube;
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

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Advanced, Generator<TileEntityBigSolarGenerators.Advanced>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Advanced, Generator<TileEntityBigSolarGenerators.Advanced>>>> BIG_ADVANCED_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_advanced_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_ADVANCED_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Hybrid, Generator<TileEntityBigSolarGenerators.Hybrid>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Hybrid, Generator<TileEntityBigSolarGenerators.Hybrid>>>> BIG_HYBRID_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_hybrid_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_HYBRID_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Ultimate, Generator<TileEntityBigSolarGenerators.Ultimate>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Ultimate, Generator<TileEntityBigSolarGenerators.Ultimate>>>> BIG_ULTIMATE_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_ultimate_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_ULTIMATE_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Quantum, Generator<TileEntityBigSolarGenerators.Quantum>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Quantum, Generator<TileEntityBigSolarGenerators.Quantum>>>> BIG_QUANTUM_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_quantum_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_QUANTUM_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Spectral, Generator<TileEntityBigSolarGenerators.Spectral>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Spectral, Generator<TileEntityBigSolarGenerators.Spectral>>>> BIG_SPECTRAL_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_spectral_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_SPECTRAL_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Singular, Generator<TileEntityBigSolarGenerators.Singular>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Singular, Generator<TileEntityBigSolarGenerators.Singular>>>> BIG_SINGULAR_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_singular_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_SINGULAR_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.LightAbsorbing, Generator<TileEntityBigSolarGenerators.LightAbsorbing>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.LightAbsorbing, Generator<TileEntityBigSolarGenerators.LightAbsorbing>>>> BIG_LIGHT_ABSORBING_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_light_absorbing_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_LIGHT_ABSORBING_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Photonic, Generator<TileEntityBigSolarGenerators.Photonic>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Photonic, Generator<TileEntityBigSolarGenerators.Photonic>>>> BIG_PHOTONIC_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_photonic_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_PHOTONIC_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Creative, Generator<TileEntityBigSolarGenerators.Creative>>,
            ItemBlockTooltip<BlockBigSolarGenerator<TileEntityBigSolarGenerators.Creative, Generator<TileEntityBigSolarGenerators.Creative>>>> BIG_CREATIVE_SOLAR_GENERATOR =
            BLOCKS.registerDetails("big_creative_solar_generator", () -> new BlockBigSolarGenerator<>(SolarBlockTypes.BIG_CREATIVE_SOLAR_GENERATOR, props -> props.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockAdvancedCable, ItemBlockAdvancedCable> COSMIC_CABLE =
            BLOCKS.register("cosmic_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.COSMIC_CABLE, AdvancedCableTier.COSMIC), ItemBlockAdvancedCable::new);

    public static final BlockRegistryObject<BlockAdvancedCable, ItemBlockAdvancedCable> SUPREME_CABLE =
            BLOCKS.register("supreme_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.SUPREME_CABLE, AdvancedCableTier.SUPREME), ItemBlockAdvancedCable::new);

    public static final BlockRegistryObject<BlockAdvancedCable, ItemBlockAdvancedCable> INFINITY_CABLE =
            BLOCKS.register("infinity_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.INFINITY_CABLE, AdvancedCableTier.INFINITY), ItemBlockAdvancedCable::new);

    public static final BlockRegistryObject<BlockAdvancedCable, ItemBlockAdvancedCable> GALACTIC_CABLE =
            BLOCKS.register("galactic_universal_cable", () -> new BlockAdvancedCable(SolarBlockTypes.GALACTIC_CABLE, AdvancedCableTier.GALACTIC), ItemBlockAdvancedCable::new);

    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockAdvancedEnergyCube> COSMIC_ENERGY_CUBE =
            BLOCKS.register("cosmic_energy_cube", () -> new BlockEnergyCube(SolarBlockTypes.COSMIC_ENERGY_CUBE),
                            (block, props) -> new ItemBlockAdvancedEnergyCube(block, props, AdvancedEnergyCubeTier.COSMIC))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockAdvancedEnergyCube> SUPREME_ENERGY_CUBE =
            BLOCKS.register("supreme_energy_cube", () -> new BlockEnergyCube(SolarBlockTypes.SUPREME_ENERGY_CUBE),
                            (block, props) -> new ItemBlockAdvancedEnergyCube(block, props, AdvancedEnergyCubeTier.SUPREME))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockAdvancedEnergyCube> INFINITY_ENERGY_CUBE =
            BLOCKS.register("infinity_energy_cube", () -> new BlockEnergyCube(SolarBlockTypes.INFINITY_ENERGY_CUBE),
                            (block, props) -> new ItemBlockAdvancedEnergyCube(block, props, AdvancedEnergyCubeTier.INFINITY))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));

    public static final BlockRegistryObject<BlockEnergyCube, ItemBlockAdvancedEnergyCube> GALACTIC_ENERGY_CUBE =
            BLOCKS.register("galactic_energy_cube", () -> new BlockEnergyCube(SolarBlockTypes.GALACTIC_ENERGY_CUBE),
                            (block, props) -> new ItemBlockAdvancedEnergyCube(block, props, AdvancedEnergyCubeTier.GALACTIC))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder().addEnergy().build()));
}
