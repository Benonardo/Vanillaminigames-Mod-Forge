package com.benonardo.vmmod.forge.items;

import com.benonardo.vmmod.forge.VmMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class TomatoShit extends Item {

    private static final EffectInstance NAUSEA_EFFECT = new EffectInstance(Effects.NAUSEA, 30 * 20, 0);
    private static final EffectInstance POISON_EFFECT = new EffectInstance(Effects.POISON, 30 * 20, 2);
    private static final EffectInstance HUNGER_EFFECT = new EffectInstance(Effects.HUNGER, 30 * 20, 2);
    private static final EffectInstance DAMAGE_EFFECT = new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1);
    private static final Food food = new Food.Builder().hunger(1).saturation(0.0f).effect(() -> NAUSEA_EFFECT, 1.0f).effect(() -> HUNGER_EFFECT, 1.0f).effect(() -> POISON_EFFECT, 1.0f).effect(() -> DAMAGE_EFFECT, 1.0f).build();

    public TomatoShit() {
        super(new Item.Properties().group(VmMod.VM_GROUP).food(food));
    }
}