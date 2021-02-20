package com.benonardo.vmmod.forge.events;

import com.benonardo.vmmod.forge.entities.ChaosBeeEntity;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Events {

    @SubscribeEvent
    public void onBeeDamage(LivingDamageEvent event) {
        if (!(event.getEntity() instanceof ChaosBeeEntity)) return;

        boolean willDie = event.getAmount() >= event.getEntityLiving().getHealth();
        TextComponent component = new TranslationTextComponent("vmmod.chaos_bee." + (willDie ? "danger" : "warning"));
        event.getEntity().getEntityWorld().getPlayers().stream().filter(player -> player.getPosition().withinDistance(event.getEntity().getPosition(), 25)).forEach(player -> player.sendMessage(component, event.getEntity().getUniqueID()));
    }
}
