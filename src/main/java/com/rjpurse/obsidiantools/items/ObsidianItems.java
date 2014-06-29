package com.rjpurse.obsidiantools.items;

import com.rjpurse.obsidiantools.helpers.RegistryHelper;
import com.rjpurse.obsidiantools.material.ObsidianMaterial;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ObsidianItems {
	public static Item obsidianSword;
	public static Item obsidianShovel;
	public static Item obsidianAxe;
	public static Item obsidianPickaxe;
	public static Item obsidianHoe;
	
	
	
	public static void initializeObsidianItems() {
		// Tools and weapons
        obsidianSword = new ObsidianSword(ObsidianMaterial.obsidianToolMaterial);
        obsidianAxe = new ObsidianAxe(ObsidianMaterial.obsidianToolMaterial);
        obsidianPickaxe = new ObsidianPickAxe(ObsidianMaterial.obsidianToolMaterial);
        obsidianShovel = new ObsidianShovel(ObsidianMaterial.obsidianToolMaterial);
        obsidianHoe = new ObsidianHoe(ObsidianMaterial.obsidianToolMaterial);
	}
	
	public static void registerObsidianItems() {
		RegistryHelper.registerItem(ObsidianItems.obsidianSword);
		RegistryHelper.registerItem(ObsidianItems.obsidianAxe);
		RegistryHelper.registerItem(ObsidianItems.obsidianPickaxe);
		RegistryHelper.registerItem(ObsidianItems.obsidianShovel);
		RegistryHelper.registerItem(ObsidianItems.obsidianHoe);
	}
	
	public static void registerCraftingRecipies() {
		ItemStack obsidianStack = new ItemStack(Blocks.obsidian);
		ItemStack stickStack = new ItemStack(Items.stick);
		
		GameRegistry.addRecipe(new ItemStack(obsidianSword), " o ", " o ", " s ",
				'o', obsidianStack, 's', stickStack);
		GameRegistry.addRecipe(new ItemStack(obsidianAxe), "oo ", "os ", " s ", 
				'o', obsidianStack, 's', stickStack);
		GameRegistry.addRecipe(new ItemStack(obsidianPickaxe), "ooo", " s ", " s ", 
				'o', obsidianStack, 's', stickStack);
		GameRegistry.addRecipe(new ItemStack(obsidianShovel), " o ", " s ", " s ", 
				'o', obsidianStack, 's', stickStack);
		GameRegistry.addRecipe(new ItemStack(obsidianHoe), "oo ", " s ", " s ", 
				'o', obsidianStack, 's', stickStack);
	}
}
