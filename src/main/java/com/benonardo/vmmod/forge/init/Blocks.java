package com.benonardo.vmmod.forge.init;
// Created by booky10 in VanillaMinigamesMod (21:26 21.02.21)

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.blocks.TomatoPlant;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VmMod.MOD_ID);

    public static final RegistryObject<Block> TOMATO_PLANT = BLOCKS.register("tomato_plant", TomatoPlant::new);
}