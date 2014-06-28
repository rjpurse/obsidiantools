package com.rjpurse.obsidiantools.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

import com.rjpurse.obsidiantools.ObsidianTools;

public class ObsidianAxe extends ItemAxe {

	public ObsidianAxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		
		this.setUnlocalizedName("obsidian_axe");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName(ObsidianTools.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
