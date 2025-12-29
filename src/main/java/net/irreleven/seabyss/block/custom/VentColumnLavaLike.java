package net.irreleven.seabyss.block.custom;

import net.fabricmc.fabric.impl.object.builder.FabricEntityTypeImpl;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface VentColumnLavaLike {
    void applyVentEffect(LivingEntity livingEntity, World world, BlockPos pos);
}
