package net.lemon.inspirations.common.item;

import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class RitualKnifeItem extends SwordItem {

    public RitualKnifeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if(target.world.isClient) {
            return super.postHit(stack, target, attacker);
        }

        ExperienceOrbEntity entity = new ExperienceOrbEntity(target.world, target.getX(), target.getY(), target.getZ(), 5);
        target.world.spawnEntity(entity);

        return super.postHit(stack, target, attacker);
    }
}
