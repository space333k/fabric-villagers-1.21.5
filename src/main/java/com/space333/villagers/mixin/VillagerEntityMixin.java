package com.space333.villagers.mixin;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.village.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends MerchantEntity {

    public VillagerEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "restock", at = @At("TAIL"))
    private void forceReroll(CallbackInfo ci) {
        VillagerEntity villager = (VillagerEntity) (Object) this;

        VillagerData data = villager.getVillagerData();
        int level = data.level();
        RegistryKey<VillagerProfession> profession = (RegistryKey<VillagerProfession>)data.profession().getKey().orElse(null);
        Int2ObjectMap<TradeOffers.Factory[]> pool = TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(profession);

        villager.getOffers().clear();
        if(pool != null && !pool.isEmpty()) {
            for(int i = 1; i <= level; i++) {
                TradeOffers.Factory[] factory = pool.get(i);
                if (factory != null) {
                    TradeOfferList tradeOfferList = villager.getOffers();
                    this.fillRecipesFromPool(tradeOfferList, factory, 2);
                }
            }
        }
    }


    protected void fillRecipesFromPool(TradeOfferList recipeList, TradeOffers.Factory[] pool, int count) {
        ArrayList<TradeOffers.Factory> arrayList = Lists.newArrayList(pool);
        int i = 0;

        while (i < count && !arrayList.isEmpty()) {
            TradeOffer tradeOffer = ((TradeOffers.Factory)arrayList.remove(this.random.nextInt(arrayList.size()))).create(this, this.random);
            if (tradeOffer != null) {
                recipeList.add(tradeOffer);
                i++;
            }
        }
    }
}
