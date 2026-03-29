package com.pocky.solarpanels.tile;

import mekanism.api.RelativeSide;
import mekanism.api.math.MathUtils;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.LongSupplier;

public abstract class TileEntityBigSolarGenerator extends TileEntitySolarGenerator {

    private static final RelativeSide[] ENERGY_SIDES = {RelativeSide.FRONT, RelativeSide.BOTTOM};

    private final SolarCheck[] solarChecks = new SolarCheck[8];

    protected TileEntityBigSolarGenerator(Holder<Block> blockProvider, BlockPos pos, BlockState state, @NotNull LongSupplier maxOutput) {
        super(blockProvider, pos, state, maxOutput);
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
        BlockPos topPos = worldPosition.above(2);
        solarCheck = new AdvancedSolarCheck(level, topPos);
        float totalPeak = solarCheck.getPeakMultiplier();
        for (int i = 0; i < solarChecks.length; i++) {
            BlockPos checkPos;
            if (i < 3) {
                checkPos = topPos.offset(-1, 0, i - 1);
            } else if (i == 3) {
                checkPos = topPos.offset(0, 0, -1);
            } else if (i == 4) {
                checkPos = topPos.offset(0, 0, 1);
            } else {
                checkPos = topPos.offset(1, 0, i - 6);
            }
            solarChecks[i] = new AdvancedSolarCheck(level, checkPos);
            totalPeak += solarChecks[i].getPeakMultiplier();
        }
        updateMaxOutputRaw(MathUtils.clampToLong(getConfiguredMax() * (totalPeak / 9)));
    }

    @Override
    protected boolean checkCanSeeSun() {
        if (solarCheck == null) {
            return false;
        }
        solarCheck.recheckCanSeeSun();
        byte count = solarCheck.canSeeSun() ? (byte) 1 : 0;
        for (SolarCheck check : solarChecks) {
            if (check != null) {
                check.recheckCanSeeSun();
                if (check.canSeeSun()) {
                    count++;
                }
            }
        }
        return count > 4;
    }

    @Override
    public long getProduction() {
        if (level == null || solarCheck == null) {
            return 0L;
        }
        float brightness = getBrightnessMultiplier(level);
        float generationMultiplier = solarCheck.getGenerationMultiplier();
        for (SolarCheck check : solarChecks) {
            if (check != null) {
                generationMultiplier += check.getGenerationMultiplier();
            }
        }
        generationMultiplier /= solarChecks.length + 1;
        return MathUtils.clampToLong(getConfiguredMax() * (brightness * generationMultiplier));
    }

    private static class AdvancedSolarCheck extends SolarCheck {

        private final int recheckFrequency;
        private long lastCheckedSun;

        public AdvancedSolarCheck(Level world, BlockPos pos) {
            super(world, pos);
            recheckFrequency = Mth.nextInt(world.random, 10, 30);
        }

        @Override
        public void recheckCanSeeSun() {
            if (!world.dimensionType().hasSkyLight() || world.getSkyDarken() >= 4) {
                canSeeSun = false;
                return;
            }
            long time = world.getGameTime();
            if (time < lastCheckedSun + recheckFrequency) {
                return;
            }
            lastCheckedSun = time;
            canSeeSun = WorldUtils.canSeeSun(world, pos);
        }
    }
}
