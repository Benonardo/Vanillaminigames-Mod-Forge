package com.benonardo.vmmod.forge.entities;
// Created by booky10 in VanillaMinigamesMod (11:33 23.02.21)

import com.benonardo.vmmod.forge.VmMod;
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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.HandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.MobSpawnInfo;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FakePlayerEntity extends CreatureEntity {

    public static final EntityType<FakePlayerEntity> ENTITY_TYPE = EntityType.Builder.create((EntityType.IFactory<FakePlayerEntity>) (type, world) -> new FakePlayerEntity(world), EntityClassification.MONSTER).size(0.6F, 1.8F).trackingRange(16).build(VmMod.MOD_ID + "fake_player");
    public static final MobSpawnInfo.Spawners SPAWNERS = new MobSpawnInfo.Spawners(ENTITY_TYPE, 2, 1, 1);

    public final NonNullList<ItemStack> armorInventory = NonNullList.withSize(4, ItemStack.EMPTY);
    public final NonNullList<ItemStack> handInventory = NonNullList.withSize(4, ItemStack.EMPTY);

    public FakePlayerEntity(World world) {
        super(ENTITY_TYPE, world);
    }

    @Nonnull
    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return armorInventory;
    }

    @Nonnull
    @Override
    public ItemStack getItemStackFromSlot(@Nonnull EquipmentSlotType slot) {
        return slot.getSlotType() == EquipmentSlotType.Group.ARMOR ? armorInventory.get(slot.getIndex()) : handInventory.get(slot.getIndex());
    }

    @Override
    public void setItemStackToSlot(@Nonnull EquipmentSlotType slot, @Nonnull ItemStack stack) {
        if (slot.getSlotType() == EquipmentSlotType.Group.ARMOR)
            armorInventory.set(slot.getIndex(), stack);
        else
            handInventory.set(slot.getIndex(), stack);
    }

    @Nonnull
    @Override
    public HandSide getPrimaryHand() {
        return HandSide.RIGHT;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return LivingEntity.registerAttributes()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 32.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.MAX_HEALTH, 40D)
                .createMutableAttribute(Attributes.ARMOR, 5.0D);
    }

    @Nullable
    @Override
    public ITextComponent getCustomName() {
        return new TranslationTextComponent("vmmod.fake_player.name");
    }

    @Override
    public boolean isCustomNameVisible() {
        return true;
    }

    @Override
    public void registerGoals() {
        goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 16.0F));
        goalSelector.addGoal(8, new LookRandomlyGoal(this));
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        goalSelector.addGoal(2, new SwimGoal(this));

        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void checkDespawn() {
    }

    @Override
    public void onDeath(@Nonnull DamageSource cause) {
        super.onDeath(cause);

        LivingEntity attacker = getAttackingEntity();
        if (attacker != null && attacker.getType().equals(EntityType.PLAYER)) {
            attacker.sendMessage(new TranslationTextComponent("vmmod.fake_player.message"), getUniqueID());
            attacker.addPotionEffect(new EffectInstance(Effects.UNLUCK, 878 * 20, 9, false, false));
        }
    }
}