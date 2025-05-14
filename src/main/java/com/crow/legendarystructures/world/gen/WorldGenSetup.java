package com.crow.legendarystructures.world.gen;

import com.crow.legendarystructures.LegendaryStructures;
import com.crow.legendarystructures.config.ConfigSettings;
import com.crow.legendarystructures.world.biomes.TabulaRasaBiomeSource;
import com.crow.legendarystructures.world.structures.TabulaRasaStructure;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.*;

import static net.minecraft.core.registries.Registries.BIOME;
import static net.minecraft.resources.ResourceLocation.withDefaultNamespace;


public class WorldGenSetup {
    @SubscribeEvent
    public static void onBiomeSourceReplace(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            for (var levelStem : Registries.LEVEL_STEM.entrySet()) {
                var level = levelStem.getValue();
                if (level.generator().getBiomeSource() instanceof MultiNoiseBiomeSource original) {
                    TabulaRasaBiomeSource proxy = new TabulaRasaBiomeSource(original);
                    // Replace biome source in generator (use reflection or accessors)
                }
            }
        });
    }
    private static void registerStructures() {
        // Register structures dynamically based on config values
        ConfigSettings configSettings = ConfigSettings.load();

        // Example: Check if structures should spawn in specific biomes
        if (ConfigSettings.ENABLE_TABULARASA_IN_FOREST) {
            BIOME.compareTo(withDefaultNamespace("minecraft:forest"))
                    .getGenerationSettings().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, TabulaRasaStructure.CONFIGURED_FEATURE);
        }

        // More conditions for other biomes or dimensions can go here
    }

}