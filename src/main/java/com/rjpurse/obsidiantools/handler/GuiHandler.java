package com.rjpurse.obsidiantools.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rjpurse.obsidiantools.ObsidianTools;
import com.rjpurse.obsidiantools.gui.GuiObsidianFurnace;
import com.rjpurse.obsidiantools.inventory.ContainerObsidianFurnace;
import com.rjpurse.obsidiantools.tileentity.TileEntityObsidianFurnace;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity != null){
			switch(ID){
				case ObsidianTools.guiIDObsidianFurnace:
					if(entity instanceof TileEntityObsidianFurnace){
						return new ContainerObsidianFurnace(player.inventory, (TileEntityObsidianFurnace) entity);
					}
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity != null){
			switch(ID){
				case ObsidianTools.guiIDObsidianFurnace:
					if(entity instanceof TileEntityObsidianFurnace){
						return new GuiObsidianFurnace(player.inventory, (TileEntityObsidianFurnace) entity);
					}
			}
		}
		return null;
	}

}
