package com.pockyl.mekanismadvancedgenerators.blockentity;

import mekanism.api.IEvaporationSolar;
import mekanism.api.RelativeSide;
import mekanism.api.math.MathUtils;
import mekanism.common.util.MekanismUtils;
import net.minecraft.SharedConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

/**
 * A 3x3 solar generator of any tier, built like Mekanism's Advanced Solar Generator: a pole with a 3x3 panel two blocks
 * above the base. Each of the nine panel cells checks the sky on its own; the generator counts as seeing the sun when at
 * least five cells do, and it produces in proportion to the cells in sunlight. It also heats a Thermal Evaporation
 * Plant when placed on top of it.
 */
public class BigSolarGeneratorBlockEntity extends SolarGeneratorBlockEntity implements IEvaporationSolar {
    private static final RelativeSide[] ENERGY_SIDES = {RelativeSide.FRONT, RelativeSide.BOTTOM};
    private static final int CELLS_TO_SEE_SUN = 5;

    private final List<SolarCheck> cells = new ArrayList<>(9);

    public BigSolarGeneratorBlockEntity(Holder<Block> block, BlockPos pos, BlockState state) {
        super(block, pos, state);
    }

    @Override
    protected RelativeSide[] getEnergySides() {
        return ENERGY_SIDES;
    }

    @Override
    protected void recheckSettings() {
        if (level == null) {
            return;
        }
        cells.clear();
        BlockPos panelCenter = worldPosition.above(2);
        float totalPeak = 0.0F;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                SolarCheck cell = new CellCheck(level, panelCenter.offset(x, 0, z));
                cells.add(cell);
                totalPeak += cell.getPeakMultiplier();
            }
        }
        // The middle cell doubles as the "main" check, which also marks the settings as initialized.
        solarCheck = cells.get(4);
        setMaxOutput(MathUtils.clampToLong(configuredGeneration() * (totalPeak / cells.size())));
    }

    @Override
    protected boolean checkCanSeeSun() {
        if (solarCheck == null) {
            return false;
        }
        int sunlit = 0;
        for (SolarCheck cell : cells) {
            cell.recheckCanSeeSun();
            if (cell.canSeeSun()) {
                sunlit++;
            }
        }
        return sunlit >= CELLS_TO_SEE_SUN;
    }

    @Override
    protected long getProduction() {
        if (level == null || solarCheck == null) {
            return 0L;
        }
        float generationMultiplier = 0.0F;
        for (SolarCheck cell : cells) {
            generationMultiplier += cell.getGenerationMultiplier();
        }
        generationMultiplier /= cells.size();
        return MathUtils.clampToLong(configuredGeneration() * (getSunBrightness(level) * generationMultiplier));
    }

    /**
     * Rechecks the sky every 10-30 ticks instead of every tick (nine positions per generator), and exits early at
     * night. A waterlogged cell looks through the block above it.
     */
    private static final class CellCheck extends SolarCheck {
        private final int recheckInterval;
        private long lastCheck;

        CellCheck(Level level, BlockPos pos) {
            super(level, pos);
            recheckInterval = Mth.nextInt(level.random, MekanismUtils.TICKS_PER_HALF_SECOND,
                    MekanismUtils.TICKS_PER_HALF_SECOND + SharedConstants.TICKS_PER_SECOND);
            lastCheck = -recheckInterval;
        }

        // The same rule as Mekanism's Advanced Solar Generator, including the deprecated liquid() check.
        @SuppressWarnings("deprecation")
        @Override
        void recheckCanSeeSun() {
            if (!level.dimensionType().hasSkyLight() || level.getSkyDarken() >= 4) {
                canSeeSun = false;
                return;
            }
            long time = level.getGameTime();
            if (time < lastCheck + recheckInterval) {
                return;
            }
            lastCheck = time;
            if (level.getFluidState(pos).isEmpty()) {
                canSeeSun = level.canSeeSky(pos);
            } else {
                BlockPos above = pos.above();
                BlockState aboveState = level.getBlockState(above);
                canSeeSun = level.canSeeSky(above) && !aboveState.liquid() && aboveState.getLightBlock(level, above) <= 0;
            }
        }
    }
}
