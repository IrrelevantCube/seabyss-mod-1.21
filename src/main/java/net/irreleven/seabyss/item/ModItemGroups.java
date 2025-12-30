package net.irreleven.seabyss.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup SEABYSS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ShoreEbbAbyss.MOD_ID, "seabyss_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.HYDROTHERMAL_VENT_BLOCK))
                    .displayName(Text.translatable("itemgroup.seabyss.seabyss_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGNESIUM_INGOT);
                        entries.add(ModItems.RAW_MAGNESIUM);
                        entries.add(ModBlocks.VULCAN_STONE);
                        entries.add(ModBlocks.VENT_COMPOSITE_BLOCK);
                        entries.add(ModBlocks.GABBRO);
                    }).build());


    public static void seaItemGroups() {
        ShoreEbbAbyss.LOGGER.info("Registering Item Groups for " + ShoreEbbAbyss.MOD_ID);
    }
}
