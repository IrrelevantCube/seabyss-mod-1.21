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


    public static final RegistryKey<Biome> HOT_OCEAN_BIOME = register("hot_ocean_biome");

    private ModBiomeTags() {
    }

    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(ShoreEbbAbyss.MOD_ID, name));
    }
}



