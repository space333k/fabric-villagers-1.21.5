package com.space333.villagers.datagen;

import com.space333.villagers.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryWrapper;
import net.space333.enchants.enchantment.ModEnchantments;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentTagProvider extends FabricTagProvider.EnchantmentTagProvider {
    public ModEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Enchantments.PLAINS_TRADES)
                .add(Enchantments.PROJECTILE_PROTECTION)
                .add(Enchantments.BANE_OF_ARTHROPODS)
                .add(Enchantments.IMPALING)
                .addOptional(Enchantments.FLAME);

        getOrCreateTagBuilder(ModTags.Enchantments.DESERT_TRADES)
                .add(Enchantments.FIRE_PROTECTION)
                .add(Enchantments.FIRE_ASPECT)
                .add(Enchantments.DENSITY)
                .addOptional(Enchantments.QUICK_CHARGE);

        getOrCreateTagBuilder(ModTags.Enchantments.SAVANNA_TRADES)
                .add(Enchantments.THORNS)
                .add(Enchantments.SMITE)
                .add(Enchantments.SWEEPING_EDGE)
                .addOptional(ModEnchantments.REACH)
                .addOptional(Enchantments.EFFICIENCY);

        getOrCreateTagBuilder(ModTags.Enchantments.JUNGLE_TRADES)
                .add(Enchantments.FORTUNE)
                .add(Enchantments.RIPTIDE)
                .add(Enchantments.INFINITY)
                .addOptional(Enchantments.EFFICIENCY);

        getOrCreateTagBuilder(ModTags.Enchantments.SWAMP_TRADES)
                .add(Enchantments.RESPIRATION)
                .add(Enchantments.LOOTING)
                .add(Enchantments.CHANNELING)
                .addOptional(ModEnchantments.SYPHON)
                .addOptional(Enchantments.UNBREAKING);

        getOrCreateTagBuilder(ModTags.Enchantments.TAIGA_TRADES)
                .add(Enchantments.BLAST_PROTECTION)
                .add(Enchantments.BREACH)
                .addOptional(ModEnchantments.INHUMAIN)
                .addOptional(ModEnchantments.EXCAVATOR)
                .addOptional(Enchantments.PROTECTION)
                .addOptional(Enchantments.PIERCING);

        getOrCreateTagBuilder(ModTags.Enchantments.SNOW_TRADES)
                .add(Enchantments.LOYALTY)
                .add(Enchantments.DEPTH_STRIDER)
                .addOptional(ModEnchantments.MAGIC_PROTECTION)
                .addOptional(ModEnchantments.BERSERKER)
                .addOptional(Enchantments.SHARPNESS)
                .addOptional(Enchantments.UNBREAKING);

        getOrCreateTagBuilder(ModTags.Enchantments.FLETCHER_TRADES)
                .add(Enchantments.MULTISHOT)
                .addOptional(Enchantments.PUNCH);

        getOrCreateTagBuilder(ModTags.Enchantments.FISHERMAN_TRADES)
                .add(Enchantments.LURE)
                .add(Enchantments.LUCK_OF_THE_SEA);
    }
}
