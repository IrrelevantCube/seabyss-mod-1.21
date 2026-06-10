package net.irreleven.seabyss;

import net.fabricmc.api.ModInitializer;

import net.irreleven.seabyss.block.ModBlocks;
import net.irreleven.seabyss.item.ModItemGroups;
import net.irreleven.seabyss.item.ModItems;
import net.irreleven.seabyss.world.gen.structure.ModStructureKeys;
import net.irreleven.seabyss.world.gen.structure.ModStructures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShoreEbbAbyss implements ModInitializer {

	public static final String MOD_ID = "seabyss";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.seaItems();
		ModBlocks.seaBlocks();
		ModItemGroups.seaItemGroups();

		ModStructures.registerStructureFeatures();

		LOGGER.info("Hello Fabric Oceans!");
	}
}