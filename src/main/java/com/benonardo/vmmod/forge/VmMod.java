package com.benonardo.vmmod.forge;

import com.benonardo.vmmod.forge.entities.ChaosBeeEntity;
import com.benonardo.vmmod.forge.events.Events;
import com.benonardo.vmmod.forge.init.Blocks;
import com.benonardo.vmmod.forge.init.Entities;
import com.benonardo.vmmod.forge.init.Items;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.BeeRenderer;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("vmmod")
public class VmMod {

    public static final String MOD_ID = "vmmod";

    public VmMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(new Events());

        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Entities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Blocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> GlobalEntityTypeAttributes.put(Entities.CHAOS_BEE.get(), ChaosBeeEntity.setCustomAttributes().create()));
        RenderingRegistry.registerEntityRenderingHandler(Entities.CHAOS_BEE.get(), BeeRenderer::new);

        RenderTypeLookup.setRenderLayer(Blocks.TOMATO_PLANT.get(), RenderType.getCutout());
    }

    public static final ItemGroup VM_GROUP = new ItemGroup("vanillaminigames") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.TOMATO.get());
        }
    };
}