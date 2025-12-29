package net.irreleven.seabyss.block.custom;

import com.mojang.serialization.MapCodec;
import net.irreleven.seabyss.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class VentBubbleColumnBlock extends Block implements FluidDrainable {
    public static final MapCodec<VentBubbleColumnBlock> CODEC = createCodec(VentBubbleColumnBlock::new);
    public static final BooleanProperty DRAG = Properties.DRAG;
    private static final int SCHEDULED_TICK_DELAY = 5;

    @Override
    public MapCodec<VentBubbleColumnBlock> getCodec() {
        return CODEC;
    }

    public VentBubbleColumnBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(DRAG, true));
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        BlockState blockState = world.getBlockState(pos.up());
        if (blockState.isAir()) {
            entity.onBubbleColumnSurfaceCollision((Boolean)state.get(DRAG));
            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld)world;

                for (int i = 0; i < 2; i++) {
                    serverWorld.spawnParticles(
                            ParticleTypes.SPLASH, pos.getX() + world.random.nextDouble(), pos.getY() + 1, pos.getZ() + world.random.nextDouble(), 1, 0.0, 0.0, 0.0, 1.0
                    );
                    serverWorld.spawnParticles(
                            ParticleTypes.BUBBLE, pos.getX() + world.random.nextDouble(), pos.getY() + 1, pos.getZ() + world.random.nextDouble(), 1, 0.0, 0.01, 0.0, 1.0
                    );
                }
            }
        } else {
            entity.onBubbleColumnCollision((Boolean)state.get(DRAG));
        }

    }


    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        update(world, pos, state, world.getBlockState(pos.down()));
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStill(false);
    }

    public static void update(WorldAccess world, BlockPos pos, BlockState state) {
        update(world, pos, world.getBlockState(pos), state);
    }

    public static void update(WorldAccess world, BlockPos pos, BlockState water, BlockState bubbleSource) {
        if (isStillWater(water)) {
            BlockState blockState = getBubbleState(bubbleSource);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            BlockPos.Mutable mutable = pos.mutableCopy().move(Direction.UP);

            while (isStillWater(world.getBlockState(mutable))) {
                if (!world.setBlockState(mutable, blockState, Block.NOTIFY_LISTENERS)) {
                    return;
                }

                mutable.move(Direction.UP);
            }
        }
    }


    private static boolean isStillWater(BlockState state) {
        return state.isOf(ModBlocks.VENT_BUBBLE_COLUMN) || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() >= 8 && state.getFluidState().isStill();
    }

    private static BlockState getBubbleState(BlockState state) {
        if (state.isOf(ModBlocks.VENT_BUBBLE_COLUMN)) {
            return state;
        } else if (state.isOf(ModBlocks.VENT_COMPOSITE_BLOCK)) {
            return ModBlocks.VENT_BUBBLE_COLUMN.getDefaultState().with(DRAG, false);
        }
        return state;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = pos.getX();
        double e = pos.getY();
        double f = pos.getZ();
        if ((Boolean)state.get(DRAG)) {
            world.addImportantParticle(ParticleTypes.CURRENT_DOWN, d + 0.5, e + 0.8, f, 0.0, 0.0, 0.0);
            if (random.nextInt(200) == 0) {
                world.playSound(
                        d,
                        e,
                        f,
                        SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT,
                        SoundCategory.BLOCKS,
                        0.4F + random.nextFloat() * 0.2F,
                        0.5F + random.nextFloat() * 0.15F,
                        true
                );
            }
        } else {
            world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + 0.5, e, f + 0.5, 0.0, 0.2, 0.0);
            world.addImportantParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.0, 0.2, 0.0);
            world.addImportantParticle(ParticleTypes.BUBBLE_COLUMN_UP, d + 0.5, e, f + 0.5, 0.0, 1.0, 0.0);
            world.addImportantParticle(ParticleTypes.BUBBLE_COLUMN_UP, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.0, 1.0, 0.0);
            if (random.nextInt(200) == 0) {
                world.playSound(
                        d, e, f, SoundEvents.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.5F, false
                );
            }
        }
    }


    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getGameRules().getBoolean(GameRules.DO_FIRE_TICK)) {
            int i = random.nextInt(3);
            if (i > 0) {
                BlockPos blockPos = pos;

                for (int j = 0; j < i; j++) {
                    blockPos = blockPos.add(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    if (!world.canSetBlock(blockPos)) {
                        return;
                    }

                    BlockState blockState = world.getBlockState(blockPos);
                    if (blockState.isAir()) {
                        if (this.canLightFire(world, blockPos)) {
                            world.setBlockState(blockPos, AbstractFireBlock.getState(world, blockPos));
                            return;
                        }
                    } else if (blockState.blocksMovement()) {
                        return;
                    }
                }
            } else {
                for (int k = 0; k < 3; k++) {
                    BlockPos blockPos2 = pos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    if (!world.canSetBlock(blockPos2)) {
                        return;
                    }

                    if (world.isAir(blockPos2.up()) && this.hasBurnableBlock(world, blockPos2)) {
                        world.setBlockState(blockPos2.up(), AbstractFireBlock.getState(world, blockPos2));
                    }
                }
            }
        }
    }
    private boolean canLightFire(WorldView world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (this.hasBurnableBlock(world, pos.offset(direction))) {
                return true;
            }
        }

        return false;
    }

    private boolean hasBurnableBlock(WorldView world, BlockPos pos) {
        return pos.getY() >= world.getBottomY() && pos.getY() < world.getTopY() && !world.isChunkLoaded(pos) ? false : world.getBlockState(pos).isBurnable();
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        if (!state.canPlaceAt(world, pos)
                || direction == Direction.DOWN
                || direction == Direction.UP && !neighborState.isOf(ModBlocks.VENT_BUBBLE_COLUMN) && isStillWater(neighborState)) {
            world.scheduleBlockTick(pos, this, 5);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        return blockState.isOf(ModBlocks.VENT_BUBBLE_COLUMN) || blockState.isOf(ModBlocks.VENT_COMPOSITE_BLOCK);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DRAG);
    }

    @Override
    public ItemStack tryDrainFluid(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        return new ItemStack(Items.WATER_BUCKET);
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Fluids.WATER.getBucketFillSound();
    }
}
