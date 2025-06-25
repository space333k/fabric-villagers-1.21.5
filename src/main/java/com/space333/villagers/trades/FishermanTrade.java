package com.space333.villagers.trades;

import com.google.common.collect.ImmutableMap;
import com.space333.fletching.util.ComponentHelper;
import com.space333.villagers.util.ModTags;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerType;

import java.util.Optional;

import static com.space333.villagers.trades.TradeCreationHelper.*;

public class FishermanTrade {

    public static TradeOffers.Factory[] trades4() {
        return new TradeOffers.Factory[]{
                sell(Items.TROPICAL_FISH, 6, 12, 20),
                new TradeOffers.TypeAwareBuyForOneEmeraldFactory(
                        1,
                        12,
                        20,
                        ImmutableMap.<RegistryKey<VillagerType>, Item>builder()
                                .put(VillagerType.PLAINS, Items.OAK_BOAT)
                                .put(VillagerType.TAIGA, Items.SPRUCE_BOAT)
                                .put(VillagerType.SNOW, Items.SPRUCE_BOAT)
                                .put(VillagerType.DESERT, Items.JUNGLE_BOAT)
                                .put(VillagerType.JUNGLE, Items.JUNGLE_BOAT)
                                .put(VillagerType.SAVANNA, Items.ACACIA_BOAT)
                                .put(VillagerType.SWAMP, Items.DARK_OAK_BOAT)
                                .build()
                )
        };
    }

    public static TradeOffers.Factory[] trades5() {
        return new TradeOffers.Factory[]{
                addEnchantment(ModTags.Enchantments.FISHERMAN_TRADES, 2, 30)
        };
    }




}
