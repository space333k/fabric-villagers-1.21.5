package com.space333.villagers.trades;

import com.space333.villagers.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerType;

import static com.space333.villagers.trades.TradeCreationHelper.*;

public class LibrarianTrade {

    public static TradeOffers.Factory[] trades1() {
        return new TradeOffers.Factory[]{
                sell(Items.PAPER, 24, 16, 2),
                buy(Items.CHISELED_BOOKSHELF, 1, 3, 12, 1)
        };
    }

    public static TradeOffers.Factory[] trades2() {
        return new TradeOffers.Factory[]{
                sell(Items.BOOK, 4, 12, 10),
                buy(Items.LANTERN, 1, 1, 12,5),
                new TradeOffers.EnchantBookFactory(1, ModTags.Enchantments.JUNGLE_TRADES),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.PLAINS_TRADES, 1, 5), VillagerType.PLAINS),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.DESERT_TRADES,1, 5), VillagerType.DESERT),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.SAVANNA_TRADES, 1, 5), VillagerType.SAVANNA),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.JUNGLE_TRADES, 1, 5), VillagerType.JUNGLE),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.SWAMP_TRADES, 1, 5), VillagerType.SWAMP),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.TAIGA_TRADES, 1, 5), VillagerType.TAIGA),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.SNOW_TRADES, 1, 5), VillagerType.SNOW)
        };
    }

    public static TradeOffers.Factory[] trades3() {
        return new TradeOffers.Factory[]{
                buy(Items.GLASS, 4, 1, 12, 10),
                buy(Items.CLOCK,1, 4, 12, 10),
                sell(Items.INK_SAC, 5, 12,20),
                sell(Items.WRITABLE_BOOK, 1, 12,20),
        };
    }

    public static TradeOffers.Factory[] trades4() {
        return new TradeOffers.Factory[]{
                buy(Items.COMPASS,5, 4, 12, 10),
                sell(Items.BOOKSHELF, 20, 12,20),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.PLAINS_TRADES, 2, 10), VillagerType.PLAINS),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.DESERT_TRADES,2, 10), VillagerType.DESERT),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.SAVANNA_TRADES, 2, 10), VillagerType.SAVANNA),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.JUNGLE_TRADES, 2, 10), VillagerType.JUNGLE),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.SWAMP_TRADES, 2, 10), VillagerType.SWAMP),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.TAIGA_TRADES, 2, 10), VillagerType.TAIGA),
                BiomeSpecific(addEnchantment(ModTags.Enchantments.SNOW_TRADES, 2, 10), VillagerType.SNOW)
        };
    }
}
