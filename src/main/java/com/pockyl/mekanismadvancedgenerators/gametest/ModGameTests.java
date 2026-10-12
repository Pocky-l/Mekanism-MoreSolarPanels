package com.pockyl.mekanismadvancedgenerators.gametest;

import mekanism.common.config.IConfigTranslation;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.util.StorageUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.locale.Language;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

import com.pockyl.mekanismadvancedgenerators.MekanismAdvancedGenerators;
import com.pockyl.mekanismadvancedgenerators.blockentity.AdvancedCableBlockEntity;
import com.pockyl.mekanismadvancedgenerators.blockentity.BigSolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;
import com.pockyl.mekanismadvancedgenerators.config.ConfigTranslations;
import com.pockyl.mekanismadvancedgenerators.config.ModConfigs;
import com.pockyl.mekanismadvancedgenerators.registry.ModBlocks;
import com.pockyl.mekanismadvancedgenerators.registry.ModItems;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedCableTier;
import com.pockyl.mekanismadvancedgenerators.tier.AdvancedEnergyCubeTier;
import com.pockyl.mekanismadvancedgenerators.tier.EnergyTabletTier;
import com.pockyl.mekanismadvancedgenerators.tier.SolarSize;
import com.pockyl.mekanismadvancedgenerators.tier.SolarTier;

import java.util.List;
import java.util.Map;

/**
 * In-game tests, run headless by {@code gradlew runGameTestServer}.
 */
@GameTestHolder(MekanismAdvancedGenerators.MOD_ID)
@PrefixGameTestTemplate(false)
public final class ModGameTests {
    /** Every block registered by 2.2.x; worlds refer to these names. */
    private static final List<String> BLOCKS_OF_2_2 = List.of(
            "advanced_solar_panel", "hybrid_solar_panel", "ultimate_solar_panel", "quantum_solar_panel", "spectral_solar_panel",
            "singular_solar_panel", "light_absorbing_solar_panel", "photonic_solar_panel", "creative_solar_panel",
            "big_advanced_solar_generator", "big_hybrid_solar_generator", "big_ultimate_solar_generator", "big_quantum_solar_generator",
            "big_spectral_solar_generator", "big_singular_solar_generator", "big_light_absorbing_solar_generator",
            "big_photonic_solar_generator", "big_creative_solar_generator",
            "cosmic_universal_cable", "supreme_universal_cable", "infinity_universal_cable", "galactic_universal_cable",
            "cosmic_energy_cube", "supreme_energy_cube", "infinity_energy_cube", "galactic_energy_cube");
    /** Every item without a block registered by 2.2.x. */
    private static final List<String> ITEMS_OF_2_2 = List.of(
            "carbone_solar_element", "hybrid_solar_element", "improved_hybrid_solar_element", "quantum_solar_element",
            "spectral_solar_element", "singular_solar_element", "light_absorbing_solar_element", "photonic_solar_element",
            "creative_solar_element",
            "improved_energy_tablet", "quantum_energy_tablet", "spectral_energy_tablet", "singular_energy_tablet",
            "light_absorbing_energy_tablet", "photonic_energy_tablet", "creative_energy_tablet");

    private static final long RECIPES = 46;

    private ModGameTests() {
    }

