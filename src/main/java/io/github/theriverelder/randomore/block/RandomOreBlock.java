package io.github.theriverelder.randomore.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public static final IntProperty ORE_TYPE = IntProperty.of("ore_type", 0, ORES.size() - 1);

    private static final Random random = new Random();

    public RandomOreBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(ORE_TYPE, random.nextInt(ORES.size())));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ORE_TYPE);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
//        Block ore = ORES.get(random.nextInt(ORES.size()));
        Block ore = ORES.get(state.get(ORE_TYPE) % ORES.size());
        return ore.getDroppedStacks(ore.getDefaultState(), builder);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, state.with(ORE_TYPE, random.nextInt(ORES.size())));
    }
}
