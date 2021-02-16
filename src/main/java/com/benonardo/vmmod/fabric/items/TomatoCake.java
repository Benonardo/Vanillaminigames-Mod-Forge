package com.benonardo.vmmod.fabric.items;

import com.benonardo.vmmod.fabric.VmMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

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