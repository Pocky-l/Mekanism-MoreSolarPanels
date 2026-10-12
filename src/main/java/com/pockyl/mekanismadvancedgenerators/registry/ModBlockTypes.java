package com.pockyl.mekanismadvancedgenerators.registry;

import mekanism.common.block.attribute.AttributeHasBounding.HandleBoundingBlock;
import mekanism.common.block.attribute.AttributeHasBounding.TriBooleanFunction;
import mekanism.common.block.attribute.AttributeParticleFX;
import mekanism.common.block.attribute.AttributeStateActive;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.BlockTypeTile.BlockTileBuilder;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.content.blocktype.Machine.MachineBuilder;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.tier.CableTier;
import mekanism.common.tier.EnergyCubeTier;
import mekanism.common.tile.TileEntityEnergyCube;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import com.pockyl.mekanismadvancedgenerators.block.BlockShapes;
import com.pockyl.mekanismadvancedgenerators.block.GeneratorBlockType;
import com.pockyl.mekanismadvancedgenerators.block.SolarPanelShapes;
import com.pockyl.mekanismadvancedgenerators.blockentity.AdvancedCableBlockEntity;
import com.pockyl.mekanismadvancedgenerators.blockentity.BigSolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;
import com.pockyl.mekanismadvancedgenerators.tier.EnergyCubeAttribute;
import com.pockyl.mekanismadvancedgenerators.tier.SolarAttribute;
import com.pockyl.mekanismadvancedgenerators.tier.SolarSize;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.EnumMap;
import java.util.Map;

/**
 * Mekanism block types: the attributes (GUI, energy, shape, sound, tier...) behind every block of the mod.
 */
public final class ModBlockTypes {
    public static final Map<SolarTier, GeneratorBlockType<SolarGeneratorBlockEntity>> SOLAR_PANELS = new EnumMap<>(SolarTier.class);
    public static final Map<SolarTier, GeneratorBlockType<BigSolarGeneratorBlockEntity>> BIG_SOLAR_GENERATORS =
            new EnumMap<>(SolarTier.class);
    public static final Map<AdvancedCableTier, BlockTypeTile<AdvancedCableBlockEntity>> CABLES = new EnumMap<>(AdvancedCableTier.class);
    public static final Map<AdvancedEnergyCubeTier, Machine<TileEntityEnergyCube>> ENERGY_CUBES =
            new EnumMap<>(AdvancedEnergyCubeTier.class);

    /** The pole above the base block and the 3x3 panel two blocks above it. */
    private static final HandleBoundingBlock BIG_SOLAR_BOUNDING = new HandleBoundingBlock() {
        @Override
        public <DATA> boolean handle(Level level, BlockPos pos, BlockState state, DATA data,
                TriBooleanFunction<Level, BlockPos, DATA> consumer) {
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
            if (!consumer.accept(level, mutable.setWithOffset(pos, 0, 1, 0), data)) {
                return false;
            }
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    if (!consumer.accept(level, mutable.setWithOffset(pos, x, 2, z), data)) {
                        return false;
                    }
                }
            }
            return true;
        }
    };

    static {
        for (SolarTier tier : SolarTier.values()) {
            SOLAR_PANELS.put(tier, GeneratorBlockType.Builder
                    .<SolarGeneratorBlockEntity>create(() -> ModBlockEntities.SOLAR_PANELS.get(tier), ModLang.DESCRIPTION_SOLAR_GENERATOR)
                    .withGui(() -> ModContainers.SOLAR_PANELS.get(tier))
                    .withEnergyConfig(ModConfigs.STORAGE.solarStorage(tier, SolarSize.PANEL))
                    .withCustomShape(SolarPanelShapes.of(tier))
                    .withSound(ModSounds.SOLAR_GENERATOR)
                    .with(AttributeUpgradeSupport.MUFFLING_ONLY, new SolarAttribute(tier, SolarSize.PANEL))
                    .replace(Attributes.ACTIVE)
                    .build());
            BIG_SOLAR_GENERATORS.put(tier, GeneratorBlockType.Builder
                    .<BigSolarGeneratorBlockEntity>create(() -> ModBlockEntities.BIG_SOLAR_GENERATORS.get(tier),
                            ModLang.DESCRIPTION_SOLAR_GENERATOR)
                    .withGui(() -> ModContainers.BIG_SOLAR_GENERATORS.get(tier))
                    .withEnergyConfig(ModConfigs.STORAGE.solarStorage(tier, SolarSize.BIG))
                    .withCustomShape(BlockShapes.BIG_SOLAR_GENERATOR)
                    .withBounding(BIG_SOLAR_BOUNDING)
                    .withSound(ModSounds.SOLAR_GENERATOR)
                    .with(AttributeUpgradeSupport.MUFFLING_ONLY, new SolarAttribute(tier, SolarSize.BIG))
                    .replace(Attributes.ACTIVE)
                    .build());
        }
        for (AdvancedCableTier tier : AdvancedCableTier.values()) {
            // Mekanism's Ultimate tier is what Mekanism's own code sees; the capacity comes from our tier.
            CABLES.put(tier, BlockTileBuilder
                    .<AdvancedCableBlockEntity>createBlock(() -> ModBlockEntities.CABLES.get(tier), ModLang.cableDescription(tier))
                    .with(new AttributeTier<>(CableTier.ULTIMATE))
                    .build());
        }
        for (AdvancedEnergyCubeTier tier : AdvancedEnergyCubeTier.values()) {
            ENERGY_CUBES.put(tier, MachineBuilder
                    .<TileEntityEnergyCube>createMachine(() -> ModBlockEntities.ENERGY_CUBES.get(tier), ModLang.energyCubeDescription(tier))
                    .withGui(() -> ModContainers.ADVANCED_ENERGY_CUBE)
                    .withEnergyConfig(tier::storage)
                    .with(new AttributeTier<>(EnergyCubeTier.ULTIMATE), new AttributeStateFacing(BlockStateProperties.FACING),
                            new EnergyCubeAttribute(tier))
                    .withSideConfig(TransmissionType.ENERGY, TransmissionType.ITEM)
                    .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                    .build());
        }
    }

    private ModBlockTypes() {
    }
}
