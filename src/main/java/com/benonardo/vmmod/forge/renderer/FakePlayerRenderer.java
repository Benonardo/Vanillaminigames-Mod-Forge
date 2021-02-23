package com.benonardo.vmmod.forge.renderer;
// Created by booky10 in VanillaMinigamesMod (11:53 23.02.21)

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.entities.FakePlayerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class FakePlayerRenderer extends LivingRenderer<FakePlayerEntity, PlayerModel<FakePlayerEntity>> {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(VmMod.MOD_ID, "textures/entity/fake_player.png");

    public FakePlayerRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new PlayerModel<>(0, false), 0.5f);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull FakePlayerEntity entity) {
        return TEXTURE_LOCATION;
    }
}