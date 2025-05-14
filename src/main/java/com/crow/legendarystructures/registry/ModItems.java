package com.crow.legendarystructures.registry;

import com.crow.legendarystructures.LegendaryStructures;
import com.crow.legendarystructures.items.MarkOfTheAncientsItem;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, LegendaryStructures.MODID);

    public static final Supplier<Item> MARK_OF_THE_ANCIENTS =
            ITEMS.register("mark_of_the_ancients", () -> new MarkOfTheAncientsItem(new Item.Properties()));

    public static final Supplier<Item> INHERITANCE_CRYSTAL = ITEMS.register("inheritance_crystal",
            () -> new Item(new Properties()));

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
