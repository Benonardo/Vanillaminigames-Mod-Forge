package com.benonardo.vmmod.forge.utils;

import com.benonardo.vmmod.forge.init.Items;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import javax.annotation.Nonnull;

public class TrollFaceMaterial implements IArmorMaterial {

    @Override
    public int getDurability(@Nonnull EquipmentSlotType slot) {
        return 74088;
    }

    @Override
    public int getDamageReductionAmount(@Nonnull EquipmentSlotType slot) {
        return 42;
    }

    @Override
    public int getEnchantability() {
        return 42;
    }

    @Override
    @Nonnull
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }

    @Nonnull
    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(Items.TOMATO_CAKE.get());
    }

    @Nonnull
    @Override
    public String getName() {
        return "troll_face";
    }

    @Override
    public float getToughness() {
        return 3;
    }

    @Override
    public float getKnockbackResistance() {
        return 100;
    }
}