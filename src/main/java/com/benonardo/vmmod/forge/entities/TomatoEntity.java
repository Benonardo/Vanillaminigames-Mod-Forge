package com.benonardo.vmmod.forge.entities;
// Created by booky10 in VanillaMinigamesMod (14:28 23.02.21)

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.init.Items;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.HandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.Nonnull;

public class TomatoEntity extends CreatureEntity {

    public static final EntityType<TomatoEntity> ENTITY_TYPE = EntityType.Builder.create((EntityType.IFactory<TomatoEntity>) (type, world) -> new TomatoEntity(world), EntityClassification.CREATURE).size(0.25F, 0.25F).build(VmMod.MOD_ID + "tomato");
    public static final MobSpawnInfo.Spawners SPAWNERS = new MobSpawnInfo.Spawners(ENTITY_TYPE, 2, 1, 20);
    public static final NonNullList<ItemStack> ARMOR = NonNullList.withSize(4, ItemStack.EMPTY);

    public final float hoverStart;
    private int age;

    protected TomatoEntity(World world) {
        super(ENTITY_TYPE, world);

        hoverStart = (float) (Math.random() * Math.PI * 2.0D);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return LivingEntity.registerAttributes()
                .createMutableAttribute(Attributes.MAX_HEALTH, 2D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 32)
                .createMutableAttribute(ForgeMod.SWIM_SPEED.get(), 2.5D);
    }

    @Nonnull
    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return ARMOR;
    }

    @Nonnull
    @Override
    public ItemStack getItemStackFromSlot(@Nonnull EquipmentSlotType slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemStackToSlot(@Nonnull EquipmentSlotType slot, @Nonnull ItemStack stack) {
    }

    @Nonnull
    @Override
    public HandSide getPrimaryHand() {
        return HandSide.RIGHT;
    }

    @Override
    public void tick() {
        super.tick();

        if (age != -32768) ++age;
    }

    public int getAge() {
        return age;
    }

    @OnlyIn(Dist.CLIENT)
    public float getItemHover(float partialTicks) {
        return ((float) this.getAge() + partialTicks) / 20.0F + this.hoverStart;
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new SwimGoal(this));
        goalSelector.addGoal(1, new PanicGoal(this, 4.0D));
        goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.TOMATO.get()), false));
        goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }
}