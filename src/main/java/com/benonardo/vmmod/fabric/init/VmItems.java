package com.benonardo.vmmod.fabric.init;

import com.benonardo.vmmod.fabric.VmMod;
import com.benonardo.vmmod.fabric.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VmItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VmMod.MOD_ID);

    public static final RegistryObject<Item> POISON_TOMATO = ITEMS.register(
            "poison_tomato",
            PoisonTomato::new
    );

    public static final RegistryObject<Item> TOMATO = ITEMS.register(
            "tomato",
            Tomato::new
    );

    public static final RegistryObject<Item> TOMATO_CAKE = ITEMS.register(
            "tomato_cake",
            TomatoCake::new
    );

    public static final RegistryObject<Item> UNBAKED_TOMATO_CAKE = ITEMS.register(
            "unbaked_tomato_cake",
            BasicItem::new
    );

    public static final RegistryObject<Item> TROLL_FACE = ITEMS.register(
            "troll_face",
            BasicItem::new
    );
}
