package net.irreleven.seabyss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.irreleven.seabyss.block.ModBlocks;
import net.irreleven.seabyss.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> MAGNESIUM_SMELTABLES = List.of(ModItems.RAW_MAGNESIUM);

        offerSmelting(recipeExporter, MAGNESIUM_SMELTABLES, RecipeCategory.MISC, ModItems.MAGNESIUM_INGOT, 0.25f, 200, "magnesium");
        offerBlasting(recipeExporter, MAGNESIUM_SMELTABLES, RecipeCategory.MISC, ModItems.MAGNESIUM_INGOT, 0.25f, 100, "magnesium");
    }
}
