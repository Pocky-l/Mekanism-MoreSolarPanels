package su.gamepoint.solarpanels.tiles.panels;

import mekanism.api.Action;
import mekanism.api.AutomationType;
import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.api.math.FloatingLong;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.capabilities.holder.slot.IInventorySlotHolder;
import mekanism.common.capabilities.holder.slot.InventorySlotHelper;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.ComputerMethod;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.inventory.container.MekanismContainer;
import mekanism.common.inventory.container.sync.SyncableBoolean;
import mekanism.common.inventory.container.sync.SyncableFloatingLong;
import mekanism.common.inventory.slot.EnergyInventorySlot;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.WorldUtils;
import mekanism.generators.common.tile.TileEntityGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import su.gamepoint.solarpanels.SolarPanelsMod;
import su.gamepoint.solarpanels.registers.BlockRegister;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Dudko Roman
 */
public class QuantumSolarPanelTile extends AbstractSolarPanel {

    public QuantumSolarPanelTile(BlockPos pos, BlockState state) {
        super(BlockRegister.QUANTUM_SOLAR_PANEL, pos, state, SolarPanelsMod.getConfig().quantumSolarPanel.get().multiply(2L));
    }

    @Override
    protected FloatingLong getConfiguredMax() {
        return SolarPanelsMod.getConfig().quantumSolarPanel.get();
    }
}
