package com.benonardo.vmmod.forge.init;
// Created by booky10 in vmmod (21:00 19.02.21)

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.entities.ChaosBeeEntity;
import com.benonardo.vmmod.forge.entities.FakePlayerEntity;
import net.minecraft.client.renderer.entity.BeeRenderer;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Entities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, VmMod.MOD_ID);

    public static final RegistryObject<EntityType<ChaosBeeEntity>> CHAOS_BEE = ENTITIES.register("chaos_bee", () -> ChaosBeeEntity.ENTITY_TYPE);
    public static final RegistryObject<EntityType<FakePlayerEntity>> FAKE_PLAYER = ENTITIES.register("fake_player", () -> FakePlayerEntity.ENTITY_TYPE);
}