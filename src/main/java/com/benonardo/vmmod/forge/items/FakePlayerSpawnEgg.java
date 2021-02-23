package com.benonardo.vmmod.forge.items;
// Created by booky10 in VanillaMinigamesMod (12:37 23.02.21)

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.entities.FakePlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class FakePlayerSpawnEgg extends SpawnEggItem {

    public FakePlayerSpawnEgg() {
        super(FakePlayerEntity.ENTITY_TYPE, 0x0000ff, 0xd8a688, new Item.Properties().group(VmMod.VM_GROUP));
    }
}