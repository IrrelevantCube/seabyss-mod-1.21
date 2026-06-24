package net.irreleven.seabyss.entity.ai.goal;

import net.irreleven.seabyss.entity.mob.RedDevilSquidEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class RedDevilSquidAttackGoal extends MeleeAttackGoal {
        private final RedDevilSquidEntity devilSquidEntity;
        private int attackDelay = 20;
        private int ticksUntilNextAttack = 20;
        private boolean shouldCountTillNextAttack = false;

        public RedDevilSquidAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        devilSquidEntity = ((RedDevilSquidEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }

    @Override
    protected void attack(LivingEntity target) {
        if (isEnemyWithinAttackDistance(target)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAnimation()) {
                devilSquidEntity.setAttacking(true);
            }
            if (isTimeToAttack()) {
                this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            devilSquidEntity.setAttacking(false);
            devilSquidEntity.attackAnimationTimeout = 0;


        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity target) {
            return this.devilSquidEntity.distanceTo(target) <= 2f;
    }


    protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }
    protected boolean isTimeToStartAnimation() {
            return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
            return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity target) {
            this.resetAttackCooldown();
            this.mob.swingHand(Hand.MAIN_HAND);
            this.mob.tryAttack(target);
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
            devilSquidEntity.setAttacking(false);
        super.stop();
    }
}
