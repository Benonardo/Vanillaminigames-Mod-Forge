package com.benonardo.vmmod.forge.items;

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.entities.ChaosBeeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class ChaosBeeSpawnEgg extends SpawnEggItem {

    public ChaosBeeSpawnEgg() {
        super(ChaosBeeEntity.ENTITY_TYPE, 0xffff00, 0x0000ff, new Item.Properties().group(VmMod.VM_GROUP));
    }
}