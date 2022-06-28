package net.lemon.inspirations.common.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lemon.inspirations.common.Inspirations;
import net.lemon.inspirations.common.item.SpellItem;
import net.lemon.inspirations.common.item.WandItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InspirationsItems {

    /*
     * TODO
     *  - Add Magical Wands (Crafted with 2x Stick and 1x Amethyst Shard or 1x Quartz or 1x Ender Eye)
     *  - Add Spells (Learned by Advancement or Loot)
     *  - Add Spellbooks (Natural, Nether, and End variants, one per wand)
     */

    // public static final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings().group(ItemGroupRegistry.TEST_GROUP)));

    // Wands
    public static final Item AMETHYST_WAND = registerItem("amethyst_wand", new WandItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), WandItem.WandType.NATURAL));
    public static final Item QUARTZ_WAND = registerItem("quartz_wand", new WandItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), WandItem.WandType.NETHER));
    public static final Item ENDER_WAND = registerItem("ender_wand", new WandItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), WandItem.WandType.END));

    // Spell Items
    public static final Item LIGHTNING_SPELL_ITEM = registerItem("lightning_spell_item", new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.LIGHTNING));
    public static final Item METAMORPHASIS_SPELL_ITEM = registerItem("metamorphasis_spell_item", new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.METAMORPHASIS));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Inspirations.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Inspirations.LOGGER.debug("Registering Mod Items for " + Inspirations.MOD_ID);
    }
}
