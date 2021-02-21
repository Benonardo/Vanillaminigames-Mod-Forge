package com.benonardo.vmmod.forge.entities;

import com.benonardo.vmmod.forge.VmMod;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ChaosBeeEntity extends BeeEntity {

    public static final EntityType<ChaosBeeEntity> ENTITY_TYPE = EntityType.Builder.create(ChaosBeeEntity::new, EntityClassification.CREATURE).size(0.7F, 0.6F).trackingRange(16).build(VmMod.MOD_ID + "chaos_bee");
    public static final DamageSource DAMAGE_SOURCE = new DamageSource("chaos_bee").setDamageAllowedInCreativeMode().setExplosion().setDamageBypassesArmor();
    public static final MobSpawnInfo.Spawners SPAWNERS = new MobSpawnInfo.Spawners(ENTITY_TYPE, 3, 1, 1);

    public ChaosBeeEntity(EntityType<? extends BeeEntity> type, World world) {
        super(ENTITY_TYPE, world);
    }

    @Nullable
    @Override
    public ITextComponent getCustomName() {
        return new TranslationTextComponent("vmmod.chaos_bee.name");
    }

    @Override
    public boolean isCustomNameVisible() {
        return true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 20.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 3.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Override
    public ChaosBeeEntity func_241840_a(@Nonnull ServerWorld world, @Nonnull AgeableEntity parent) {
        return ENTITY_TYPE.create(world);
    }

    @Override
    public void livingTick() {
        super.livingTick();

        if (hasStung() || getEntityWorld().getRandom().nextFloat() > 0.0005) return;
        if (!getEntityWorld().getGameRules().getBoolean(GameRules.MOB_GRIEFING)) return;

        getEntityWorld().createExplosion(this, DAMAGE_SOURCE, null, getPosX(), getPosY(), getPosZ(), 3, false, Explosion.Mode.DESTROY).doExplosionA();
    }
}