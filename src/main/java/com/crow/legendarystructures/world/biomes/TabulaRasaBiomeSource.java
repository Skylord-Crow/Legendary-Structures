package com.crow.legendarystructures.world.biomes;

import com.crow.legendarystructures.world.biomes.ModBiomes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.stream.Stream;

public class TabulaRasaBiomeSource extends BiomeSource {
    private final BiomeSource originalSource;

    public TabulaRasaBiomeSource(BiomeSource originalSource) {
        super(); // Required for superclass
        this.originalSource = originalSource;
    }

    @Override
    protected MapCodec<? extends BiomeSource> codec() {
        return null;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return null;
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler climate) {
        Holder<Biome> surroundingBiome = originalSource.getNoiseBiome(x, y, z, climate);

        if (surroundingBiome.is(ModBiomes.TABULA_RASA.getKey())) { //Tf? What is this check?
            return Holder.direct(cloneBiome(surroundingBiome));
        }

        return surroundingBiome;
    }

    private Biome cloneBiome(Holder<Biome> biomeHolder) {
        Biome base = biomeHolder.value();
        return new Biome.BiomeBuilder()
                .downfall(base.get)//
                .temperature(base.getBaseTemperature())
                .downfall(base.getDownfall())
                .mobSpawnSettings(base.getMobSettings())
                .generationSettings(filterGeneration(base.getGenerationSettings()))
                .build();
    }

    private BiomeGenerationSettings filterGeneration(BiomeGenerationSettings original) {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();

        // Example: Keep ores and plants only
        for (var step : GenerationStep.Decoration.values()) {
            for (var placed : original.getFeatures(step)) {
                if (step == GenerationStep.Decoration.UNDERGROUND_ORES ||
                        step == GenerationStep.Decoration.VEGETAL_DECORATION) {
                    builder.addFeature(step, placed);
                }
            }
        }

        return builder.build();
    }
}

