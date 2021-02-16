package com.benonardo.vmmod.fabric.items;

import com.benonardo.vmmod.fabric.VmMod;
import net.minecraft.item.Item;

public class BasicItem extends Item {
    public BasicItem() {
        super(new Item.Properties().group(VmMod.VM_GROUP));
    }
}
