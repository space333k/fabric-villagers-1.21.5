package com.space333.villagers;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Villagers implements ModInitializer {
	public static final String MOD_ID = "villagers";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean HAS_ENCHANTS = FabricLoader.getInstance().isModLoaded("enchants");
	public static final boolean HAS_FLETCHING = FabricLoader.getInstance().isModLoaded("fletching");

	@Override
	public void onInitialize() {



	}
}