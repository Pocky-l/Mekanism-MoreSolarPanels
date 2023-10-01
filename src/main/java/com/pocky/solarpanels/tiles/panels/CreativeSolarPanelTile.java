package com.pocky.solarpanels.tiles.panels;

import com.pocky.solarpanels.SolarPanelsMod;
import com.pocky.solarpanels.registers.BlockRegister;
import mekanism.api.math.FloatingLong;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * @author Dudko Roman
 */
public class CreativeSolarPanelTile extends AbstractSolarPanel {

    public CreativeSolarPanelTile(BlockPos pos, BlockState state) {
        super(BlockRegister.CREATIVE_SOLAR_PANEL, pos, state, SolarPanelsMod.getConfig().creativeSolarPanel.get().multiply(2L));
    }

    @Override
    protected FloatingLong getConfiguredMax() {
        return SolarPanelsMod.getConfig().creativeSolarPanel.get();
    }
}
