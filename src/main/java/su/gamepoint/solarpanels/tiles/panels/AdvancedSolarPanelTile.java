package su.gamepoint.solarpanels.tiles.panels;

import mekanism.api.math.FloatingLong;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import su.gamepoint.solarpanels.SolarPanelsMod;
import su.gamepoint.solarpanels.registers.BlockRegister;

/**
 * @author Dudko Roman
 */
public class AdvancedSolarPanelTile extends AbstractSolarPanel {

    public AdvancedSolarPanelTile(BlockPos pos, BlockState state) {
        super(BlockRegister.ADVANCED_SOLAR_PANEL, pos, state, SolarPanelsMod.getConfig().advancedSolarPanel.get().multiply(2L));
    }

    @Override
    protected FloatingLong getConfiguredMax() {
        return SolarPanelsMod.getConfig().advancedSolarPanel.get();
    }
}
