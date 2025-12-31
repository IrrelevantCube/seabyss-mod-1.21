package net.irreleven.seabyss.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class VentCompositeBlock extends Block {
    public static final MapCodec<VentCompositeBlock> CODEC = createCodec(VentCompositeBlock::new);
    protected static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0);
    private static final int SCHEDULED_TICK_DELAY = 20;

    @Override
    public MapCodec<VentCompositeBlock> getCodec() {
        return CODEC;
    }

    public VentCompositeBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    protected VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.fullCube();
    }

    @Override
    protected VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity) {
            entity.damage(world.getDamageSources().hotFloor(), 1.0F);
        }

        super.onSteppedOn(world, pos, state, entity);
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = pos.getX();
        double e = pos.getY();
        double f = pos.getZ();
            world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + 0.5, e + 1, f + 0.5, 0.0, 0.2, 0.0);
        world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.0, 0.2, 0.0);
        world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.01, 0.02, 0.02);
        world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.02, 0.02, 0.01);
        world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), -0.01, 0.02, -0.02);
        world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), -0.02, 0.02, -0.01);
        if (random.nextInt(200) == 0) {
                world.playSound(
                        d, e, f, SoundEvents.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.5F, false
                );
            }
        }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        VentBubbleColumnBlock.update(world, pos.up(), state);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        if (direction == Direction.UP && neighborState.isOf(Blocks.WATER)) {
            world.scheduleBlockTick(pos, this, 20);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.scheduleBlockTick(pos, this, 20);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 0.2F;
    }
}
