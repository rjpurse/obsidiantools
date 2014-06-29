package com.rjpurse.obsidiantools.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import com.rjpurse.obsidiantools.ObsidianTools;
import com.rjpurse.obsidiantools.tileentity.TileEntityObsidianFurnace;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ObsidianFurnace extends BlockContainer {
	
	private final boolean isActive;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	public ObsidianFurnace(Boolean isActive) {
		super(Material.iron);
		this.isActive = isActive;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileEntityObsidianFurnace();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		
		this.blockIcon = iconRegister.registerIcon(ObsidianTools.MODID + ":obsidian_furnace_side");
		
		this.iconFront = iconRegister.registerIcon(ObsidianTools.MODID + ":" + 
				(this.isActive ? "obsidian_furnace_front_on" : "obsidian_furnace_front_off"));
		
		this.iconTop = iconRegister.registerIcon(ObsidianTools.MODID + ":obsidian_furnace_top");

	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : (side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon)));
		//return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata ? this.blockIcon : this.iconFront));
	}
	
	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(ObsidianBlocks.obsidianFurnaceIdle);
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote){
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			
			Byte b0 = 3;
			
			if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
		
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack){
		
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				
		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if(itemStack.hasDisplayName()){
			((TileEntityObsidianFurnace)world.getTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz ){
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, ObsidianTools.instance, ObsidianTools.guiIDObsidianFurnace, world, x, y, z);
		}
		return true;
	}

	public static void updateObsidianFurnaceBlockState(boolean isBurning, World world, int x, int y, int z) {
		
		int i = world.getBlockMetadata(x, y, z);
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if(isBurning){
			world.setBlock(x, y, z, ObsidianBlocks.obsidianFurnaceActive);
		} else {
			world.setBlock(x, y, z, ObsidianBlocks.obsidianFurnaceActive);
		}
		
		world.setBlockMetadataWithNotify(x, y, z, i, 2);
		
		if(tileEntity != null) {
			tileEntity.validate();
			world.setTileEntity(x, y, z, tileEntity);
		}
	}
}
