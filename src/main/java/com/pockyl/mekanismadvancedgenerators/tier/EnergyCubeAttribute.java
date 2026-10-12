package com.pockyl.mekanismadvancedgenerators.tier;

import mekanism.common.block.attribute.Attribute;

/**
 * Marks an energy cube block with its tier. The block also carries Mekanism's Ultimate tier, because Mekanism's code
 * expects one of its own tiers on every energy cube.
 */
public record EnergyCubeAttribute(AdvancedEnergyCubeTier tier) implements Attribute {
}
