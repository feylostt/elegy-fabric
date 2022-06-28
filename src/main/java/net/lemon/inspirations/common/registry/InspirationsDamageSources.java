package net.lemon.inspirations.common.registry;

import net.minecraft.entity.damage.DamageSource;

public class InspirationsDamageSources extends DamageSource {
    public static final DamageSource INFECTION = new InspirationsDamageSources("infection").setBypassesArmor();

    protected InspirationsDamageSources(String name) {
        super(name);
    }
}
