package com.crow.legendarystructures.world.loot;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.entries.LootItem;
public class LootTableRegistry {

    public static final ResourceLocation TABULA_RASA_LOOT_TABLE = ResourceLocation.fromNamespaceAndPath("legendarystructures", "loot/tabula_rasa_loot");

    // Register Loot Table for Tabula Rasa structure
    public static void registerLootTables() {
        LootTableRegistry.registerLootTables(TABULA_RASA_LOOT_TABLE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItemRegistry.lootTableItem(Blocks.CHEST)  // Corrected LootItemEntry usage
                                .apply(SetCount.setCount(1))))  // Apply SetCount function to the item
        );
    }
    }
}
