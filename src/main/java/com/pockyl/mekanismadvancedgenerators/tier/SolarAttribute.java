package com.pockyl.mekanismadvancedgenerators.tier;

import mekanism.common.block.attribute.Attribute;

/**
 * Marks a solar block with its tier and size, so one block entity class serves all of them.
 */
public record SolarAttribute(SolarTier tier, SolarSize size) implements Attribute {
}
