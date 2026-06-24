package net.irreleven.seabyss.entity.client;

import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.entity.mob.RedDevilSquidEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RedDevilSquidModel <T extends RedDevilSquidEntity> extends SinglePartEntityModel<T> {
	public static final EntityModelLayer RED_DEVIL_SQUID = new EntityModelLayer(Identifier.of(ShoreEbbAbyss.MOD_ID, "red_devil_squid"), "main");

	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart fins;
	private final ModelPart fin1;
	private final ModelPart fin2;
	private final ModelPart tentacles;
	private final ModelPart arm2;
	private final ModelPart arm1;
	private final ModelPart tentacle1;
	private final ModelPart tentacle2;
	private final ModelPart tentacle3;
	private final ModelPart tentacle4;
	private final ModelPart tentacle5;
	private final ModelPart tentacle6;
	private final ModelPart tentacle7;
	private final ModelPart tentacle8;
	public RedDevilSquidModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = this.body.getChild("head");
		this.fins = this.body.getChild("fins");
		this.fin1 = this.fins.getChild("fin1");
		this.fin2 = this.fins.getChild("fin2");
		this.tentacles = this.body.getChild("tentacles");
		this.arm2 = this.tentacles.getChild("arm2");
		this.arm1 = this.tentacles.getChild("arm1");
		this.tentacle1 = this.tentacles.getChild("tentacle1");
		this.tentacle2 = this.tentacles.getChild("tentacle2");
		this.tentacle3 = this.tentacles.getChild("tentacle3");
		this.tentacle4 = this.tentacles.getChild("tentacle4");
		this.tentacle5 = this.tentacles.getChild("tentacle5");
		this.tentacle6 = this.tentacles.getChild("tentacle6");
		this.tentacle7 = this.tentacles.getChild("tentacle7");
		this.tentacle8 = this.tentacles.getChild("tentacle8");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -4.5F, 8.0F, 8.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 32).cuboid(-3.5F, -3.5F, -9.5F, 7.0F, 7.0F, 5.0F, new Dilation(0.0F))
		.uv(60, 9).cuboid(-3.0F, -3.5F, -12.5F, 6.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.5F));

		ModelPartData fins = body.addChild("fins", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData fin1 = fins.addChild("fin1", ModelPartBuilder.create().uv(0, 55).cuboid(0.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(34, 11).cuboid(2.0F, -0.5F, -2.0F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 64).cuboid(4.0F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -6.25F, -12.0F));

		ModelPartData fin2 = fins.addChild("fin2", ModelPartBuilder.create().uv(56, 0).cuboid(-2.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(60, 19).cuboid(-4.0F, -0.5F, -2.0F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(8, 64).cuboid(-5.0F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -6.25F, -12.0F));

		ModelPartData tentacles = body.addChild("tentacles", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData arm2 = tentacles.addChild("arm2", ModelPartBuilder.create().uv(30, 17).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 14.0F, new Dilation(0.0F))
		.uv(48, 11).cuboid(0.5F, -1.5F, 12.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -8.5F, 1.0F));

		ModelPartData arm1 = tentacles.addChild("arm1", ModelPartBuilder.create().uv(0, 17).cuboid(-0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 14.0F, new Dilation(0.0F))
		.uv(60, 25).cuboid(-1.5F, -0.5F, 13.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -3.5F, 0.0F));

		ModelPartData tentacle1 = tentacles.addChild("tentacle1", ModelPartBuilder.create().uv(24, 32).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -9.5F, 1.0F));

		ModelPartData tentacle2 = tentacles.addChild("tentacle2", ModelPartBuilder.create().uv(24, 43).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -9.5F, 1.0F));

		ModelPartData tentacle3 = tentacles.addChild("tentacle3", ModelPartBuilder.create().uv(0, 44).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -7.5F, 1.0F));

		ModelPartData tentacle4 = tentacles.addChild("tentacle4", ModelPartBuilder.create().uv(46, 32).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -4.5F, 1.0F));

		ModelPartData tentacle5 = tentacles.addChild("tentacle5", ModelPartBuilder.create().uv(46, 43).cuboid(-0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -2.5F, 0.0F));

		ModelPartData tentacle6 = tentacles.addChild("tentacle6", ModelPartBuilder.create().uv(22, 54).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -2.5F, 1.0F));

		ModelPartData tentacle7 = tentacles.addChild("tentacle7", ModelPartBuilder.create().uv(44, 54).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -4.5F, 1.0F));

		ModelPartData tentacle8 = tentacles.addChild("tentacle8", ModelPartBuilder.create().uv(34, 0).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -7.5F, 1.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(RedDevilSquidAnimations.SWIMMING_DEVIL, limbAngle, limbDistance, 2.0f, 2.5f);
		this.updateAnimation(entity.thrustAnimationState, RedDevilSquidAnimations.ROLL_DEVIL_1, 1.0f);
		this.updateAnimation(entity.attackAnimationState, RedDevilSquidAnimations.ATTACK_DEVIL, 1.0f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
			body.render(matrices, vertices, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return body;
	}

}