package com.benonardo.vmmod.forge.events;

import com.benonardo.vmmod.forge.init.VmItems;
import net.minecraft.item.Item;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.entity.player.PlayerEntity;


@Mod.EventBusSubscriber
public class VmEvents {

    @SubscribeEvent
    public static void onPlayerPickupItem(EntityItemPickupEvent event) {
        PlayerEntity player = event.getPlayer();
        Item item = event.getItem().getItem().getItem();
        if (item == VmItems.TOTEM_OF_DYING.get()) {
            player.setHealth(0.0F);
            for (PlayerEntity everyPlayer : player.getEntityWorld().getPlayers()) {
                everyPlayer.sendMessage(new TranslationTextComponent("death.vmmod.totem", new String[]{player.getName().getString()}), everyPlayer.getUniqueID());
            }
        }
    }
}
