package com.crow.legendarystructures.world.gen;

import com.crow.legendarystructures.LegendaryStructures;
import com.crow.legendarystructures.config.ModStructureConfig;
import com.crow.legendarystructures.world.structures.ModStructures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;

import net.neoforged.neoforge.common.world.*;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import static net.minecraft.world.level.Level.*;

//@Mod.EventBusSubscriber(modid = LegendaryStructures.MODID)
public class ModStructurePlacement {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        ResourceLocation biomeName = event.getName();
        if (biomeName == null) return;

        // Check if this biome is allowed by config
        if (!ModStructureConfig.shouldInjectIntoBiome(biomeName)) return;

        // Determine which dimension we're in
        String dimension = determineDimensionFromCategory(event.getCategory());

        // Inject structures based on config + dimension
        if (ModStructureConfig.shouldUseDimension(dimension)) {
            injectStructure(event, ModStructures.TABULA_RASA_STRUCTURE.getHolder().get(), GenerationStep.Decoration.SURFACE_STRUCTURES);
        }
    }

    private static void injectStructure(BiomeLoadingEvent event, Holder<Structure> structure, GenerationStep.Decoration step) {
        event.getGeneration().getStructures().add(() -> structure);
    }

    private static String determineDimensionFromCategory(Biome.BiomeCategory category) {
        return switch (category) {
            case NETHER -> "nether";
            case END -> "end";
            default -> "overworld";
        };
    }
}