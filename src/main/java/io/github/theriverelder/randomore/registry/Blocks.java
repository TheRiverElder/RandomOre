package io.github.theriverelder.randomore.registry;

import io.github.theriverelder.randomore.block.RandomOreBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;

public class Blocks {
    public static final RandomOreBlock RANDOM_ORE = new RandomOreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f).ticksRandomly());
}
