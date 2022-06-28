package net.lemon.inspirations.common;

import net.fabricmc.api.ModInitializer;
import net.lemon.inspirations.common.registry.InspirationsItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inspirations implements ModInitializer {

	public static final String MOD_ID = "inspirations";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Inspirations starting...");

		InspirationsItems.registerModItems();
	}
}
