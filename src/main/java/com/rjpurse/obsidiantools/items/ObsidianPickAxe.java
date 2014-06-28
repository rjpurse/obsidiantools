package com.rjpurse.obsidiantools.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

import com.rjpurse.obsidiantools.ObsidianTools;

public class ObsidianPickAxe extends ItemPickaxe {

	public ObsidianPickAxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		
		this.setUnlocalizedName("obsidian_pickaxe");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName(ObsidianTools.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
