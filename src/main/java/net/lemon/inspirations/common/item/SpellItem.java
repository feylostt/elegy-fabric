package net.lemon.inspirations.common.item;

import net.lemon.inspirations.common.Inspirations;
import net.lemon.inspirations.common.registry.InspirationsItems;
import net.lemon.inspirations.common.spells.Spell;
import net.lemon.inspirations.util.InventoryUtil;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpellItem extends Item {

    protected Spell spell;

    public SpellItem(Settings settings, Spell spell) {
        super(settings.maxCount(1));

        this.spell = spell;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        boolean hasWand;

        if(spell.getType() == Spell.SpellType.NATURAL) {
            hasWand = InventoryUtil.hasPlayerStackInInventory(user, InspirationsItems.AMETHYST_WAND);
        } else if(spell.getType() == Spell.SpellType.NETHER) {
            hasWand = InventoryUtil.hasPlayerStackInInventory(user, InspirationsItems.QUARTZ_WAND);
        } else if(spell.getType() == Spell.SpellType.END) {
            hasWand = InventoryUtil.hasPlayerStackInInventory(user, InspirationsItems.ENDER_WAND);
        } else {
            hasWand = false;
        }

        if(hasWand) {
            addNbtToWand(user, spell);
            return TypedActionResult.success(user.getStackInHand(hand));
        } else {
            return super.use(world, user, hand);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("spell." + Inspirations.MOD_ID + "." + spell.getName() + ".description")
                .formatted(Formatting.GRAY, Formatting.ITALIC));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
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
        nbtData.putString(Inspirations.MOD_ID + ".current_spell", spell.getName());

        wand.setNbt(nbtData);
    }

    public Spell getSpell() {
        return spell;
    }
}
