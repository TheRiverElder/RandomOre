package io.github.theriverelder.randomore;

import io.github.theriverelder.randomore.registry.Blocks;
import io.github.theriverelder.randomore.registry.Items;
import io.github.theriverelder.randomore.world.OreGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RandomOre implements ModInitializer {

    public static final String ID = "random_ore";

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(ID, "ore_essence"), Items.ORE_ESSENCE);
        Registry.register(Registry.ITEM, new Identifier(ID, "random_ore"), Items.RANDOM_ORE);

        Registry.register(Registry.BLOCK, new Identifier(ID, "random_ore"), Blocks.RANDOM_ORE);

        OreGen.register();
    }
}
