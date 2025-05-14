package com.crow.legendarystructures.world.structures;

import com.crow.legendarystructures.world.biomes.BiomeInjectionManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.List;

public class BiomeStructurePlacement {

    public static void placeStructureInBiomes() {
        // Loop through biomes we've set to inject structures
        for (ResourceLocation biomeId : BiomeInjectionManager.BIOME_INJECTION_MAP.keySet()) {
            if (BiomeInjectionManager.BIOME_INJECTION_MAP.get(biomeId)) {

                // Check if the biome can have a structure
                BiomeInjectionManager.BiomeGroup group = BiomeInjectionManager.BIOME_GROUPS.get(biomeId);
                switch (group) {
                    case OVERWORLD:
                        addStructureToBiome(biomeId, new TabulaRasaStructure());
                        break;
                    // Additional cases for NETHER, END, or temperature groups can be added here
                    case NETHER:
                        addStructureToBiome(biomeId, new TabulaRasaStructure());
                        break;
                    case END:
                        addStructureToBiome(biomeId, new TabulaRasaStructure());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void addStructureToBiome(ResourceLocation biomeId, TabulaRasaStructure structureFeature) {
        // Add the structure to the biome
        FeaturePlacement<ConfiguredFeature<?, ?>> placement = FeaturePlacement.simple(structureFeature);
        PlacedFeature placedFeature = new PlacedFeature(structureFeature, List.of(placement));
        // You’ll need to properly register and place the feature in the worldgen system
        // For now, you could manually add it into the biome’s structure list or through worldgen registration
    }
}
