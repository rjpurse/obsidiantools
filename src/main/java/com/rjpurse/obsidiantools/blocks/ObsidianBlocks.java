package com.rjpurse.obsidiantools.blocks;

import com.rjpurse.obsidiantools.ObsidianTools;
import com.rjpurse.obsidiantools.helpers.RegistryHelper;

import net.minecraft.block.Block;


public class ObsidianBlocks {
	public static Block obsidianFurnaceIdle;
	public static Block obsidianFurnaceActive;
	public static Block blockPipe;
	
	public static void initializeObsidianBlocks(){
		obsidianFurnaceIdle = new ObsidianFurnace(false).setBlockName("obsidian_furnace_idle").setCreativeTab(ObsidianTools.tabObsidianTools);
		obsidianFurnaceActive = new ObsidianFurnace(true).setBlockName("obsidian_furnace_active").setLightLevel(0.625F);
		blockPipe = new BlockPipe().setBlockName("blockPipe").setCreativeTab(ObsidianTools.tabObsidianTools);
	}
	
	public static void registerObsidianBlocks() {
		RegistryHelper.registerBlock(obsidianFurnaceIdle);
		RegistryHelper.registerBlock(obsidianFurnaceActive);
		RegistryHelper.registerBlock(blockPipe);
	}
	
	public static void registerCraftingRecipies() {
	
	}
}
