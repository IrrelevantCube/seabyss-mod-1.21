package net.irreleven.seabyss.util;

import net.minecraft.entity.player.PlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMovementStored {
    private static final Map<UUID, Integer> stoppedTicks = new HashMap<>();

    public static void tick(PlayerEntity player) {
        if (player == null) return;

        UUID uuid = player.getUuid();

        if (MovementDetection.isStopped(player)) {
            stoppedTicks.put(uuid, stoppedTicks.getOrDefault(uuid, 0) + 1);

        }
        else {
            stoppedTicks.put(uuid, 0);
        }
    }
    public static int getStoppedTicks(PlayerEntity player) {
        return stoppedTicks.getOrDefault(player.getUuid(), 0);
    }
    public static boolean isSwarmReady(PlayerEntity player) {
        if (player == null) return false;

        return getStoppedTicks(player) >= 60;
    }
}
