package com.space333.villagers.trades;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerType;

public class TradeCreationHelper {

    public static TradeOffers.BuyItemFactory sell(Item item, int count, int uses, int xp) {
        return new TradeOffers.BuyItemFactory(item, count, uses, xp);
    }

    public static TradeOffers.Factory buy(Item item, int count, int price, int uses, int xp) {
        ItemStack itemStack = new ItemStack(item);
        if(itemStack.isEnchantable()) {
            return new TradeOffers.SellEnchantedToolFactory(item, price, uses, xp);
        }
        return new TradeOffers.SellItemFactory(itemStack, price, count, uses, xp, 0.2f);
    }

    public static TradeOffers.Factory process(Item item, int count, Item product, int processedCount, int price, int uses, int xp) {
        return new TradeOffers.ProcessItemFactory(item, count, price, product, processedCount, uses, xp, 0.05F);
    }

    public static TradeOffers.EnchantBookFactory addEnchantment(TagKey<Enchantment> enchantment, int level, int xp) {
        return new TradeOffers.EnchantBookFactory(xp, level, level, enchantment);
    }

    public static TradeOffers.Factory BiomeSpecific(TradeOffers.Factory factory, RegistryKey<VillagerType> village) {
        return TradeOffers.TypedWrapperFactory.of(
                factory,
                village
        );
    }
}
