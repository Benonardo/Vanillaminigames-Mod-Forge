package com.benonardo.vmmod.forge.init;

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VmMod.MOD_ID);

    public static final RegistryObject<Item> POISON_TOMATO = ITEMS.register("poison_tomato", PoisonTomato::new);
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", Tomato::new);
    public static final RegistryObject<Item> TOMATO_CAKE = ITEMS.register("tomato_cake", TomatoCake::new);
    public static final RegistryObject<Item> UNBAKED_TOMATO_CAKE = ITEMS.register("unbaked_tomato_cake", UnbakedTomatoCake::new);
    public static final RegistryObject<Item> TROLL_FACE = ITEMS.register("troll_face", TrollFace::new);
    public static final RegistryObject<Item> TOTEM_OF_DYING = ITEMS.register("totem_of_dying", TotemOfDying::new);
    public static final RegistryObject<Item> CHAOS_BEE_SPAWN_EGG = ITEMS.register("chaos_bee_spawn_egg", ChaosBeeSpawnEgg::new);
    public static final RegistryObject<Item> TOMATO_SHIT = ITEMS.register("tomato_shit", TomatoShit::new);
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", TomatoSeeds::new);
    public static final RegistryObject<Item> PEPO_RAGE = ITEMS.register("pepo_rage", PepoRage::new);
}
