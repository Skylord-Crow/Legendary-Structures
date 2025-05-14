package com.crow.legendarystructures.world.structures;

import net.minecraft.core.registries.Registries;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.pieces.*;
import net.neoforged.neoforge.registries.*;

import java.util.function.Supplier;

public class ModStructures {
    public static final DeferredRegister<Structure> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE, "legendarystructures");

    public static final Supplier<Structure> TABULA_RASA_STRUCTURE = STRUCTURES.register("tabula_rasa", TabulaRasaStructure::new);

    // Custom Structure Start Logic
    public static class TabulaRasaStructureStart extends StructureStart {
        public TabulaRasaStructureStart(Structure structure, int x, int z, ChunkPos chunkPos, int reference) {
            super(structure, x, z, chunkPos, reference);
            // Place structure pieces here, using something like StructurePiece
        }
    }
}
