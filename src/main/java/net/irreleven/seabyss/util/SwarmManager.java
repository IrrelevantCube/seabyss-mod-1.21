package net.irreleven.seabyss.util;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class SwarmManager {
    public static Vec3d getSwarmPos(
            MobEntity mob,
            PlayerEntity player,
            int index,
            int total
    ) {
        double angle = (Math.PI * 2 * index) / total;
        double radius = 5.0;

        return new Vec3d(
                player.getX() + Math.cos(angle) * radius,
                player.getY(),
                player.getZ() + Math.sin(angle) * radius
        );
    }
}
