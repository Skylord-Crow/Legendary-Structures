package com.crow.legendarystructures.world.biomes;

import com.crow.legendarystructures.config.LegendaryStructuresConfig;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.crow.legendarystructures.world.biomes.BiomeTagChecker.isOverworldBiome;

public class BiomeInjectionManager {

    public static final Map<ResourceLocation, Boolean> BIOME_INJECTION_MAP = new HashMap<>();
    public static final Map<ResourceLocation, BiomeGroup> BIOME_GROUPS = new HashMap<>();

    public enum BiomeGroup {
        OVERWORLD,
        NETHER,
        END,
        TEMPERATURE_COLD,
        TEMPERATURE_TEMPERATE,
        TEMPERATURE_HOT,
        UNKNOWN
    }

    public static void scanAllBiomes() {
        for (ResourceLocation biomeId : Registries.BIOME.keySet()) {
            Biome biome = Registries.BIOME.get(biomeId);

            boolean shouldInject = shouldInjectBiome(biomeId, biome);
            BIOME_INJECTION_MAP.put(biomeId, shouldInject);
        }
    }

    private static boolean shouldInjectBiome(ResourceLocation id, Biome biome) {
        if (LegendaryStructuresConfig.BIOME_CONFIGS.containsKey(id.toString())) {
            return LegendaryStructuresConfig.BIOME_CONFIGS.get(id.toString());
        }

        // Default behavior (yes, inject)
        return true;
    }

    private static BiomeGroup classifyBiome(ResourceLocation id, Biome biome) {
        if isOverworldBiome(biome) {
            return BiomeGroup.OVERWORLD;
        }
        if (biome.is(BiomeTags.IS_NETHER)) {
            return BiomeGroup.NETHER;
        }
        if (biome.is(BiomeTags.IS_END)) {
            return BiomeGroup.END;
        }

        float temp = biome.getBaseTemperature();
        if (temp < 0.15F) {
            return BiomeGroup.TEMPERATURE_COLD;
        } else if (temp < 1.0F) {
            return BiomeGroup.TEMPERATURE_TEMPERATE;
        } else if (temp >= 1.0F) {
            return BiomeGroup.TEMPERATURE_HOT;
        }

        return BiomeGroup.UNKNOWN;
    }

    // Helper method for use elsewhere
    public static List<ResourceLocation> getBiomesInGroup(BiomeGroup group) {
        List<ResourceLocation> result = new ArrayList<>();
        for (Map.Entry<ResourceLocation, BiomeGroup> entry : BIOME_GROUPS.entrySet()) {
            if (entry.getValue() == group && BIOME_INJECTION_MAP.getOrDefault(entry.getKey(), false)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
