package net.irreleven.seabyss.entity.client;// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

/**
 * Made with Blockbench 5.1.4
 * Exported for Minecraft version 1.19 or later with Yarn mappings
 * @author Author
 */
public class RedDevilSquidAnimations {
	public static final Animation SWIMMING_DEVIL = Animation.Builder.create(7.0F).looping()
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(5.0F, AnimationHelper.createTranslationalVector(-0.39F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(7.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("arm1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(5.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(5.019F, -4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.375F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-4.981F, 4.9809F, 0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.25F, AnimationHelper.createRotationalVector(4.9621F, -0.0003F, -0.8705F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(5.019F, -4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.375F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle4", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-4.981F, 4.9809F, 0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.25F, AnimationHelper.createRotationalVector(4.981F, -4.9809F, 0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle5", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5833F, AnimationHelper.createRotationalVector(5.019F, -4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.125F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle6", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(15.019F, 4.9809F, 0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.25F, AnimationHelper.createRotationalVector(4.981F, -4.9809F, 0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle7", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(5.019F, -4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.375F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle8", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-4.981F, 4.9809F, 0.4369F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(5.25F, AnimationHelper.createRotationalVector(4.981F, -4.9815F, -1.3041F), Transformation.Interpolations.LINEAR),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(-0.0189F, -0.0191F, -0.4353F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("arm2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(4.0F, AnimationHelper.createRotationalVector(-5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("fin1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(5.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(6.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("fin2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 67.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(7.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation ROLL_DEVIL_1 = Animation.Builder.create(1.75F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -540.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -720.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("arm1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.019F, -4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.02F, -4.98F, -0.44F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0199F, 0.02F, -0.4382F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9661F, -0.5823F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0191F, -0.0189F, -0.4352F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle4", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle5", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle6", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle7", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle8", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.02F, 4.98F, -0.44F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-5.001F, -0.0009F, -0.003F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("arm2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.02F, 4.98F, -0.44F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-0.001F, -0.0009F, -0.003F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("fin1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 82.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 82.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("fin2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 80.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 80.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation ROLL_DEVIL_2 = Animation.Builder.create(1.75F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 540.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 720.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("arm1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.019F, -4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.02F, -4.98F, -0.44F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0199F, 0.02F, -0.4382F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9661F, -0.5823F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0191F, -0.0189F, -0.4352F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle4", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle5", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle6", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle7", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tentacle8", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.02F, 4.98F, -0.44F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-5.001F, -0.0009F, -0.003F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("arm2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.019F, 4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.02F, 4.98F, -0.44F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-0.001F, -0.0009F, -0.003F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("fin1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -82.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -82.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("fin2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -82.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -82.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation ATTACK_DEVIL = Animation.Builder.create(0.5F)
		.addBoneAnimation("tentacle1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(21.1728F, -18.7472F, -7.0959F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle2", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle3", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle4", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle5", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle6", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle7", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tentacle8", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();
}