package com.benonardo.vmmod.forge.items;
// Created by booky10 in VanillaMinigamesMod (21:53 21.02.21)

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.init.Blocks;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class TomatoSeeds extends BlockNamedItem {

    public TomatoSeeds() {
        super(Blocks.TOMATO_PLANT.get(), new Item.Properties().group(VmMod.VM_GROUP));
    }
}