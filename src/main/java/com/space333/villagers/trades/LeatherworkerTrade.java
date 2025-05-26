package com.space333.villagers.trades;

import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;

import static com.space333.villagers.trades.TradeCreationHelper.*;

public class LeatherworkerTrade {

    public static TradeOffers.Factory[] trades3() {
        return new TradeOffers.Factory[]{
                    sell(Items.RABBIT_HIDE, 6, 12, 20),
                    buy(Items.PHANTOM_MEMBRANE, 1, 1, 12, 1)
        };
    }

    public static TradeOffers.Factory[] trades5() {
        return new TradeOffers.Factory[]{
                buy(Items.SADDLE, 1, 6, 12, 30),
        };
    }

}
