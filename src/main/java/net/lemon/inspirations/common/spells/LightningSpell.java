package net.lemon.inspirations.common.spells;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import static net.minecraft.util.hit.HitResult.Type.MISS;

public class LightningSpell extends Spell {

    public LightningSpell(int cooldown, int expCost, SpellType type, String name) {
        super(cooldown, expCost, type, name);
    }

    @Override
    public void useSpell(World world, PlayerEntity user) {
        Vec3d eyePos = user.getEyePos();
        BlockHitResult raycast = world.raycast(new RaycastContext(eyePos, eyePos.add(user.getRotationVector().multiply(64)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, user));

        if(raycast.getType() != HitResult.Type.MISS) {
            Vec3d target = raycast.getPos();

            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningEntity.setPos(target.getX(), target.getY(), target.getZ());

            world.spawnEntity(lightningEntity);
        }
    }
}
