package net.irreleven.seabyss.world.gen.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.irreleven.seabyss.util.FilterHolderSet;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.structure.StructureLiquidSettings;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.alias.StructurePoolAliasLookup;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureSpawns;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.structure.DimensionPadding;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

import java.util.Map;
import java.util.Optional;

public class UnderwaterStructures extends Structure {

    public static final MapCodec<Structure.Config> CUSTOM_STRUCTURE_SETTINGS_CODEC = RecordCodecBuilder.mapCodec(
            codecBuilder -> codecBuilder.group(
                            // This is where we swapped in our custom codec that will apply the exclude structure tag to remove entries from the has structure tag.
                            FilterHolderSet.codec(RegistryKeys.BIOME, Biome.REGISTRY_CODEC, false).fieldOf("biomes").forGetter(x -> x.biomes() instanceof FilterHolderSet<Biome> filterHolderSet ? filterHolderSet : new FilterHolderSet<>(x.biomes(), RegistryEntryList.empty())),
                            Codec.simpleMap(SpawnGroup.CODEC, StructureSpawns.CODEC, StringIdentifiable.toKeyable(SpawnGroup.values()))
                                    .fieldOf("spawn_overrides")
                                    .forGetter(Structure.Config::spawnOverrides),
                            GenerationStep.Feature.CODEC.fieldOf("step").forGetter(Structure.Config::step),
                            StructureTerrainAdaptation.CODEC.optionalFieldOf("terrain_adaptation", new Structure.Config(
                                    RegistryEntryList.of(), Map.of(), GenerationStep.Feature.SURFACE_STRUCTURES, StructureTerrainAdaptation.NONE
                            ).terrainAdaptation()).forGetter(Structure.Config::terrainAdaptation)
                    )
                    .apply(codecBuilder, Structure.Config::new)
    );

    public static final MapCodec<UnderwaterStructures> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(CUSTOM_STRUCTURE_SETTINGS_CODEC.forGetter(structureInfo -> structureInfo.config),
                    StructurePool.REGISTRY_CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Type.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter),
                    DimensionPadding.CODEC.optionalFieldOf("dimension_padding", JigsawStructure.DEFAULT_DIMENSION_PADDING).forGetter(structure -> structure.dimensionPadding),
                    StructureLiquidSettings.codec.optionalFieldOf("liquid_settings", JigsawStructure.DEFAULT_LIQUID_SETTINGS).forGetter(structure -> structure.liquidSettings)
            ).apply(instance, UnderwaterStructures::new));

    private final RegistryEntry<StructurePool> startPool;
    private final Optional<Identifier> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Type> projectStartToHeightmap;
    private final int maxDistanceFromCenter;
    private final DimensionPadding dimensionPadding;
    private final StructureLiquidSettings liquidSettings;


    public UnderwaterStructures(Structure.Config config,
                                RegistryEntry<StructurePool> startPool,
                                Optional<Identifier> startJigsawName,
                                int size,
                                HeightProvider startHeight,
                                Optional<Heightmap.Type> projectStartToHeightmap,
                                int maxDistanceFromCenter,
                                DimensionPadding dimensionPadding,
                                StructureLiquidSettings liquidSettings)
    {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
        this.dimensionPadding = dimensionPadding;
        this.liquidSettings = liquidSettings;
    }

    private static boolean extraSpawningChecks(Structure.Context context) {
        // Grabs the chunk position we are at
        ChunkPos chunkpos = context.chunkPos();

        int occupiedYPos = context.chunkGenerator().getHeightInGround(
                chunkpos.getStartX(),
                chunkpos.getStartZ(),
                Heightmap.Type.WORLD_SURFACE_WG,
                context.world(),
                context.noiseConfig());

        VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(chunkpos.getOffsetX(0), chunkpos.getOffsetZ(0), context.world(), context.noiseConfig());

        BlockState blockState = columnOfBlocks.getState(occupiedYPos);

        return blockState.getFluidState().isIn(FluidTags.WATER);
    }

    @Override
    protected Optional<Structure.StructurePosition> getStructurePosition(Context context) {
        if (!UnderwaterStructures.extraSpawningChecks(context)) {
            return Optional.empty();
        }
        int startY = this.startHeight.get(context.random(), new HeightContext(context.chunkGenerator(), context.world()));

        ChunkPos chunkPos = context.chunkPos();
        BlockPos blockPos = new BlockPos(chunkPos.getStartX(), startY, chunkPos.getStartZ());

        Optional<StructurePosition> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        context,
                        this.startPool,
                        this.startJigsawName,
                        this.size,
                        blockPos,
                        false,
                        this.projectStartToHeightmap,
                        this.maxDistanceFromCenter,
                        StructurePoolAliasLookup.EMPTY,
                        this.dimensionPadding,
                        this.liquidSettings);

        return structurePiecesGenerator;
    }

    @Override
    public StructureType<?> getType() {
        return null;
    }
}
