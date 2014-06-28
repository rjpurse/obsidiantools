package com.rjpurse.obsidiantools.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import com.rjpurse.obsidiantools.ObsidianTools;

public class ObsidianSword extends ItemSword {

	public ObsidianSword(ToolMaterial material) {
		super(material);
		
		this.setUnlocalizedName("obsidian_sword");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName(ObsidianTools.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
