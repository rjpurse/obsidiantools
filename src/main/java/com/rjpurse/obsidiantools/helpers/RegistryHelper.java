package com.rjpurse.obsidiantools.helpers;

import com.rjpurse.obsidiantools.ObsidianTools;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
public class RegistryHelper {

	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, ObsidianTools.MODID + "_" + block.getUnlocalizedName().substring(5));

	}
	
	public static void registerItem(Item item){
		GameRegistry.registerItem(item, ObsidianTools.MODID + "_" + item.getUnlocalizedName().substring(5));
		
	}
}
