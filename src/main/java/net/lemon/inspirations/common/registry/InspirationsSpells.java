package net.lemon.inspirations.common.registry;

import net.lemon.inspirations.common.Inspirations;
import net.lemon.inspirations.common.spells.LightningSpell;
import net.lemon.inspirations.common.spells.MetamorphasisSpell;
import net.lemon.inspirations.common.spells.Spell;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;

public class InspirationsSpells {

    public static final LinkedHashMap<String, Spell> SPELLS = new LinkedHashMap<>();

    public static final Spell LIGHTNING = new LightningSpell(50, 50, Spell.SpellType.NATURAL, "Lightning");
    public static final Spell METAMORPHASIS = new MetamorphasisSpell(100, 50, Spell.SpellType.NATURAL, "Metamorphasis");

    public static void registerSpells() {
        Registry.register(Inspirations.SPELL, new Identifier(Inspirations.MOD_ID, "lightning"), LIGHTNING);
        SPELLS.put(LIGHTNING.getName(), LIGHTNING);

        Registry.register(Inspirations.SPELL, new Identifier(Inspirations.MOD_ID, "metamorphasis"), METAMORPHASIS);
        SPELLS.put(METAMORPHASIS.getName(), METAMORPHASIS);
    }
}
