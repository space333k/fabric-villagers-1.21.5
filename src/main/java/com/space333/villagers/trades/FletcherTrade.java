package com.space333.villagers.trades;

import com.space333.fletching.component.ModDataComponentType;
import com.space333.fletching.item.ModItems;
import com.space333.villagers.Villagers;
import com.space333.villagers.util.ModTags;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;

import java.util.Optional;

import static com.space333.fletching.util.ComponentHelper.*;
import static com.space333.fletching.util.ArrowEffect.*;
import static com.space333.villagers.trades.TradeCreationHelper.*;

public class FletcherTrade {

    public static TradeOffers.Factory[] trades1() {
        return new TradeOffers.Factory[]{
                sell(Items.STICK, 32, 16, 2),
                sell(Items.FLINT, 20, 12, 2),
                sell(Items.FEATHER, 18,16,2)
        };
    }

    public static TradeOffers.Factory[] trades2() {
        return new TradeOffers.Factory[]{
                sell(Items.STRING, 14,16,5),
                process(Items.GRAVEL, 10, Items.FLINT, 10, 1, 12, 5),
                buy(Items.ARROW, 16, 1, 12,5),
        };
    }

    public static TradeOffers.Factory[] trades3() {
        return new TradeOffers.Factory[]{
                buy(Items.BOW, 1, 2, 12, 10),
                buy(Items.CROSSBOW, 1, 3, 12, 10),
        };
    }

    public static TradeOffers.Factory[] trades4() {
        if(Villagers.HAS_FLETCHING) {
            return new TradeOffers.Factory[]{
                    new BuyCustomArrowFactory(4, 5, 12, 20),
                    new TradeOffers.SellPotionHoldingItemFactory(Items.ARROW, 5, Items.TIPPED_ARROW, 5, 2, 12, 20)
            };
        }
        return new TradeOffers.Factory[]{
                new TradeOffers.SellPotionHoldingItemFactory(Items.ARROW, 5, Items.TIPPED_ARROW, 5, 2, 12, 20),
                new TradeOffers.SellEnchantedToolFactory(Items.CROSSBOW, 4, 3, 20),
                new TradeOffers.SellEnchantedToolFactory(Items.BOW, 6, 3, 20)
        };
    }

    public static TradeOffers.Factory[] trades5() {
        return new TradeOffers.Factory[]{
                addEnchantment(ModTags.Enchantments.FLETCHER_TRADES, 2, 30)
        };
    }


    public static class BuyCustomArrowFactory implements TradeOffers.Factory {
        private ItemStack sell;
        private int buyCount;
        private final int sellCount;
        private final int price;
        private final int maxUses;
        private final int experience;
        private final Item secondSell;
        private final float priceMultiplier;

        public BuyCustomArrowFactory(int count, int price, int uses, int xp) {
            this.sell = new ItemStack(ModItems.CUSTOM_ARROW);
            this.price = price;
            this.maxUses = uses;
            this.experience = xp;
            this.secondSell = Items.ARROW;
            this.buyCount = count;
            this.sellCount = count;
            this.priceMultiplier = 0.05F;
        }

        @Override
        public TradeOffer create(Entity entity, Random random) {
            ItemStack buy;
            do {
                buy = randomArrowGenerator(random);
            } while (buy.getItem() == Items.ARROW);

            TradedItem tradedItem;

            switch (buy.get(ModDataComponentType.ARROW_TIP)) {
                case TIER2 -> tradedItem = new TradedItem(Items.EMERALD, this.price * 2);
                case TIER3 -> tradedItem = new TradedItem(Items.EMERALD, this.price * 4);
                case TIER4 -> tradedItem = new TradedItem(Items.EMERALD, this.price * 8);
                case null, default -> tradedItem = new TradedItem(Items.EMERALD, this.price);
            }

            buy.setCount(this.buyCount);
            return new TradeOffer(
                    tradedItem, Optional.of(new TradedItem(this.secondSell, this.sellCount)), buy, this.maxUses, this.experience, this.priceMultiplier
            );
        }
    }
}
