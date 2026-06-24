package net.irreleven.seabyss.util;

import net.minecraft.entity.player.PlayerEntity;

public class MovementDetection {
    private static final double STOP_SPEED = 0.03;

    public static double getHorizontalSpeed(PlayerEntity player) {
        return player.getVelocity().horizontalLength();
    }
    public static boolean isStopped(PlayerEntity player) {
        return getHorizontalSpeed(player) < STOP_SPEED;
    }
    public static boolean isMoving(PlayerEntity player) {
        return getHorizontalSpeed(player) > STOP_SPEED;
    }
}
