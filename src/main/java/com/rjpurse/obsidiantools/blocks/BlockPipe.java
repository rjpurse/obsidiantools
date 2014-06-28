package com.rjpurse.obsidiantools.blocks;

import com.rjpurse.obsidiantools.tileentity.TileEntityPipe;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPipe extends BlockContainer{

	protected BlockPipe() {
		super(Material.ground);
		float pixel = 1F / 16F;
		this.setBlockBounds(11*pixel/2, 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2);
		this.useNeighborBrightness=true;
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityPipe();	
	}

	
	
}
