package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.item.ItemSlotsBuilder;
import mekanism.common.block.BlockEnergyCube;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.world.level.material.MapColor;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.block.AdvancedCableBlock;
import com.pockyl.mekanismadvancedgenerators.block.BigSolarGeneratorBlock;
import com.pockyl.mekanismadvancedgenerators.block.SolarPanelBlock;
import com.pockyl.mekanismadvancedgenerators.item.AdvancedCableItem;
import com.pockyl.mekanismadvancedgenerators.item.AdvancedEnergyCubeItem;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;
import com.pockyl.mekanismadvancedgenerators.tier.SolarSize;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.EnumMap;
import java.util.Map;

/**
 * All blocks with their items. Registry names are part of saved worlds: never rename them.
 */
public final class ModBlocks {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(MekanismAdvancedGenerators.MOD_ID);

    public static final Map<SolarTier, BlockRegistryObject<SolarPanelBlock, ItemBlockTooltip<SolarPanelBlock>>> SOLAR_PANELS =
            new EnumMap<>(SolarTier.class);
    public static final Map<SolarTier, BlockRegistryObject<BigSolarGeneratorBlock, ItemBlockTooltip<BigSolarGeneratorBlock>>>
            BIG_SOLAR_GENERATORS = new EnumMap<>(SolarTier.class);
    public static final Map<AdvancedEnergyCubeTier, BlockRegistryObject<BlockEnergyCube, AdvancedEnergyCubeItem>> ENERGY_CUBES =
            new EnumMap<>(AdvancedEnergyCubeTier.class);
    public static final Map<AdvancedCableTier, BlockRegistryObject<AdvancedCableBlock, AdvancedCableItem>> CABLES =
            new EnumMap<>(AdvancedCableTier.class);

    static {
        for (SolarTier tier : SolarTier.values()) {
            SOLAR_PANELS.put(tier, BLOCKS
                    .registerDetails(SolarSize.PANEL.registryName(tier),
                            () -> new SolarPanelBlock(ModBlockTypes.SOLAR_PANELS.get(tier)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM,
                            () -> ItemSlotsBuilder.builder().addEnergy().build())));
        }
        for (SolarTier tier : SolarTier.values()) {
            BIG_SOLAR_GENERATORS.put(tier, BLOCKS
                    .registerDetails(SolarSize.BIG.registryName(tier),
                            () -> new BigSolarGeneratorBlock(ModBlockTypes.BIG_SOLAR_GENERATORS.get(tier),
                                    properties -> properties.mapColor(MapColor.COLOR_BLUE)))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM,
                            () -> ItemSlotsBuilder.builder().addEnergy().build())));
        }
        for (AdvancedEnergyCubeTier tier : AdvancedEnergyCubeTier.values()) {
            ENERGY_CUBES.put(tier, BLOCKS
                    .register(tier.registryName(), () -> new BlockEnergyCube(ModBlockTypes.ENERGY_CUBES.get(tier)),
                            (block, properties) -> new AdvancedEnergyCubeItem(block, properties, tier))
                    .forItemHolder(holder -> holder.addAttachmentOnlyContainers(ContainerType.ITEM,
                            () -> ItemSlotsBuilder.builder().addEnergy().addDrainEnergy().build())));
        }
        for (AdvancedCableTier tier : AdvancedCableTier.values()) {
            CABLES.put(tier, BLOCKS.register(tier.registryName(),
                    () -> new AdvancedCableBlock(ModBlockTypes.CABLES.get(tier), tier), AdvancedCableItem::new));
        }
    }

    private ModBlocks() {
    }
}
