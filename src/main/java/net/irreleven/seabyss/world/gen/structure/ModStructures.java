package net.irreleven.seabyss.world.gen.structure;

import net.irreleven.seabyss.ShoreEbbAbyss;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;

public class ModStructures {
    public static StructureType<UnderwaterStructures> UNDERWATER_STRUCTURES;

    public static void registerStructureFeatures() {
        UNDERWATER_STRUCTURES = Registry.register(Registries.STRUCTURE_TYPE, Identifier.of(ShoreEbbAbyss.MOD_ID, "underwater_structures"), () -> UnderwaterStructures.CODEC);
    }

}