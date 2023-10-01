package com.pocky.solarpanels.tiles.panels;

import mekanism.api.math.FloatingLong;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.registers.BlockRegister;

/**
 * @author Dudko Roman
 */
public class UltimateHybridSolarPanelTile extends AbstractSolarPanel {

    public UltimateHybridSolarPanelTile(BlockPos pos, BlockState state) {
        super(BlockRegister.ULTIMATE_HYBRID_SOLAR_PANEL, pos, state, SolarPanelsMod.getConfig().ultimateHybridSolarPanel.get().multiply(2L));
    }

    @Override
    protected FloatingLong getConfiguredMax() {
        return SolarPanelsMod.getConfig().ultimateHybridSolarPanel.get();
    }
}
