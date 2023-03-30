package su.gamepoint.solarpanels.registers;

import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;
import su.gamepoint.solarpanels.SolarPanelsMod;
import su.gamepoint.solarpanels.tiles.panels.*;

/**
 * @author Dudko Roman
 */
public class SolarContainerTypes {

    public static final ContainerTypeDeferredRegister CONTAINER_TYPES = new ContainerTypeDeferredRegister(SolarPanelsMod.MODID);

    public static final ContainerTypeRegistryObject<MekanismTileContainer<AdvancedSolarPanelTile>> ADVANCED_SOLAR_PANEL = CONTAINER_TYPES.register("advanced_solar_panel", AdvancedSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<HybridSolarPanelTile>> HYBRID_SOLAR_PANEL = CONTAINER_TYPES.register("hybrid_solar_panel", HybridSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<UltimateHybridSolarPanelTile>> ULTIMATE_HYBRID_SOLAR_PANEL = CONTAINER_TYPES.register("ultimate_hybrid_solar_panel", UltimateHybridSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<QuantumSolarPanelTile>> QUANTUM_SOLAR_PANEL = CONTAINER_TYPES.register("quantum_solar_panel", QuantumSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<SpectralSolarPanelTile>> SPECTRAL_SOLAR_PANEL = CONTAINER_TYPES.register("spectral_solar_panel", SpectralSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<SingularSolarPanelTile>> SINGULAR_SOLAR_PANEL = CONTAINER_TYPES.register("singular_solar_panel", SingularSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<LightAbsorbingSolarPanelTile>> LIGHT_ABSORBING_SOLAR_PANEL = CONTAINER_TYPES.register("light_absorbing_solar_panel", LightAbsorbingSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<PhotonicSolarPanelTile>> PHOTONIC_SOLAR_PANEL = CONTAINER_TYPES.register("photonic_solar_panel", PhotonicSolarPanelTile.class);;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<CreativeSolarPanelTile>> CREATIVE_SOLAR_PANEL = CONTAINER_TYPES.register("creative_solar_panel", CreativeSolarPanelTile.class);;

}
