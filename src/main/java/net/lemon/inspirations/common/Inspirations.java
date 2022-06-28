package net.lemon.inspirations.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.lemon.inspirations.common.registry.InspirationsItems;
import net.lemon.inspirations.common.registry.InspirationsSpells;
import net.lemon.inspirations.common.spells.Spell;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inspirations implements ModInitializer {

	public static final String MOD_ID = "inspirations";

	public static final Registry<Spell> SPELL = createRegistry("spell", Spell.class);

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "inspirations"),
			() -> new ItemStack(InspirationsItems.AMETHYST_WAND)
	);

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Inspirations starting...");

		InspirationsItems.registerModItems();
		InspirationsSpells.registerSpells();
	}

	@SuppressWarnings("unchecked")
	private static <T> Registry<T> createRegistry(String name, Class<?> registryClass) {
		Registry<?> registry = FabricRegistryBuilder.createSimple(registryClass, new Identifier(MOD_ID, name)).buildAndRegister();
		return (Registry<T>) registry;
	}
}
