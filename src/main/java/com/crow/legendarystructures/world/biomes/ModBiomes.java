package com.crow.legendarystructures.world.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.neoforge.registries.*;
import net.neoforged.neoforge.common.world.*;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME, "legendarystructures");

    // Registering a custom "Tabula Rasa" biome
    public static final Supplier<Biome> TABULA_RASA = BIOMES.register("tabula_rasa", () ->
            new Biome.BiomeBuilder()
                    .temperature(0.5F)    // Example: adjust as needed
                    .downfall(0.4F)       // Example: adjust as needed
                    .build()
    );
}
