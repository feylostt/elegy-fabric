package net.lemon.inspirations.common.spells;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class SelfEffectSpell extends Spell {

    protected StatusEffect statusEffect;
    protected int level;

    public SelfEffectSpell(int cooldown, int expCost, SpellType type, String name, StatusEffect statusEffect, int level) {
        super(cooldown, expCost, type, name);

        this.statusEffect = statusEffect;
        this.level = level;
    }

    @Override
    public void useSpell(World world, PlayerEntity user) {
        StatusEffectInstance effect = new StatusEffectInstance(statusEffect, 1200, level);
        user.addStatusEffect(effect);
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public int getLevel() {
        return level;
    }

}
