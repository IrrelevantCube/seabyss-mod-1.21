package net.irreleven.seabyss.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_MAGNESIUM = registerSeaItem("raw_magnesium", new Item(new Item.Settings()));
    public static final Item MAGNESIUM_INGOT = registerSeaItem("magnesium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_TUNGSTEN = registerSeaItem("raw_tungsten", new Item(new Item.Settings()));
    public static final Item TUNGSTEN_INGOT = registerSeaItem("tungsten_ingot", new Item(new Item.Settings()));
    public static final Item RED_DEVIL_SQUID_SPAWN_EGG = registerSeaItem("red_devil_squid_spawn_egg",
            new SpawnEggItem(ModEntities.RED_DEVIL_SQUID, 0x772c2c, 0x9f9696, new Item.Settings()));

    private static Item registerSeaItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ShoreEbbAbyss.MOD_ID, name), item);
    }

    public static void seaItems() {
        ShoreEbbAbyss.LOGGER.info("Deploying Ocean Scavenging Items for " + ShoreEbbAbyss.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(RAW_MAGNESIUM);
            fabricItemGroupEntries.add(MAGNESIUM_INGOT);
            fabricItemGroupEntries.add(RAW_TUNGSTEN);
            fabricItemGroupEntries.add(TUNGSTEN_INGOT);
        });
    }
}
