package com.benonardo.vmmod.forge.items;

import com.benonardo.vmmod.forge.VmMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class TomatoCake extends Item {

    public TomatoCake() {
        super(new Properties().group(VmMod.VM_GROUP).food(new Food.Builder().hunger(10).saturation(3.0f).build()));
    }
}