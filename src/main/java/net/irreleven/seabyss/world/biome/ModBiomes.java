package net.irreleven.seabyss.world.biome;

import net.irreleven.seabyss.ShoreEbbAbyss;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> HOT_OCEAN_BIOME = RegistryKey.of(RegistryKeys.BIOME,
             Identifier.of(ShoreEbbAbyss.MOD_ID, "hot_ocean_biome"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(HOT_OCEAN_BIOME, hotOceanBiome(context));
    }

    public static void globalOvereworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
    }

    public static Biome hotOceanBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 1, 2, 3));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOvereworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addSeagrassOnStone(biomeBuilder);
        DefaultBiomeFeatures.addKelp(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x45ADF2)
                        .waterFogColor(0x340407)
                        .skyColor(0x30c918)
                        .fogColor(0x45adf2)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();
    }

}
