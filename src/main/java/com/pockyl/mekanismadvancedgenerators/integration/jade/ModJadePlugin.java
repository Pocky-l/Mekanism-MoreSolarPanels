package com.pockyl.mekanismadvancedgenerators.integration.jade;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

import com.pockyl.mekanismadvancedgenerators.block.BigSolarGeneratorBlock;
import com.pockyl.mekanismadvancedgenerators.block.SolarPanelBlock;
import com.pockyl.mekanismadvancedgenerators.blockentity.SolarGeneratorBlockEntity;

/**
 * Found by Jade through the annotation; never loaded without Jade. Mekanism's own Jade plugin already shows the energy
 * of every block and points the generators' bounding blocks at their main block.
 */
@WailaPlugin
public final class ModJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(SolarGeneratorProvider.INSTANCE, SolarGeneratorBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(SolarGeneratorProvider.INSTANCE, SolarPanelBlock.class);
        registration.registerBlockComponent(SolarGeneratorProvider.INSTANCE, BigSolarGeneratorBlock.class);
    }
}
