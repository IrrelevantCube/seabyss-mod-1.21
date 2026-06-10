package net.irreleven.seabyss.util;

import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.world.biome.ModBiomes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import javax.swing.text.html.HTML;

public class ModBiomeTags {


    public static final RegistryKey<Biome> VENT_FIELD_HAS_STRUCTURE = ModBiomes.HOT_OCEAN_BIOME;

    private ModBiomeTags() {
    }

    public static class Biomes {

        public static final TagKey<Biome> VENT_FIELD_HAS_STRUCTURE =
                createTag("vent_field_has_structure");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(ShoreEbbAbyss.MOD_ID, name));
        }
    }
}



