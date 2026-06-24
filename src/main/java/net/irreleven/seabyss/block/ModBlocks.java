package net.irreleven.seabyss.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.block.custom.VentBubbleColumnBlock;
import net.irreleven.seabyss.block.custom.VentCompositeBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {

    public static final Block GABBRO = registerSeaBlock("gabbro",
            new Block(AbstractBlock.Settings.create().strength(1.5f, 6)
                    .requiresTool()
            ));
    public static final Block VULCAN_STONE = registerSeaBlock("vulcan_stone",
            new Block(AbstractBlock.Settings.create().strength(1.5f, 6)
                    .requiresTool()
            ));
    public static final Block VENT_COMPOSITE_BLOCK = registerSeaBlock("vent_composite",
            new Block(AbstractBlock.Settings.create().strength(1.5f, 6)
                    .requiresTool()
            ));
    public static final Block COMPOSITE_ORE = registerSeaBlock("composite_ore",
            new Block(AbstractBlock.Settings.create().strength(10f, 7)
                    .requiresTool()
            ));
    public static final Block HYDROTHERMAL_VENT_BLOCK = registerSeaBlock("hydrothermal_vent_block",
            new VentCompositeBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .luminance(state -> 3)
                    .strength(0.5F)
                    .allowsSpawning((state, world, pos, entityType) -> entityType.isFireImmune())
                    .postProcess(Blocks::always)
            ));
    public static final Block VENT_BUBBLE_COLUMN = registerSeaBlock("vent_bubble_column",
            new VentBubbleColumnBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.WATER_BLUE)
                            .replaceable()
                            .noCollision()
                            .dropsNothing()
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .liquid()
                            .sounds(BlockSoundGroup.INTENTIONALLY_EMPTY))

            );

    private static Block registerSeaBlock(String name, Block block) {
        registerSeaBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ShoreEbbAbyss.MOD_ID, name), block);
    }

    private static void registerSeaBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ShoreEbbAbyss.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }



    public static void seaBlocks() {
        ShoreEbbAbyss.LOGGER.info("Manufacturing Deep-Sea materials for " + ShoreEbbAbyss.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries ->
                {
                    fabricItemGroupEntries.add(ModBlocks.GABBRO);
                    fabricItemGroupEntries.add(ModBlocks.VENT_COMPOSITE_BLOCK);
                    fabricItemGroupEntries.add(ModBlocks.HYDROTHERMAL_VENT_BLOCK);
                    fabricItemGroupEntries.add(ModBlocks.VULCAN_STONE);
                }
        );


    }
}
