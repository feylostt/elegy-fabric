package net.lemon.inspirations.common.spells;

import net.lemon.inspirations.common.registry.InspirationsDamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.world.World;

public class InfectedDartSpell extends Spell {
    public InfectedDartSpell(int cooldown, int expCost, SpellType type, String name) {
        super(cooldown, expCost, type, name);
    }

    @Override
    public void useSpell(World world, PlayerEntity user) {
        boolean hasEffect = !user.getStatusEffects().isEmpty();

        if (!world.isClient) {

            ArrowItem arrowItem = (ArrowItem)(Items.ARROW);

            PersistentProjectileEntity persistentProjectileEntity = hasEffect ? createArrow(world, user) : arrowItem.createArrow(world, new ItemStack(Items.ARROW), user);
            persistentProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 4.0F, 0.0F);

            world.spawnEntity(persistentProjectileEntity);
        }
    }

    private ArrowEntity createArrow(World world, PlayerEntity user) {
        ArrowEntity arrow = new ArrowEntity(world, user);
        arrow.initFromStack(PotionUtil.setCustomPotionEffects(new ItemStack(Items.TIPPED_ARROW), user.getStatusEffects()));
        arrow.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;

        user.clearStatusEffects();
        user.damage(InspirationsDamageSources.INFECTION, 2.0f);

        return arrow;
    }
}