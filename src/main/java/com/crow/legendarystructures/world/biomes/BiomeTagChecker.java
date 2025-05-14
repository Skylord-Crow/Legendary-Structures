package com.crow.legendarystructures.world.biomes;

import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;

public class BiomeTagChecker {
    // Create a ResourceLocation for the Overworld tag
    private static final ResourceLocation OVERWORLD_TAG = ResourceLocation.fromNamespaceAndPath("minecraft", "overworld");

    public static TagKey<Biome> isOverworldBiome(Biome biome) {
        // Access the TagManager to check if the biome is in the OVERWORLD tag
        return BiomeTags.IS_OVERWORLD;
    }
}
