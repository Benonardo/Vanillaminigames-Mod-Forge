package com.benonardo.vmmod.forge.items;

import com.benonardo.vmmod.forge.VmMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Tomato extends Item {

    public Tomato() {
        super(new Item.Properties().group(VmMod.VM_GROUP).food(new Food.Builder().hunger(5).saturation(1.5f).build()));
    }
}