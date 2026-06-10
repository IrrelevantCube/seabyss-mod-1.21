package net.irreleven.seabyss.world.gen.structure;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;

public interface ModStructureKeys {
    RegistryKey<Structure> HYDROTHERMAL_VENT_FIELD = of("vent_field");
    RegistryKey<Structure> VENT_TOWER = of("vent_tower");

    private static RegistryKey<Structure> of(String id) {
        return RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.ofVanilla(id));
    }
}
