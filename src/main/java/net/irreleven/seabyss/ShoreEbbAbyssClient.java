package net.irreleven.seabyss;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.irreleven.seabyss.entity.ModEntities;
import net.irreleven.seabyss.entity.client.RedDevilSquidModel;
import net.irreleven.seabyss.entity.client.RedDevilSquidRenderer;

public class ShoreEbbAbyssClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(RedDevilSquidModel.RED_DEVIL_SQUID, RedDevilSquidModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RED_DEVIL_SQUID, RedDevilSquidRenderer::new);
    }
}
