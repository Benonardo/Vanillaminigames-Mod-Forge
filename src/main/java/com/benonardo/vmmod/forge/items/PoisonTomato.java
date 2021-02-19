package com.benonardo.vmmod.forge.items;

import com.benonardo.vmmod.forge.VmMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonTomato extends Item {

    private static final EffectInstance NAUSEA_EFFECT = new EffectInstance(Effects.NAUSEA, 15 * 20, 0);
    private static final EffectInstance POISON_EFFECT = new EffectInstance(Effects.POISON, 15 * 20, 1);
    private static final Food food = new Food.Builder().hunger(4).saturation(1.2f).effect(() -> NAUSEA_EFFECT, 1.0f).effect(() -> POISON_EFFECT, 1.0f).build();

    public PoisonTomato() {
        super(new Item.Properties().group(VmMod.VM_GROUP).food(food));
    }
}