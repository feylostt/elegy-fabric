package net.lemon.inspirations.common.spells;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballSpell extends Spell {

    public FireballSpell(int cooldown, int expCost, SpellType type, String name) {
        super(cooldown, expCost, type, name);
    }

    @Override
    public void useSpell(World world, PlayerEntity user) {
        double e = 4.0;
        Vec3d vec3d = user.getRotationVec(1.0F);

        FireballEntity fireballEntity = new FireballEntity(EntityType.FIREBALL, world);
        fireballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.0F, 0F);
        fireballEntity.setPosition(user.getX() + vec3d.x * 1.1F, user.getEyePos().getY(), user.getZ() + vec3d.z * 1.1F);
        world.spawnEntity(fireballEntity);
    }
}
