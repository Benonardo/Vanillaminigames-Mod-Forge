package com.benonardo.vmmod.forge.items;

import com.benonardo.vmmod.forge.VmMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class TotemOfDying extends Item {

    public static final DamageSource DAMAGE_SOURCE = new DamageSource("totem").setDamageBypassesArmor().setDamageAllowedInCreativeMode();

    public TotemOfDying() {
        super(new Item.Properties().group(VmMod.VM_GROUP).maxStackSize(1));
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull Entity entity, int slot, boolean selected) {
        if (!(entity instanceof LivingEntity)) return;
        if (((LivingEntity) entity).getShouldBeDead()) return;

        entity.attackEntityFrom(TotemOfDying.DAMAGE_SOURCE, Float.MAX_VALUE);
    }
}
