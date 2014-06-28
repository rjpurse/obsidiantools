package com.rjpurse.obsidiantools.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

import com.rjpurse.obsidiantools.ObsidianTools;

public class ObsidianHoe extends ItemHoe {

	public ObsidianHoe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		
		this.setUnlocalizedName("obsidian_hoe");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName(ObsidianTools.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
