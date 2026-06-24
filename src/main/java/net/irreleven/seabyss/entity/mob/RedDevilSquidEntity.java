package net.irreleven.seabyss.entity.mob;

import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class RedDevilSquidEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(RedDevilSquidEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private Vec3d swimDirection = Vec3d.ZERO;
    boolean targetingUnderwater;
    protected final SwimNavigation waterNavigation;
    private float swimSpeed = 0.05f;
    public final AnimationState swimmingAnimationState = new AnimationState();
    public AnimationState thrustAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    private int swimmingAnimationTimeout = 0;
    private float thrustAnimationTimeout = 0;
    private float thrustTimer = 0;
    private int thrustRollType = 0;
    private float thrustCooldown = 0;
    private float thrustStrength = 0.001f;
    private UUID swarmLeader;
    private static final double MAX_Y = 58;

    public RedDevilSquidEntity(EntityType<? extends RedDevilSquidEntity> entityType, World world) {
        super(entityType, world);
        this.random.setSeed(this.getId());
        this.lookControl = new YawAdjustingLookControl(this, 10);
        this.waterNavigation = new SwimNavigation(this, world);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new RedDevilSwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.5d, false));
        this.goalSelector.add(2, new GroupSwarmGoal(this, 2000));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(5, new TrackTargetGoal(this,  true) {
            @Override
            public boolean canStart() {
                return false;
            }
        });
        this.goalSelector.add(6, new ChaseBoatGoal(this));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal(this, SquidEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, TropicalFishEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, AxolotlEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createSquidAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.5f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 25);
    }

    boolean isTargetingUnderwater() {
        if (this.targetingUnderwater) {
            return true;
        } else {
            LivingEntity livingEntity = this.getTarget();
            return livingEntity != null && livingEntity.isTouchingWater();
        }
    }

    private void setupAnimationStates() {
        if (this.swimmingAnimationTimeout <= 0) {
            this.swimmingAnimationTimeout = 40;
            this.swimmingAnimationState.start(this.age);
        } else {
            --this.swimmingAnimationTimeout;
        }
        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }
        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        if (!getWorld().isClient()) {
            if (thrustTimer > 0) {
                thrustTimer--;
            }
            if (thrustTimer <= 0 && thrustCooldown <= 0) {
                startThrust();
            }
            moveForward();
        }
        if (thrustCooldown > 0) {
            thrustCooldown--;

            setVelocity(getVelocity().add(
                            swimDirection.multiply(thrustStrength)
                    )
            );

        } else {
            setVelocity(getVelocity().multiply(0.95));

            if (--thrustCooldown <= 0) {
                chooseNewDirection();

                thrustCooldown = random.nextBetween(200, 350);

                thrustTimer = random.nextBetween(100, 160);
            }
        }
    }

    private void startThrust() {
        chooseNewDirection();

        thrustCooldown = random.nextBetween(80, 120);

        thrustRollType = random.nextInt(2);
        thrustAnimationTimeout = 10;

        thrustTimer = random.nextBetween(100, 160);

        thrustAnimationState.start(this.age);
    }

    private void chooseNewDirection() {
        double y = getY();
        float yaw = random.nextFloat() * 360f;

        float pitch = random.nextFloat() * 40f - 20f;

        swimDirection = Vec3d.fromPolar(pitch, yaw);

        thrustStrength = 0.02f + random.nextFloat() * 0.3f;


    }

    private void moveForward() {

        Vec3d velocity = getVelocity();

        float yaw = (float) (MathHelper.atan2(
                velocity.z,
                velocity.x
        ) * (180f / Math.PI)) - 90f;

        float horizontal =
                (float) Math.sqrt(
                        velocity.z *velocity.z +
                                velocity.x * velocity.x
                );
        float pitch = (float) (-MathHelper.atan2(
                velocity.y,
                horizontal
        ) * (180f / Math.PI));

        setYaw(yaw);
        setPitch(pitch);

        bodyYaw = yaw;
        headYaw = yaw;

        velocity = velocity.add(
                swimDirection.multiply(thrustStrength)
        );
        setVelocity(velocity.multiply(0.05));

    }

    protected void tickWaterBreathingAir(int air) {
        if (this.isAlive() && !this.isInsideWaterOrBubbleColumn()) {
            this.setAir(air - 1);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.damage(this.getDamageSources().drown(), 2.0F);
            }
        } else {
            this.setAir(300);
        }
    }

    @Override
    public void baseTick() {
        int i = this.getAir();
        super.baseTick();
        this.tickWaterBreathingAir(i);
    }

    @Override
    public void updateSwimming() {
        if (!this.getWorld().isClient) {
            if (this.canMoveVoluntarily() && this.isTouchingWater() && this.isTargetingUnderwater()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            }
        }
    }

    @Override
    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }

    protected SoundEvent getSquirtSound() {
        return SoundEvents.ENTITY_SQUID_SQUIRT;
    }

    @Override
    public boolean canBeLeashed() {
        return false;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    protected Entity.MoveEffect getMoveEffect() {
        return Entity.MoveEffect.EVENTS;
    }

    @Override
    protected double getGravity() {
        return 0.08;
    }

    class RedDevilSwimGoal extends Goal {
        private final RedDevilSquidEntity devilSquidEntity;

        public RedDevilSwimGoal (RedDevilSquidEntity devilSquidEntity) {
            this.devilSquidEntity = devilSquidEntity;
        }
        @Override
        public boolean canStart() {
            return true;
        }

        @Override
        public void tick() {

            if (!isTouchingWater()) {
                applyAirGravity();
                return;
            }

            moveForward();


            if (devilSquidEntity.thrustTimer > 0) {
                devilSquidEntity.thrustTimer--;
            }
            Vec3d motion = devilSquidEntity.getVelocity();
            motion = motion.add(
                    devilSquidEntity.swimDirection.multiply(swimSpeed, 0, swimSpeed)
            );
            devilSquidEntity.setVelocity(motion);
            super.tick();

            if (thrustTimer <= 0) {
                Vec3d direction = swimDirection.normalize();

                devilSquidEntity.setVelocity(
                        devilSquidEntity.getVelocity().add(
                                direction.multiply(3)
                        )
                );
                thrustTimer = 40 + devilSquidEntity.getRandom().nextInt(80);
            }
        }
    }
    public List<RedDevilSquidEntity> getSwarmProximity() {
        return getWorld().getEntitiesByClass(
                RedDevilSquidEntity.class,
                getBoundingBox().expand(16),
                e -> true
        );
    }
    private void updateLeader() {
        List<RedDevilSquidEntity> swarm = getSwarmProximity();

        RedDevilSquidEntity leader = swarm.stream()
                .min(Comparator.comparing(Entity::getUuid))
                .orElse(this);
        swarmLeader = leader.getUuid();

    }
    public void setDesiredDirection(Vec3d direction) {
        this.swimDirection = direction;
    }

    public Vec3d getDesiredDirection(Vec3d direction) {
        return this.swimDirection;
    }

    public void setThrustStrength(float thrustStrength) {
        this.thrustStrength = thrustStrength;
    }

    public float getThrustStrength() {
        return this.thrustStrength;
    }

    private boolean playerIsMoving(PlayerEntity player) {
        return player.getVelocity().horizontalLength() > 0.08;
    }

    private void applyAirGravity() {
        Vec3d velocity = getVelocity();

        setVelocity(
                velocity.x * 0.98,
                velocity.y - 0.98,
                velocity.z * 0.98
        );
    }

    public class GroupSwarmGoal extends Goal {
        private final RedDevilSquidEntity redDevilSquidEntity;
        private PlayerEntity target;
        private float angleOffset;
        private int circleTime;

        private int getSwarmSize() {
            return redDevilSquidEntity.getWorld().getEntitiesByClass(
                    RedDevilSquidEntity.class,
                    redDevilSquidEntity.getBoundingBox().expand(16),
                    e -> true
            ).size();
        }

        public GroupSwarmGoal(RedDevilSquidEntity redDevilSquidEntity, int circleTime) {
            this.redDevilSquidEntity = redDevilSquidEntity;
        }

        @Override
        public boolean canStart() {
            PlayerEntity player =
                    redDevilSquidEntity.getWorld().getClosestPlayer(
                            redDevilSquidEntity,
                            20
                    );

            if (player == null) {
                return false;
            }
            if (player.isCreative()) {
                return false;
            }
            if(player.isSpectator()) {
                return false;
            }

            target = player;
            return true;
        }

        @Override
        public void start() {
            angleOffset =
                    redDevilSquidEntity.getRandom().nextFloat()
                    * (float) Math.PI * 2f;
            circleTime = 0;
        }

        @Override
        public void tick() {

            if (target == null)
                return;
            circleTime++;

            if (circleTime > 200) {
                beginAttack();
                return;
            }
            if (target.isCreative() || target.isSpectator()) {
                stop();
                return;
            }

            int index = getSwarmIndex();
            int swarmSize = Math.max(
                    getSwarmSize(),
                    1
            );
            double angle =
                    (System.currentTimeMillis() / 300.0)
                    + angleOffset
                    + (Math.PI * 2 * index / swarmSize);

            double radius = 12;

            Vec3d destination =
                    target.getPos().add(
                            Math.cos(angle) * radius,
                            0,
                            Math.sin(angle) * radius
                            
                    );
            Vec3d direction =
                    destination.subtract(
                            redDevilSquidEntity.getPos()
                    ).normalize();
            redDevilSquidEntity.setDesiredDirection(direction);

            double dy = MAX_Y - getY();

            Vec3d velocity = getVelocity();

            setVelocity(
                    velocity.x,
                    velocity.y + dy * 0.02,
                    velocity.z
            );

        }
        private int getSwarmIndex() {
            List<RedDevilSquidEntity> swarm =
                    redDevilSquidEntity.getSwarmProximity();

            swarm.sort(
                    Comparator.comparing(
                            Entity::getUuid
                    )
            );
            return swarm.indexOf(redDevilSquidEntity);

        }
        private void beginAttack() {
            Vec3d direction =
                    target.getEyePos()
                            .subtract(redDevilSquidEntity.getPos())
                            .normalize();

            redDevilSquidEntity.setDesiredDirection(direction);

            redDevilSquidEntity.setThrustStrength(1.5f);
        }
    }
}
