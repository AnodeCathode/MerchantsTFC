package com.aleksey.merchants.Containers.Slots;

import com.aleksey.merchants.Items.ItemTrussel;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotTrussel extends Slot
{
    public SlotTrussel(IInventory iinventory, int slotIndex, int x, int y)
    {
        super(iinventory, slotIndex, x, y);
    }
    @Override
    public boolean isItemValid(ItemStack itemstack)
    {       
        return itemstack.getItem() instanceof ItemTrussel
                && itemstack.hasTagCompound()
                && itemstack.getTagCompound().hasKey(ItemTrussel.TagName_Key)
                ;
    }
}
