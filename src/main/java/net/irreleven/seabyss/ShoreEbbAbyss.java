package net.irreleven.seabyss;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.irreleven.seabyss.block.ModBlocks;
import net.irreleven.seabyss.entity.ModEntities;
import net.irreleven.seabyss.entity.mob.RedDevilSquidEntity;
import net.irreleven.seabyss.item.ModItemGroups;
import net.irreleven.seabyss.item.ModItems;
import net.irreleven.seabyss.world.gen.structure.ModStructureKeys;
import net.irreleven.seabyss.world.gen.structure.ModStructures;
import net.minecraft.entity.mob.MobEntity;
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
		ModEntities.registerModEntities();

		ModStructures.registerStructureFeatures();

		FabricDefaultAttributeRegistry.register(ModEntities.RED_DEVIL_SQUID, RedDevilSquidEntity.createSquidAttributes());

		LOGGER.info("Hello Fabric Oceans!");
	}
}