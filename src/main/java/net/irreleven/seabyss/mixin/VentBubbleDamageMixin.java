package net.irreleven.seabyss.mixin;

import net.irreleven.seabyss.block.ModBlocks;
import net.irreleven.seabyss.entity.mob.RedDevilSquidEntity;
import net.minecraft.block.BubbleColumnBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class VentBubbleDamageMixin {
    @Inject(
            method = "baseTick",
            at = @At("TAIL")
    )
    private void applyCustomVentEffects (CallbackInfo callbackInfo) {
        LivingEntity livingEntity = (LivingEntity) (Object)this;
        if (!(livingEntity instanceof RedDevilSquidEntity redDevilSquidEntity)) return;
        World world = livingEntity.getWorld();

        if (world.isClient) return;

        BlockPos pos = livingEntity.getBlockPos();

        if (world.getBlockState(pos).getBlock() instanceof BubbleColumnBlock) {
            if (world.getBlockState(pos.down()).isOf(ModBlocks.VENT_COMPOSITE_BLOCK)) {
          }
        }

    }
}
