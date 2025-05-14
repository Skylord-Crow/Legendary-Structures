package com.crow.legendarystructures.config;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModStructureConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    private static final Map<String, Supplier<Boolean>> dimensionToggles = new HashMap<>();
    private static final Map<String, Supplier<Boolean>> biomeToggles = new HashMap<>();

    static {
        BUILDER.push("structure_injection");

        // Dimension flags
        dimensionToggles.put("overworld", BUILDER.comment("Inject into Overworld?").define("overworld", true));
        dimensionToggles.put("nether", BUILDER.comment("Inject into Nether?").define("nether", false));
        dimensionToggles.put("end", BUILDER.comment("Inject into End?").define("end", false));

        // Placeholder dynamic biome toggles (populated at runtime)
        // Will be overwritten by config loader when scanning other mods

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static boolean shouldUseDimension(String dimension) {
        return dimensionToggles.getOrDefault(dimension, () -> false).get();
    }

    public static boolean shouldInjectIntoBiome(ResourceLocation biomeId) {
        // Fallback logic here — in real use, you'd build this list at runtime based on tags or temperature
        return true;
    }
}
