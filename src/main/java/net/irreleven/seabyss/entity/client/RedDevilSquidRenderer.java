package net.irreleven.seabyss.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.entity.mob.RedDevilSquidEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SquidEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class RedDevilSquidRenderer extends MobEntityRenderer<RedDevilSquidEntity, RedDevilSquidModel<RedDevilSquidEntity>> {

    public RedDevilSquidRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RedDevilSquidModel(ctx.getPart(RedDevilSquidModel.RED_DEVIL_SQUID)), 0.7F);
    }


    public Identifier getTexture(RedDevilSquidEntity squidEntity) {
        return Identifier.of(ShoreEbbAbyss.MOD_ID, "textures/entity/squid/red_devil_squid.png");
    }

    @Override
    public void render(RedDevilSquidEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.scale(1f, 1f, 1f);

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}