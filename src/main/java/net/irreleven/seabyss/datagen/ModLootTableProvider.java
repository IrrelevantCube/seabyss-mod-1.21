package net.irreleven.seabyss.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.irreleven.seabyss.block.ModBlocks;
import net.irreleven.seabyss.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.VENT_COMPOSITE_BLOCK);
        addDrop(ModBlocks.VULCAN_STONE);
        addDrop(ModBlocks.GABBRO, oreDrops(ModBlocks.GABBRO, ModItems.RAW_MAGNESIUM));
        addDrop(ModBlocks.HYDROTHERMAL_VENT_BLOCK, oreDrops(ModBlocks.HYDROTHERMAL_VENT_BLOCK, Items.AIR));
        addDrop(ModBlocks.GABBRO, mobLikeOreDrops(ModBlocks.GABBRO, ModItems.RAW_MAGNESIUM, 3, 7));
        addDrop(ModBlocks.COMPOSITE_ORE, mobLikeOreDrops(ModBlocks.COMPOSITE_ORE, ModItems.RAW_TUNGSTEN, 0, 1));
        addDrop(ModBlocks.COMPOSITE_ORE, mobLikeOreDrops(ModBlocks.COMPOSITE_ORE, Items.DIAMOND, 1, 2));
        addDrop(ModBlocks.COMPOSITE_ORE, mobLikeOreDrops(ModBlocks.COMPOSITE_ORE, Items.EMERALD, 1, 2));
        addDrop(ModBlocks.COMPOSITE_ORE, mobLikeOreDrops(ModBlocks.COMPOSITE_ORE, Items.REDSTONE, 0, 2));
    }


    public LootTable.Builder mobLikeOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

}
