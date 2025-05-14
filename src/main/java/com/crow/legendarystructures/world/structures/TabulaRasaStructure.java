package com.crow.legendarystructures.world.structures;

import com.crow.legendarystructures.world.loot.LootTableRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Random;

import static com.crow.legendarystructures.world.loot.LootTableRegistry.TABULA_RASA_LOOT_TABLE;

public class TabulaRasaStructure extends Structure implements Holder<ConfiguredFeature<?, ?>> {

    public TabulaRasaStructure() {
        super(StructureType.JIGSAW);
    }


    public StructurePieceType getPieceType() {
        return StructurePieceType.BLOCK;
    }


    protected void addPieces(StructurePiecesBuilder piecesBuilder, Random random, int chunkX, int chunkZ) {
        // Here, you would spawn your actual structure pieces
        // For example, creating a chest piece with loot
        piecesBuilder.addPiece(new StructurePiece(TABULA_RASA_LOOT_TABLE));
    }
}
