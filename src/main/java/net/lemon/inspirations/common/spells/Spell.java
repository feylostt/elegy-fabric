package net.lemon.inspirations.common.spells;

import net.lemon.inspirations.common.item.SpellItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class Spell {

    protected int cooldown;
    protected int expCost;
    protected SpellType type;
    protected SpellItem spellItem;
    protected String name;

    public Spell(int cooldown, int expCost, SpellType type, String name) {
        this.cooldown = cooldown;
        this.expCost = expCost;
        this.type = type;
        this.name = name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getExpCost() {
        return expCost;
    }

    public SpellType getType() {
        return type;
    }

    public SpellItem spellItem() {
        return spellItem;
    }

    public String getName() {
        return name;
    }

    public void useSpell(World world, PlayerEntity user) {

    }

    public enum SpellType {
        NATURAL,
        NETHER,
        END
    }
}
