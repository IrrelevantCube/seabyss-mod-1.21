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
import net.minecraft.registry.RegistryKey;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

public class VentBubbleColumnBlock extends Block implements FluidDrainable, VentColumnLavaLike {
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
        entity.onBubbleColumnSurfaceCollision((Boolean)state.get(DRAG));
        double updatedVelocity = entity.getVelocity().y + 0.35;
        entity.setVelocity(entity.getVelocity().x, updatedVelocity, entity.getVelocity().z);
        if (entity instanceof LivingEntity living) {
            if (living.age % 5 == 0) {
                living.damage(
                        world.getDamageSources().lava(),
                        1.5f
                );
            }
        }
        if (blockState.isAir()) {
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
        } else if (state.isOf(ModBlocks.HYDROTHERMAL_VENT_BLOCK)) {
            return ModBlocks.VENT_BUBBLE_COLUMN.getDefaultState().with(DRAG, false);
        }
        return state.isOf(ModBlocks.HYDROTHERMAL_VENT_BLOCK) ? ModBlocks.VENT_BUBBLE_COLUMN.getDefaultState().with(DRAG, false) : Blocks.WATER.getDefaultState();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = pos.getX();
        double e = pos.getY();
        double f = pos.getZ();
        if ((Boolean)state.get(DRAG)) {
            world.addImportantParticle(ParticleTypes.CURRENT_DOWN, d + 0.5, e + 0.5, f, 0.0, 0.5, 0.0);
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
            world.addImportantParticle(ParticleTypes.BUBBLE_COLUMN_UP, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.0, 5.0, 0.0);
            world.addImportantParticle(ParticleTypes.BUBBLE_COLUMN_UP, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.0, 7.0, 0.0);
            world.addImportantParticle(ParticleTypes.BUBBLE_COLUMN_UP, d + random.nextFloat(), e + random.nextFloat(), f + random.nextFloat(), 0.0, 6.0, 0.0);
            if (random.nextInt(200) == 0) {
                world.playSound(
                        d, e, f, SoundEvents.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.5F, false
                );
            }
        }
    }


    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        if (!state.canPlaceAt(world, pos)
                || direction == Direction.DOWN
                || direction == Direction.UP && !neighborState.isOf(ModBlocks.VENT_BUBBLE_COLUMN) && isStillWater(neighborState)) {
            world.scheduleBlockTick(pos, this, 10);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public void applyVentEffect(LivingEntity livingEntity, World world, BlockPos pos) {
        if (livingEntity.age % 10 == 0) {
            livingEntity.damage(
                    world.getDamageSources().lava(),
                    1.5f
            );
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        return blockState.isOf(ModBlocks.VENT_BUBBLE_COLUMN) || blockState.isOf(ModBlocks.HYDROTHERMAL_VENT_BLOCK);
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
