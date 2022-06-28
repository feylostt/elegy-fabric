package net.lemon.inspirations.common.spells;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class TeleportSpell extends Spell {
    public TeleportSpell(int cooldown, int expCost, SpellType type, String name) {
        super(cooldown, expCost, type, name);
    }

    @Override
    public void useSpell(World world, PlayerEntity user) {
        Vec3d eyePos = user.getEyePos();
        BlockHitResult raycast = world.raycast(new RaycastContext(eyePos, eyePos.add(user.getRotationVector().multiply(64)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, user));

        if(raycast.getType() != HitResult.Type.MISS) {
            Vec3d target = raycast.getPos();

            user.teleport(target.getX(), target.getY(), target.getZ());
            SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }
    }
}
