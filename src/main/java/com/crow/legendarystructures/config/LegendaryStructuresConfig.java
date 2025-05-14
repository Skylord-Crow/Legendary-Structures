package com.crow.legendarystructures.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.crow.legendarystructures.LegendaryStructures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = LegendaryStructures.MODID, bus = EventBusSubscriber.Bus.MOD)
public class LegendaryStructuresConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final Map<String, Boolean> BIOME_CONFIGS = new HashMap<>();
    public static final Map<String, Boolean> DIMENSION_CONFIGS = new HashMap<>();

    static {
        BUILDER.push("biome_injection");

        // This will be filled dynamically at runtime by BiomeInjectionManager
        // But you can seed defaults here if needed

        BUILDER.pop();

    }

    public static boolean getOrCreateDimensionFlag(ResourceLocation dimensionId) {
        String key = dimensionId.toString();

        if (!DIMENSION_CONFIGS.containsKey(key)) {
            // Default to false for modded dimensions
            DIMENSION_CONFIGS.put(key, false);
        }

        return DIMENSION_CONFIGS.get(key);
    }

    private static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true);

    private static final ModConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    private static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), LegendaryStructuresConfig::validateItemName);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean logDirtBlock;
    public static int magicNumber;
    public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        logDirtBlock = LOG_DIRT_BLOCK.get();
        magicNumber = MAGIC_NUMBER.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> BuiltInRegistries.ITEM.getValue(ResourceLocation.parse(itemName)))
                .collect(Collectors.toSet());
    }
}
