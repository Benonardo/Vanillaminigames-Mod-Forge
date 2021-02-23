package com.benonardo.vmmod.forge.items;
// Created by booky10 in VanillaMinigamesMod (12:37 23.02.21)

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.entities.FakePlayerEntity;
import com.benonardo.vmmod.forge.entities.TomatoEntity;
import net.minecraft.item.SpawnEggItem;

public class TomatoSpawnEgg extends SpawnEggItem {

    public TomatoSpawnEgg() {
        super(TomatoEntity.ENTITY_TYPE, 0xff0000, 0x00ff00, new Properties().group(VmMod.VM_GROUP));
    }
}