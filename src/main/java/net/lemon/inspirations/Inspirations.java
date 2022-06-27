package net.lemon.inspirations;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inspirations implements ModInitializer {

	public static final String MOD_ID = "inspirations";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Inspirations starting...");
	}
}
