package io.github.theriverelder.randomore.registry;

import io.github.theriverelder.randomore.item.OreEssenceItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Items {
    public static final OreEssenceItem ORE_ESSENCE = new OreEssenceItem(new FabricItemSettings().group(ItemGroup.MISC));
    public static final BlockItem RANDOM_ORE = new BlockItem(Blocks.RANDOM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

}
