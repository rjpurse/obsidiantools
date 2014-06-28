package com.rjpurse.obsidiantools.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

import com.rjpurse.obsidiantools.ObsidianTools;

public class ObsidianShovel extends ItemSpade {

	public ObsidianShovel(ToolMaterial toolMaterial) {
		super(toolMaterial);
		
		this.setUnlocalizedName("obsidian_shovel");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName(ObsidianTools.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
