package com.space333.villagers.util;

import com.space333.villagers.Villagers;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Enchantments {
        public static final TagKey<Enchantment> DESERT_TRADES = createTag("desert_trades");
        public static final TagKey<Enchantment> JUNGLE_TRADES = createTag("jungle_trades");
        public static final TagKey<Enchantment> PLAINS_TRADES = createTag("plains_trades");
        public static final TagKey<Enchantment> SAVANNA_TRADES = createTag("savanna_trades");
        public static final TagKey<Enchantment> SNOW_TRADES = createTag("snow_trades");
        public static final TagKey<Enchantment> SWAMP_TRADES = createTag("swamp_trades");
        public static final TagKey<Enchantment> TAIGA_TRADES = createTag("taiga_trades");

        public static final TagKey<Enchantment> FLETCHER_TRADES = createTag("fletcher_trades");
        public static final TagKey<Enchantment> FISHERMAN_TRADES = createTag("fisherman_trades");

        private static TagKey<Enchantment> createTag(String name) {
            return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Villagers.MOD_ID, name));
        }

    }


}
