package com.benonardo.vmmod.forge.items;
// Created by booky10 in VanillaMinigamesMod (15:31 22.02.21)

import com.benonardo.vmmod.forge.VmMod;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.*;

public class PepoRage extends Item {

    public static final List<UUID> ACTIVE = new ArrayList<>();

    public PepoRage() {
        super(new Item.Properties().group(VmMod.VM_GROUP).maxStackSize(16).isImmuneToFire());
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
        Entity pointedEntity = Minecraft.getInstance().pointedEntity;
        ItemStack item = player.getHeldItem(hand);

        item.setCount(item.getCount() - 1);
        if (!player.isCreative()) player.setHeldItem(hand, item);

        if (pointedEntity != null && pointedEntity.getType().equals(EntityType.PLAYER)) player = (PlayerEntity) pointedEntity;
        if (ACTIVE.contains(player.getUniqueID())) return ActionResult.resultPass(item);
        ACTIVE.add(player.getUniqueID());

        PlayerEntity finalPlayer = player;
        finalPlayer.playSound(SoundType.ANVIL.getPlaceSound(), SoundCategory.PLAYERS, 1, 0.25f);

        NonNullList<ItemStack> inventoryBackup = NonNullList.create();
        inventoryBackup.addAll(player.inventory.mainInventory);

        new Timer().schedule(new TimerTask() {
            private int i = 50;

            @Override
            public void run() {
                if (i <= 0) {
                    cancel();

                    Minecraft.getInstance().enqueue(() -> {
                        finalPlayer.inventory.mainInventory.clear();
                        for (int j = 0; j < inventoryBackup.size(); j++)
                            finalPlayer.inventory.mainInventory.set(j, inventoryBackup.get(j));

                        ACTIVE.remove(finalPlayer.getUniqueID());
                    });
                } else {
                    --i;

                    Minecraft.getInstance().enqueue(() -> {
                        finalPlayer.playSound(SoundType.LANTERN.getPlaceSound(), SoundCategory.AMBIENT, 1, 2);
                        Collections.shuffle(finalPlayer.inventory.mainInventory, world.getRandom());
                    });
                }
            }
        }, 100, 100);

        return ActionResult.resultSuccess(player.getHeldItem(hand));
    }
}