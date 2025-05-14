package com.crow.legendarystructures.world.dimensions;

import com.crow.legendarystructures.config.LegendaryStructuresConfig;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;

import java.util.HashSet;
import java.util.Set;

public class DimensionScanner {

    public static final Set<ResourceLocation> ALL_DIMENSIONS = new HashSet<>();
    public static final Set<ResourceLocation> INJECTABLE_DIMENSIONS = new HashSet<>();

    public static void scanDimensions(MinecraftServer server) {
        for (ResourceKey<Level> dimKey : server.levelKeys()) {
            ResourceLocation id = dimKey.location();

            // Track all dimensions
            ALL_DIMENSIONS.add(id);

            // Skip vanilla dimensions
            if (id.equals(Level.OVERWORLD.location()) || id.equals(Level.NETHER.location()) || id.equals(Level.END.location())) {
                continue;
            }

            // Check or create config entry for modded dimensions
            boolean allow = LegendaryStructuresConfig.getOrCreateDimensionFlag(id);
            if (allow) {
                INJECTABLE_DIMENSIONS.add(id);
            }
        }
    }
}
