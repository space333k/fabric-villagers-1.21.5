package com.space333.villagers.trades;

import com.space333.villagers.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerType;

import static com.space333.villagers.trades.TradeCreationHelper.*;

public class FletcherTrade {

    public static TradeOffers.Factory[] trades1() {
        return new TradeOffers.Factory[]{
                    sell(Items.STICK, 32, 16, 2),
                    process(Items.FLINT, 10, Items.GRAVEL, 10, 1, 12, 1)
        };
    }

    public static TradeOffers.Factory[] trades2() {
        return new TradeOffers.Factory[]{
                sell(Items.FLINT, 26, 12, 10),
                sell(Items.STRING, 14,16,10),
                buy(Items.ARROW, 1, 16, 12,1),
        };
    }

    public static TradeOffers.Factory[] trades3() {
        return new TradeOffers.Factory[]{
                buy(Items.BOW, 1, 2, 12, 10),
                buy(Items.CROSSBOW, 1, 3, 12, 10),
        };
    }

}
