package net.irreleven.seabyss.entity;

import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.entity.mob.RedDevilSquidEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RedDevilSquidEntity> RED_DEVIL_SQUID = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ShoreEbbAbyss.MOD_ID, "red_devil_squid"),
            EntityType.Builder.create(RedDevilSquidEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.8f, 0.8f).build());


    public static void registerModEntities() {
        ShoreEbbAbyss.LOGGER.info("Cataloguing Oceanic Fauna for " + ShoreEbbAbyss.MOD_ID);
    }
}