    @GameTest(template = "empty")
    public static void registryNamesAreUnchanged(GameTestHelper helper) {
        for (String name : BLOCKS_OF_2_2) {
            ResourceLocation id = MekanismAdvancedGenerators.id(name);
            helper.assertTrue(BuiltInRegistries.BLOCK.containsKey(id), "Missing block " + id);
            helper.assertTrue(BuiltInRegistries.ITEM.containsKey(id), "Missing block item " + id);
            helper.assertTrue(BuiltInRegistries.BLOCK_ENTITY_TYPE.containsKey(id), "Missing block entity type " + id);
        }
        for (String name : ITEMS_OF_2_2) {
            helper.assertTrue(BuiltInRegistries.ITEM.containsKey(MekanismAdvancedGenerators.id(name)), "Missing item " + name);
        }
        helper.assertTrue(BuiltInRegistries.SOUND_EVENT.containsKey(MekanismAdvancedGenerators.id("tile.generator.solar")),
                "Missing solar sound");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void defaultsMatchPreviousVersions(GameTestHelper helper) {
        assertValue(helper, "advanced panel generation", ModConfigs.GENERATION.generation(SolarTier.ADVANCED, SolarSize.PANEL).get(), 150L);
        assertValue(helper, "photonic panel generation", ModConfigs.GENERATION.generation(SolarTier.PHOTONIC, SolarSize.PANEL).get(),
                328_050L);
        assertValue(helper, "big creative generation", ModConfigs.GENERATION.generation(SolarTier.CREATIVE, SolarSize.BIG).get(),
                60_000_000L);
        assertValue(helper, "big ultimate generation", ModConfigs.GENERATION.generation(SolarTier.ULTIMATE, SolarSize.BIG).get(),
                8_100L);
        assertValue(helper, "hybrid panel storage", ModConfigs.STORAGE.solarStorage(SolarTier.HYBRID, SolarSize.PANEL).get(), 864_000L);
        assertValue(helper, "big photonic storage", ModConfigs.STORAGE.solarStorage(SolarTier.PHOTONIC, SolarSize.BIG).get(),
                3_779_136_000L);
        assertValue(helper, "big creative storage", ModConfigs.STORAGE.solarStorage(SolarTier.CREATIVE, SolarSize.BIG).get(),
                12_000_000_000L);
        assertValue(helper, "galactic cube storage", AdvancedEnergyCubeTier.GALACTIC.storage(), 1_048_576_000_000L);
        assertValue(helper, "galactic cube output", AdvancedEnergyCubeTier.GALACTIC.output(), 2_097_152_000L);
        assertValue(helper, "galactic cable capacity", AdvancedCableTier.GALACTIC.capacity(), 33_554_432_000L);
        assertValue(helper, "creative tablet energy", ModConfigs.GEAR.maxEnergy(EnergyTabletTier.CREATIVE).get(), 2_000_000_000L);
        assertValue(helper, "light absorbing tablet rate", ModConfigs.GEAR.chargeRate(EnergyTabletTier.LIGHT_ABSORBING).get(),
                1_215_000L);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void configScreenIsTranslated(GameTestHelper helper) {
        Language language = Language.getInstance();
        for (IConfigTranslation translation : ConfigTranslations.all()) {
            String key = translation.getTranslationKey();
            helper.assertTrue(language.has(key), "Missing translation " + key);
            helper.assertTrue(language.has(key + ".tooltip"), "Missing translation " + key + ".tooltip");
            if (translation.button() != null) {
                helper.assertTrue(language.has(key + ".button"), "Missing translation " + key + ".button");
            }
        }
        helper.succeed();
    }

    @GameTest(template = "plot", timeoutTicks = 100)
    public static void solarPanelGeneratesInSunlight(GameTestHelper helper) {
        useNoonWithoutRain(helper);
        BlockPos pos = new BlockPos(2, 1, 2);
        helper.setBlock(pos, ModBlocks.SOLAR_PANELS.get(SolarTier.ADVANCED).defaultState());
        helper.succeedWhen(() -> {
            SolarGeneratorBlockEntity panel = blockEntity(helper, pos, SolarGeneratorBlockEntity.class);
            helper.assertTrue(panel.canSeeSun(), "The panel does not see the sun");
            helper.assertTrue(panel.getEnergyContainer().getEnergy() > 0L, "The panel stored no energy");
            helper.assertTrue(panel.getProductionRate() <= 150L * 2, "Produced more than the tier allows: " + panel.getProductionRate());
            assertValue(helper, "panel capacity", panel.getEnergyContainer().getMaxEnergy(), 288_000L);
        });
    }

    @GameTest(template = "plot", timeoutTicks = 100)
    public static void solarPanelUnderRoofProducesNothing(GameTestHelper helper) {
        useNoonWithoutRain(helper);
        BlockPos pos = new BlockPos(2, 1, 2);
        helper.setBlock(pos, ModBlocks.SOLAR_PANELS.get(SolarTier.QUANTUM).defaultState());
        helper.setBlock(pos.above(2), Blocks.STONE);
        helper.runAfterDelay(40, () -> {
            SolarGeneratorBlockEntity panel = blockEntity(helper, pos, SolarGeneratorBlockEntity.class);
            helper.assertFalse(panel.canSeeSun(), "The panel sees the sun through a roof");
            assertValue(helper, "stored energy", panel.getEnergyContainer().getEnergy(), 0L);
            helper.succeed();
        });
    }

    @GameTest(template = "plot", timeoutTicks = 120)
    public static void bigSolarGeneratorBuildsAndGenerates(GameTestHelper helper) {
        useNoonWithoutRain(helper);
        BlockPos pos = new BlockPos(2, 1, 2);
        var block = ModBlocks.BIG_SOLAR_GENERATORS.get(SolarTier.HYBRID);
        helper.setBlock(pos, block.defaultState());
        ServerLevel level = helper.getLevel();
        BlockPos absolute = helper.absolutePos(pos);
        BlockState state = level.getBlockState(absolute);
        // What placing the item does: Mekanism builds the bounding blocks in setPlacedBy.
        state.getBlock().setPlacedBy(level, absolute, state, null, new ItemStack(block));
        helper.assertBlockPresent(MekanismBlocks.BOUNDING_BLOCK.get(), pos.above());
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                helper.assertBlockPresent(MekanismBlocks.BOUNDING_BLOCK.get(), pos.offset(x, 2, z));
            }
        }
        helper.succeedWhen(() -> {
            BigSolarGeneratorBlockEntity generator = blockEntity(helper, pos, BigSolarGeneratorBlockEntity.class);
            helper.assertTrue(generator.canSeeSun(), "The big generator does not see the sun");
            helper.assertTrue(generator.getEnergyContainer().getEnergy() > 0L, "The big generator stored no energy");
            assertValue(helper, "big generator capacity", generator.getEnergyContainer().getMaxEnergy(), 864_000L * 6);
        });
    }

