package io.github.theriverelder.randomore.item;

import io.github.theriverelder.randomore.registry.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OreEssenceItem extends Item {

    public OreEssenceItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        BlockState state = world.getBlockState(pos);

        if (stack.isEmpty() || !(state.getBlock() instanceof OreBlock)) return ActionResult.PASS;

        world.setBlockState(pos, Blocks.RANDOM_ORE.getDefaultState());
        stack.setCount(stack.getCount() - 1);

        return ActionResult.SUCCESS;
    }
}
