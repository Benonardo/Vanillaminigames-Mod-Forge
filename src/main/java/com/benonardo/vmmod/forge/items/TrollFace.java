package com.benonardo.vmmod.forge.items;

import com.benonardo.vmmod.forge.VmMod;
import com.benonardo.vmmod.forge.utils.TrollFaceMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class TrollFace extends ArmorItem {

    public TrollFace() {
        super(new TrollFaceMaterial(), EquipmentSlotType.HEAD, new Item.Properties().group(VmMod.VM_GROUP).maxStackSize(1));
    }
}
