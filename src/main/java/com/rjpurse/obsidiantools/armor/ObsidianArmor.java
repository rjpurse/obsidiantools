package com.rjpurse.obsidiantools.armor;

import com.rjpurse.obsidiantools.ObsidianTools;
import com.rjpurse.obsidiantools.helpers.RegistryHelper;
import com.rjpurse.obsidiantools.material.ObsidianMaterial;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ObsidianArmor extends ItemArmor {

	public static ObsidianArmor obsidianHelmet;
	public static ObsidianArmor obsidianChestplate;
	public static ObsidianArmor obsidianLeggings;
	public static ObsidianArmor obsidianBoots;
	

	public ObsidianArmor(ArmorMaterial armorMaterial, int armorType,
			String unlocalizedName) {
		super(armorMaterial, 0, armorType);
	
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(ObsidianTools.MODID + ":"
				+ getUnlocalizedName().substring(5));
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot,
			String type) {
		if (itemstack.getItem() == obsidianHelmet
				|| itemstack.getItem() == obsidianChestplate
				|| itemstack.getItem() == obsidianBoots) {
			return ObsidianTools.MODID + ":models/armor/obsidian_armor_1.png";
		} else if (itemstack.getItem() == obsidianLeggings) {
			return ObsidianTools.MODID + ":models/armor/obsidian_armor_2.png";
		}

		return ObsidianTools.MODID + ":models/armor/obsidian_armor_1.png";
	}

	public static void initializeObsidianArmor() {
        // Armor
        obsidianHelmet = new ObsidianArmor(ObsidianMaterial.obsidianArmorMaterial, 0, "obsidian_helmet");
        obsidianChestplate = new ObsidianArmor(ObsidianMaterial.obsidianArmorMaterial, 1, "obsidian_chestplate");
        obsidianLeggings = new ObsidianArmor(ObsidianMaterial.obsidianArmorMaterial, 2, "obsidian_leggings");
        obsidianBoots = new ObsidianArmor(ObsidianMaterial.obsidianArmorMaterial, 3, "obsidian_boots");
	}
	
	public static void registerObsidianArmorItems() {
		RegistryHelper.registerItem(ObsidianArmor.obsidianHelmet);
		RegistryHelper.registerItem(ObsidianArmor.obsidianChestplate);
		RegistryHelper.registerItem(ObsidianArmor.obsidianLeggings);
		RegistryHelper.registerItem(ObsidianArmor.obsidianBoots);
	}
	
	public static void registerObsidianArmorRecipies() {

		ItemStack obsidianStack = new ItemStack(Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(ObsidianArmor.obsidianHelmet), "ooo", "o o", "   ", 
				'o', obsidianStack);
		GameRegistry.addRecipe(new ItemStack(ObsidianArmor.obsidianChestplate), "o o", "ooo", "ooo", 
				'o', obsidianStack);
		GameRegistry.addRecipe(new ItemStack(ObsidianArmor.obsidianLeggings), "ooo", "o o", "o o", 
				'o', obsidianStack);
		GameRegistry.addRecipe(new ItemStack(ObsidianArmor.obsidianBoots), "   ", "o o", "o o", 
				'o', obsidianStack);
		
	}
}
