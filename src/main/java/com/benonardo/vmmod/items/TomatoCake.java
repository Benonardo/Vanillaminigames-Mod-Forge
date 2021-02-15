package com.benonardo.vmmod.items;

import com.benonardo.vmmod.VmMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class TomatoCake extends Item {

    public TomatoCake() {
        super(new Properties()
                .group(VmMod.VM_GROUP)
                .food(new Food.Builder()
                        .hunger(10)
                        .saturation(3.0f)

                        .build()
                )
        );
    }

}