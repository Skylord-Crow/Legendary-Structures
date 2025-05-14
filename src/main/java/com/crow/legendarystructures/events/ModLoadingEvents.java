package com.crow.legendarystructures.events;

import com.crow.legendarystructures.world.biomes.BiomeInjectionManager;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModProcessEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.javafmlmod.*;
import net.neoforged.neoforge.common.NeoForge;


public class ModLoadingEvents {


    public void registerEvents() {
       //ModLoadingContext.get().getModEventBus().addListener(ModLoadingEvents::onCommonSetup);
        NeoForge.EVENT_BUS.register(this);
    }

    private static void onCommonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(BiomeInjectionManager::scanAllBiomes);
    }
}
