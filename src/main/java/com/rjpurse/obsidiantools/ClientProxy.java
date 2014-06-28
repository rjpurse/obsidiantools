package com.rjpurse.obsidiantools;

import com.rjpurse.obsidiantools.tileentity.TileEntityPipe;
import com.rjpurse.obsidiantools.tileentity.TileEntityRenderPipe;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerProxies() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipe.class, new TileEntityRenderPipe());
	}
}
