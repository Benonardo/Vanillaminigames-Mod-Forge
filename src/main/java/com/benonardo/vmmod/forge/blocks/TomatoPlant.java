package com.benonardo.vmmod.forge.blocks;
// Created by booky10 in VanillaMinigamesMod (21:27 21.02.21)

import com.benonardo.vmmod.forge.init.Items;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PotatoBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;

import javax.annotation.Nonnull;

public class TomatoPlant extends PotatoBlock {

    public TomatoPlant() {
        super(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
    }

    @Nonnull
    @Override
    protected IItemProvider getSeedsItem() {
        return Items.TOMATO_SEEDS.get();
    }
}