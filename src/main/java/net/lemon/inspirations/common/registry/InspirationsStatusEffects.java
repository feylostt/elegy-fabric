package net.lemon.inspirations.common.registry;

import net.lemon.inspirations.common.Inspirations;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InspirationsStatusEffects {

    public static void registerStatusEffects() {

    }

    private static <T extends StatusEffect> T registerStatusEffect(String name, T effect) {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Inspirations.MOD_ID, name), effect);
        return effect;
    }
}
