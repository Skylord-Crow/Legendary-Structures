package com.crow.legendarystructures.world.structures;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.structure.BlockStructure;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.api.structure.StructurePiece;
import com.crow.legendarystructures.LegendaryStructures;

public class StructureRegistry {

    public static final ResourceLocation STRUCTURE_ID = ResourceLocation.fromNamespaceAndPath("legendarystructures", "legendary_structure");

    // Register custom structures
    public static final StructureType<Structure> TABULA_RASA = Registry.register(Registry.STRUCTURE_TYPE, STRUCTURE_ID, StructureType.JIGSAW.codec("legendary_structure", TabulaRasaStructure::new));

   // public static void registerStructures() {
       // StructureRegistry.registerStructures(Registry.STRUCTURE, STRUCTURE_ID, new TabulaRasaStructure());
    }
}
