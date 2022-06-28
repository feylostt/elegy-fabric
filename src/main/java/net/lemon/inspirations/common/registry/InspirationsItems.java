package net.lemon.inspirations.common.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lemon.inspirations.common.Inspirations;
import net.lemon.inspirations.common.item.SpellItem;
import net.lemon.inspirations.common.item.WandItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InspirationsItems {

    // Wands
    public static final Item AMETHYST_WAND = registerItem("amethyst_wand", new WandItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), WandItem.WandType.NATURAL));
    public static final Item QUARTZ_WAND = registerItem("quartz_wand", new WandItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), WandItem.WandType.NETHER));
    public static final Item ENDER_WAND = registerItem("ender_wand", new WandItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), WandItem.WandType.END));

    // Spell Items
    public static final Item LIGHTNING_SPELL_ITEM = registerItem("lightning_spell_item",
            new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.LIGHTNING));

    public static final Item INFECTED_DART_SPELL_ITEM = registerItem("infected_dart_spell_item",
            new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.INFECTED_DART));

    public static final Item NATURES_TOUCH_SPELL_ITEM = registerItem("natures_touch_spell_item",
            new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.NATURES_TOUCH));

    public static final Item DOUSE_SPELL_ITEM = registerItem("douse_spell_item",
            new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.DOUSE));

    public static final Item FIREBALL_SPELL_ITEM = registerItem("fireball_spell_item",
            new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.FIREBALL));

    public static final Item TELEPORT_SPELL_ITEM = registerItem("teleport_spell_item",
            new SpellItem(new FabricItemSettings().group(Inspirations.MOD_GROUP), InspirationsSpells.TELEPORT));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Inspirations.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Inspirations.LOGGER.debug("Registering Mod Items for " + Inspirations.MOD_ID);
    }
}
