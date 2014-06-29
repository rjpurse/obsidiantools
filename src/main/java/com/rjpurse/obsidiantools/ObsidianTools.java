package com.rjpurse.obsidiantools;

import net.minecraft.creativetab.CreativeTabs;
import com.rjpurse.obsidiantools.armor.ObsidianArmor;
import com.rjpurse.obsidiantools.blocks.ObsidianBlocks;
import com.rjpurse.obsidiantools.handler.GuiHandler;
import com.rjpurse.obsidiantools.items.ObsidianItems;
import com.rjpurse.obsidiantools.tileentity.TileEntityObsidianFurnace;
import com.rjpurse.obsidiantools.tileentity.TileEntityPipe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=ObsidianTools.MODID, version=ObsidianTools.VERSION)
public class ObsidianTools {
	
	public static final String MODID = "obsidiantools";
	//public static final String NAME = "Obsidian Tools";
	public static final String VERSION = "1.0.2";
	
	 
	public static final int guiIDObsidianFurnace = 0;

	//TODO Move to separate package and class
	public static CreativeTabs tabObsidianTools = new CreativeTabObsidianTools(MODID);
			

    @Instance
	public static ObsidianTools instance;

    @SidedProxy(clientSide="com.rjpurse.obsidiantools.ClientProxy", 
    		serverSide="com.rjpurse.obsidiantools.CommonProxy")
    public static CommonProxy proxy;
    
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		ObsidianItems.initializeObsidianItems();
		ObsidianArmor.initializeObsidianArmor();
		ObsidianBlocks.initializeObsidianBlocks();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(ObsidianTools.instance, new GuiHandler());
		
		GameRegistry.registerTileEntity(TileEntityObsidianFurnace.class, "tileEntityObsidianFurnace");
		GameRegistry.registerTileEntity(TileEntityPipe.class, "tileEntityPipe");
		
		
		ObsidianItems.registerObsidianItems();
		ObsidianItems.registerCraftingRecipies();
				
		ObsidianArmor.registerObsidianArmorItems();
		ObsidianArmor.registerObsidianArmorRecipies();
		
		ObsidianBlocks.registerObsidianBlocks();
		ObsidianBlocks.registerCraftingRecipies();
		
		proxy.registerProxies();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
	
	
	

	
}

