package com.space333.villagers.mixin;

import com.space333.villagers.trades.ButcherTrade;
import com.space333.villagers.trades.FletcherTrade;
import com.space333.villagers.trades.LeatherworkerTrade;
import com.space333.villagers.trades.LibrarianTrade;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.village.TradeOffers.PROFESSION_TO_LEVELED_TRADE;

@Mixin(TradeOffers.class)
public class TradeOffersMixin {

    @Inject(method = "<clinit>", at = @At(value = "TAIL"))
    private static void changeTrades(CallbackInfo ci) {
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN).replace(1, LibrarianTrade.trades1());
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN).replace(2, LibrarianTrade.trades2());
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN).replace(3, LibrarianTrade.trades3());
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN).replace(4, LibrarianTrade.trades4());

        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.FLETCHER).replace(1, FletcherTrade.trades1());
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.FLETCHER).replace(2, FletcherTrade.trades2());
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.FLETCHER).replace(3, FletcherTrade.trades3());

        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LEATHERWORKER).replace(3, LeatherworkerTrade.trades3());
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LEATHERWORKER).replace(5, LeatherworkerTrade.trades5());

        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.BUTCHER).replace(4, ButcherTrade.trades4());
        PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.BUTCHER).replace(5, ButcherTrade.trades5());

    }

}