    @GameTest(template = "empty")
    public static void energyCubesUseTheirTier(GameTestHelper helper) {
        BlockPos pos = BlockPos.ZERO;
        for (AdvancedEnergyCubeTier tier : AdvancedEnergyCubeTier.values()) {
            helper.setBlock(pos, ModBlocks.ENERGY_CUBES.get(tier).defaultState());
            TileEntityEnergyCube cube = blockEntity(helper, pos, TileEntityEnergyCube.class);
            assertValue(helper, tier + " cube capacity", cube.getEnergyContainer().getMaxEnergy(), tier.defaultStorage());
            ItemStack stack = new ItemStack(ModBlocks.ENERGY_CUBES.get(tier));
            assertValue(helper, tier + " cube item capacity", StorageUtils.getEnergyContainer(stack, 0).getMaxEnergy(),
                    tier.defaultStorage());
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void cablesUseTheirTier(GameTestHelper helper) {
        BlockPos pos = BlockPos.ZERO;
        for (AdvancedCableTier tier : AdvancedCableTier.values()) {
            helper.setBlock(pos, ModBlocks.CABLES.get(tier).defaultState());
            AdvancedCableBlockEntity cable = blockEntity(helper, pos, AdvancedCableBlockEntity.class);
            assertValue(helper, tier + " cable capacity", cable.getTransmitter().getCapacity(), tier.defaultCapacity());
            assertValue(helper, tier + " cable buffer", cable.getTransmitter().buffer.getMaxEnergy(), tier.defaultCapacity());
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void energyTabletsUseTheirTier(GameTestHelper helper) {
        for (EnergyTabletTier tier : EnergyTabletTier.values()) {
            ItemStack stack = new ItemStack(ModItems.ENERGY_TABLETS.get(tier).get());
            assertValue(helper, tier + " tablet capacity", StorageUtils.getEnergyContainer(stack, 0).getMaxEnergy(),
                    tier.defaultMaxEnergy());
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void allRecipesLoad(GameTestHelper helper) {
        // A recipe with an unknown ingredient (a renamed Mekanism item) is skipped with only a log line.
        long loaded = helper.getLevel().getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.id().getNamespace().equals(MekanismAdvancedGenerators.MOD_ID))
                .count();
        assertValue(helper, "loaded recipes", loaded, RECIPES);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void energyCubeUpgradeKeepsEnergy(GameTestHelper helper) {
        ItemStack ultimate = new ItemStack(MekanismBlocks.ULTIMATE_ENERGY_CUBE);
        StorageUtils.getEnergyContainer(ultimate, 0).setEnergy(100_000_000L);
        ItemStack alloy = new ItemStack(MekanismItems.ATOMIC_ALLOY.get());
        ItemStack tablet = new ItemStack(ModItems.ENERGY_TABLETS.get(EnergyTabletTier.QUANTUM).get());
        CraftingInput input = CraftingInput.of(3, 3, List.of(alloy, tablet, alloy, tablet, ultimate, tablet, alloy, tablet, alloy));
        ServerLevel level = helper.getLevel();
        var recipe = level.getRecipeManager().getRecipeFor(RecipeType.CRAFTING, input, level);
        helper.assertTrue(recipe.isPresent(), "No recipe for the Cosmic Energy Cube");
        ItemStack cosmic = recipe.get().value().assemble(input, level.registryAccess());
        helper.assertTrue(cosmic.is(ModBlocks.ENERGY_CUBES.get(AdvancedEnergyCubeTier.COSMIC).asItem()), "Crafted " + cosmic);
        assertValue(helper, "energy after the upgrade", StorageUtils.getEnergyContainer(cosmic, 0).getEnergy(), 100_000_000L);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void panelHitboxesFollowTheirModels(GameTestHelper helper) {
        // Model heights in pixels: the higher tiers have taller panels than the Advanced one.
        Map<SolarTier, Integer> heights = Map.of(SolarTier.ADVANCED, 8, SolarTier.ULTIMATE, 9, SolarTier.QUANTUM, 9,
                SolarTier.SINGULAR, 9, SolarTier.PHOTONIC, 10, SolarTier.CREATIVE, 10);
        BlockPos pos = BlockPos.ZERO;
        for (Map.Entry<SolarTier, Integer> entry : heights.entrySet()) {
            for (Direction facing : Direction.Plane.HORIZONTAL) {
                BlockState state = ModBlocks.SOLAR_PANELS.get(entry.getKey()).defaultState()
                        .setValue(BlockStateProperties.HORIZONTAL_FACING, facing);
                helper.setBlock(pos, state);
                double top = helper.getBlockState(pos).getShape(helper.getLevel(), helper.absolutePos(pos)).max(Direction.Axis.Y);
                helper.assertTrue(Math.abs(top * 16 - entry.getValue()) < 0.01,
                        entry.getKey() + " facing " + facing + ": hitbox top " + top * 16 + " instead of " + entry.getValue());
            }
        }
        helper.succeed();
    }

    private static void useNoonWithoutRain(GameTestHelper helper) {
        helper.getLevel().setDayTime(6_000L);
        helper.getLevel().setWeatherParameters(6_000, 0, false, false);
    }

    private static <T> T blockEntity(GameTestHelper helper, BlockPos pos, Class<T> type) {
        Object blockEntity = helper.getBlockEntity(pos);
        if (!type.isInstance(blockEntity)) {
            helper.fail("Expected " + type.getSimpleName() + " but found " + blockEntity, pos);
        }
        return type.cast(blockEntity);
    }

    private static void assertValue(GameTestHelper helper, String what, long actual, long expected) {
        helper.assertTrue(actual == expected, what + ": expected " + expected + " but was " + actual);
    }
}
