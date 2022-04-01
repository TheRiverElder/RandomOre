package io.github.theriverelder.randomore.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;

import java.util.Arrays;
import java.util.List;

public class RandomOreBlock extends OreBlock {

    public static final List<Block> ORES = Arrays.asList(
            Blocks.COAL_ORE,
            Blocks.COPPER_ORE,
            Blocks.IRON_ORE,
            Blocks.GOLD_ORE,
            Blocks.LAPIS_ORE,
            Blocks.DIAMOND_ORE,
            Blocks.EMERALD_ORE
    );

    public RandomOreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        Block ore = ORES.get((int) (Math.random() * ORES.size()));
        return ore.getDroppedStacks(ore.getDefaultState(), builder);
    }
}
