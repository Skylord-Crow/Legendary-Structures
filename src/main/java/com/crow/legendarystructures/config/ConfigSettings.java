package com.crow.legendarystructures.config;

import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;


public class ConfigSettings {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static ModConfigSpec SPEC;

    // Structure spawn options (dynamic)
    public static ModConfigSpec.BooleanValue ENABLE_TABULARASA_IN_FOREST;
    public static ModConfigSpec.DoubleValue SPAWN_RATE;

    static {
        // Config section for structure generation
        BUILDER.push("structure_generation");

        ENABLE_TABULARASA_IN_FOREST = BUILDER
                .comment("Enable Tabula Rasa in Forest biomes?")
                .define("enable_tabularasa_in_forest", true);

        SPAWN_RATE = BUILDER
                .comment("Spawn rate of TabulaRasa structure (0.0 to 1.0).")
                .defineInRange("spawn_rate", 0.5, 0.0, 1.0);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // Load config
    public static ConfigSettings load() {
        NeoForge.EVENT_BUS.addListener((ModConfigEvent event) -> {
            if (event.getConfig().getModId().equals("legendarystructures")) {
                // Here, dynamically load other mod biomes and generate config entries
                loadOtherModBiomes();
            }
        });
        return null; //Idk wtf this does
    }

    private static void loadOtherModBiomes() {
        // Logic for dynamically checking for other mods and adding their biomes to the config
        // This could involve scanning the `ForgeRegistries.BIOMES` for modded biomes

        List<String> moddedBiomes = getModdedBiomes();  // Custom method to get biomes
        for (String biomeId : moddedBiomes) {
            BUILDER.push(biomeId);
            BUILDER.define(biomeId + "_enabled", true);
            BUILDER.pop();
        }
    }

    private static List<String> getModdedBiomes() {
        // Scan for biomes from other mods and return their IDs
        // This would depend on your setup and the mods you want to support
        return List.of("modded_biome_1", "modded_biome_2"); // Example return value
    }
}
