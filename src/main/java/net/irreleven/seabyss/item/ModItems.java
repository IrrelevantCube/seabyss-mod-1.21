package net.irreleven.seabyss.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.irreleven.seabyss.ShoreEbbAbyss;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_MAGNESIUM = registerSeaItem("raw_magnesium", new Item(new Item.Settings()));
    public static final Item MAGNESIUM_INGOT = registerSeaItem("magnesium_ingot", new Item(new Item.Settings()));

    private static Item registerSeaItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ShoreEbbAbyss.MOD_ID, name), item);
    }

    public static void seaItems() {
        ShoreEbbAbyss.LOGGER.info("Deploying Ocean Scavenging Items for " + ShoreEbbAbyss.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(RAW_MAGNESIUM);
            fabricItemGroupEntries.add(MAGNESIUM_INGOT);
        });
    }
}
