package io.github.theriverelder.randomore.world;

import io.github.theriverelder.randomore.RandomOre;
import io.github.theriverelder.randomore.registry.Blocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class OreGen {

    private static ConfiguredFeature<?, ?> OVERWORLD_RANDOM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    Blocks.RANDOM_ORE.getDefaultState(),
                    2)); // vein size

    public static PlacedFeature OVERWORLD_WOOL_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_RANDOM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(128))
            )); // height

    public static void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(RandomOre.ID, "overworld_random_ore"), OVERWORLD_RANDOM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(RandomOre.ID, "overworld_random_ore"), OVERWORLD_WOOL_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RandomOre.ID, "overworld_random_ore")));
    }
}
