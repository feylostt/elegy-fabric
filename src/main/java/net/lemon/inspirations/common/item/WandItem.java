package net.lemon.inspirations.common.item;

import net.lemon.inspirations.common.registry.InspirationsSpells;
import net.lemon.inspirations.common.spells.Spell;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WandItem extends Item {

    public WandType type;

    public WandItem(Settings settings, WandType type) {
        super(settings.maxCount(1).fireproof().rarity(Rarity.UNCOMMON));
        this.type = type;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!user.getStackInHand(hand).hasNbt()) {
            return super.use(world, user, hand);
        }

        SoundEvent sound = SoundEvents.BLOCK_NOTE_BLOCK_BELL;

        switch(this.type) {
            case NATURAL -> sound = SoundEvents.BLOCK_BEACON_POWER_SELECT;
            case NETHER -> sound = SoundEvents.ITEM_FIRECHARGE_USE;
            case END -> sound = SoundEvents.ENTITY_ENDERMAN_TELEPORT;
        }

        Spell currentSpell = InspirationsSpells.SPELLS.get(user.getStackInHand(hand).getNbt().getString("inspirations.current_spell"));

        if(currentSpell == null) {
            return super.use(world, user, hand);
        }

        if (!world.isClient) {
            currentSpell.useSpell(world, user);
        }

        user.playSound(sound, 1.0F, 1.0F);
        user.getItemCooldownManager().set(this, currentSpell.getCooldown());

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return stack.hasNbt();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.hasNbt()) {
            String currentSpell = stack.getNbt().getString("inspirations.current_spell");
            tooltip.add(Text.translatable(currentSpell));
        }
    }

    public enum WandType {
        NATURAL,
        NETHER,
        END
    }
}