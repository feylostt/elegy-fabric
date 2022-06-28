package net.lemon.inspirations.common.spells;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;

public class MetamorphasisSpell extends Spell {

    public MetamorphasisSpell(int cooldown, int expCost, SpellType type, String name) {
        super(cooldown, expCost, type, name);
    }

    @Override
    public void useSpell(World world, PlayerEntity user) {
        BlockHitResult raycast = world.raycast(new RaycastContext(user.getEyePos(), user.getEyePos().add(user.getRotationVector().multiply(160d)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, user));
        BlockPos hitPos = raycast.getBlockPos();

        List<LivingEntity> list = world.getEntitiesByClass(LivingEntity.class, new Box(hitPos).expand(1.0D, 1.0D, 1.0D), livingEntity -> true);

        if(list.isEmpty()) {
            return;
        }

        LivingEntity entity = list.get(0);

        FrogEntity frog = new FrogEntity(EntityType.FROG, world);
        frog.setPos(entity.getX(), entity.getY(), entity.getZ());

        world.spawnEntity(frog);

        entity.discard();
    }
}
