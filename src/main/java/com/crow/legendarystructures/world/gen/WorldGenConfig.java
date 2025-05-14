package com.crow.legendarystructures.world.gen;

import com.crow.legendarystructures.world.biomes.ModBiomes;
import com.crow.legendarystructures.world.structures.ModStructures;

import net.neoforged.bus.EventBus;
import net.neoforged.neoforge.registries.*;
import net.neoforged.bus.api.IEventBus;

public class WorldGenConfig {
    public static void setupWorldGen(IEventBus modEventBus) {
        ModBiomes.BIOMES.register(modEventBus);
        ModStructures.STRUCTURES.register(modEventBus);

        // Add custom structure placement
        ModStructurePlacement.addStructurePlacement();
    }
}
