package net.lemon.inspirations.common.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lemon.inspirations.common.Inspirations;
import net.lemon.inspirations.common.item.WandItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class InspirationsItems {

    /*
     * TODO
     *  - Add Magical Wands (Crafted with 2x Stick and 1x Amethyst Shard or 1x Quartz or 1x Ender Eye)
     *  - Add Spells
     *  - Add Spellbooks (Natural, Nether, and End variants, one per wand)
     */

    // public static final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings().group(ItemGroupRegistry.TEST_GROUP)));

    public static final Item AMETHYST_WAND = registerItem("amethyst_wand", new WandItem(new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item QUARTZ_WAND = registerItem("quartz_wand", new WandItem(new FabricItemSettings().group(ItemGroup.TOOLS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Inspirations.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Inspirations.LOGGER.debug("Registering Mod Items for " + Inspirations.MOD_ID);
    }
}
