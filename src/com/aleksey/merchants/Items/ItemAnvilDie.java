package com.aleksey.merchants.Items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.aleksey.merchants.Core.BlockList;
import com.aleksey.merchants.TileEntities.TileEntityAnvilDie;
import com.bioxx.tfc.TFCBlocks;
import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAnvilDie extends ItemTerra
{
    public ItemAnvilDie()
    {
        super();
        
        setMaxDamage(0);
        setCreativeTab(TFCTabs.TFCMisc);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registerer)
    {
        this.itemIcon = registerer.registerIcon("merchants:AnvilDie");
    }
    
    @Override
    public EnumSize getSize(ItemStack is)
    {
        return EnumSize.SMALL;
    }

    @Override
    public EnumWeight getWeight(ItemStack is)
    {
        return EnumWeight.MEDIUM;
    }
    
    @Override
    public boolean canStack()
    {
      return false;
    }
    
    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if(side != 1)
            return false;
        
        Block block = world.getBlock(x, y, z);
        
        if(block != TFCBlocks.WoodVert && block != TFCBlocks.WoodVert2)
            return false;
        
        world.setBlock( x, y, z, BlockList.AnvilDie, 0, 0x2);
        
        if(world.isRemote)
            world.markBlockForUpdate(x, y, z);

        TileEntityAnvilDie tileEntity = (TileEntityAnvilDie)world.getTileEntity(x, y, z);
        
        if(tileEntity != null)
            tileEntity.setInventorySlotContents(3, itemstack);
        
        entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
        entityplayer.onUpdate();
        
        return true;
    }
}