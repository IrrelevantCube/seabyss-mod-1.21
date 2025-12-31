package net.irreleven.seabyss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.irreleven.seabyss.block.ModBlocks;
import net.irreleven.seabyss.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENT_COMPOSITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GABBRO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VULCAN_STONE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_MAGNESIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGNESIUM_INGOT, Models.GENERATED);
    }
}
