package com.benonardo.vmmod.forge.renderer;
// Created by booky10 in VanillaMinigamesMod (14:36 23.02.21)

import com.benonardo.vmmod.forge.entities.TomatoEntity;
import com.benonardo.vmmod.forge.init.Items;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.Nonnull;
import java.util.Random;

public class TomatoRenderer extends EntityRenderer<TomatoEntity> {

    private final ItemRenderer itemRenderer;
    private final Random random = new Random();

    public TomatoRenderer(EntityRendererManager renderManager, ItemRenderer itemRenderer) {
        super(renderManager);

        this.itemRenderer = itemRenderer;
        this.shadowOpaque = 0.75F;
        this.shadowSize = 0.15F;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void render(TomatoEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, @Nonnull IRenderTypeBuffer bugger, int packedLight) {
        matrixStack.push();
        ItemStack itemstack = Items.TOMATO.get().getDefaultInstance();

        int i = itemstack.isEmpty() ? 187 : Item.getIdFromItem(itemstack.getItem()) + itemstack.getDamage();
        random.setSeed(i);

        IBakedModel model = itemRenderer.getItemModelWithOverrides(itemstack, entity.world, null);
        boolean gui3D = model.isGui3d();

        float f1 = MathHelper.sin(((float) entity.getAge() + partialTicks) / 10.0F + entity.hoverStart) * 0.1F + 0.1F;
        float f2 = model.getItemCameraTransforms().getTransform(ItemCameraTransforms.TransformType.GROUND).scale.getY();
        matrixStack.translate(0.0D, (f1 + 0.25F * f2), 0.0D);

        float f3 = entity.getItemHover(partialTicks);
        matrixStack.rotate(Vector3f.YP.rotation(f3));

        if (!gui3D) {
            float f7 = -0.0F * (float) (0) * 0.5F;
            float f8 = -0.0F * (float) (0) * 0.5F;
            float f9 = -0.09375F * (float) (0) * 0.5F;

            matrixStack.translate(f7, f8, f9);
        }

        matrixStack.push();
        itemRenderer.renderItem(itemstack, ItemCameraTransforms.TransformType.GROUND, false, matrixStack, bugger, packedLight, OverlayTexture.NO_OVERLAY, model);
        matrixStack.pop();

        if (!gui3D) matrixStack.translate(0.0, 0.0, 0.09375F);

        matrixStack.pop();
        super.render(entity, entityYaw, partialTicks, matrixStack, bugger, packedLight);
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public ResourceLocation getEntityTexture(@Nonnull TomatoEntity entity) {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }
}