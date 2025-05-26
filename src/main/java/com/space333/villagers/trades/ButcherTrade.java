package com.space333.villagers.trades;

import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;

import static com.space333.villagers.trades.TradeCreationHelper.buy;
import static com.space333.villagers.trades.TradeCreationHelper.sell;

public class ButcherTrade {

    public static TradeOffers.Factory[] trades4() {
        return new TradeOffers.Factory[]{
                    sell(Items.DRIED_KELP, 10, 12, 20),
                    sell(Items.SWEET_BERRIES, 10, 12, 20)
        };
    }

    public static TradeOffers.Factory[] trades5() {
        return new TradeOffers.Factory[]{
                buy(Items.RABBIT_FOOT, 1, 10, 12, 30),
        };
    }

}
