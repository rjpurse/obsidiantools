package com.rjpurse.obsidiantools.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityPipe extends TileEntity {

	
	public ForgeDirection[] connections = new ForgeDirection[6];
	
	public void updateEntity(){
		updateConnections();
	}
	
	private void updateConnections(){
		if(this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityPipe) 
			connections[0] = ForgeDirection.UP;
		else
			connections[0] = null;
		
		if(this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityPipe) 
			connections[1] = ForgeDirection.DOWN;
		else
			connections[1] = null;
		
		if(this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityPipe) 
			connections[2] = ForgeDirection.NORTH;
		else
			connections[2] = null;
		
		if(this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityPipe) 
			connections[3] = ForgeDirection.EAST;
		else
			connections[3] = null;
		
		if(this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityPipe) 
			connections[4] = ForgeDirection.SOUTH;
		else
			connections[4] = null;
		
		if(this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityPipe) 
			connections[5] = ForgeDirection.WEST;
		else
			connections[5] = null;
		
		
	}
	
}


