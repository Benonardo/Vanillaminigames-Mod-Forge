package com.benonardo.vmmod.fabric.items;

import com.benonardo.vmmod.fabric.VmMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonTomato extends Item {

    public PoisonTomato() {
        super(new Item.Properties()
                .group(VmMod.VM_GROUP)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(1.2f)
                        .effect(() -> new EffectInstance(Effects.NAUSEA, 15 * 20, 0), 1.0f)
                        .effect(() -> new EffectInstance(Effects.POISON, 15 * 20, 1), 1.0f)
                        .build()
                )
        );
    }

}