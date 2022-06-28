package net.lemon.inspirations.common.registry;

import net.lemon.inspirations.common.Inspirations;
import net.lemon.inspirations.common.spells.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;

public class InspirationsSpells {

    public static final LinkedHashMap<String, Spell> SPELLS = new LinkedHashMap<>();

    public static final Spell LIGHTNING = new LightningSpell(50, 17, Spell.SpellType.NATURAL, "lightning");
    public static final Spell METAMORPHASIS = new MetamorphasisSpell(120, 50, Spell.SpellType.NATURAL, "metamorphasis");
    public static final Spell INFECTED_DART = new InfectedDartSpell(50, 20, Spell.SpellType.NATURAL, "infected_dart");
    public static final Spell NATURES_TOUCH = new NaturesTouchSpell(10, 25, Spell.SpellType.NATURAL, "natures_touch");

    public static final Spell DOUSE = new SelfEffectSpell(1800, 17, Spell.SpellType.NETHER, "douse", StatusEffects.FIRE_RESISTANCE, 0);
    public static final Spell FIREBALL = new FireballSpell(100, 5, Spell.SpellType.NETHER, "fireball");

    public static final Spell TELEPORT = new TeleportSpell(20, 12, Spell.SpellType.END, "teleport");

    public static void registerSpells() {
        registerSpell(LIGHTNING, "lightning");
        registerSpell(METAMORPHASIS, "metamorphasis");
        registerSpell(DOUSE, "douse");
        registerSpell(FIREBALL, "fireball");
        registerSpell(TELEPORT, "teleport");
        registerSpell(INFECTED_DART, "infected_dart");
        registerSpell(NATURES_TOUCH, "natures_touch");
    }

    private static void registerSpell(Spell spell, String name) {
        Registry.register(Inspirations.SPELL, new Identifier(Inspirations.MOD_ID, name), spell);
        SPELLS.put(spell.getName(), spell);
    }
}
