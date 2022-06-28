package net.lemon.inspirations.common.item;

import net.lemon.inspirations.common.registry.InspirationsItems;
import net.lemon.inspirations.common.spells.Spell;
import net.lemon.inspirations.util.InventoryUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SpellItem extends Item {

    protected Spell spell;

    public SpellItem(Settings settings, Spell spell) {
        super(settings.maxCount(1));

        this.spell = spell;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        boolean hasWand = InventoryUtil.hasPlayerStackInInventory(user, InspirationsItems.AMETHYST_WAND)
                || InventoryUtil.hasPlayerStackInInventory(user, InspirationsItems.QUARTZ_WAND)
                || InventoryUtil.hasPlayerStackInInventory(user, InspirationsItems.ENDER_WAND);

        if(hasWand) {
            addNbtToWand(user, spell);
            return TypedActionResult.success(user.getStackInHand(hand));
        } else {
            return super.use(world, user, hand);
        }
    }

    private void addNbtToWand(PlayerEntity player, Spell spell) {
        ItemStack wand;

        if(spell.getType() == Spell.SpellType.NATURAL) {
            wand = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, InspirationsItems.AMETHYST_WAND));
        } else if(spell.getType() == Spell.SpellType.NETHER) {
            wand = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, InspirationsItems.QUARTZ_WAND));
        } else if(spell.getType() == Spell.SpellType.END) {
            wand = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, InspirationsItems.ENDER_WAND));
        } else {
            return;
        }

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("inspirations.current_spell", spell.getName());

        wand.setNbt(nbtData);
    }

    public Spell getSpell() {
        return spell;
    }
}
