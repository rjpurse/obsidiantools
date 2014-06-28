package com.rjpurse.obsidiantools.material;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ObsidianMaterial {
	public static ArmorMaterial obsidianArmorMaterial = EnumHelper.addArmorMaterial("OBSIDIAN", 33, new int[]{3, 8, 6, 3}, 15);
	public static ToolMaterial obsidianToolMaterial = EnumHelper.addToolMaterial("OBSIDIAN", 3, 1500, 14.0F, 8, 15); 
}
