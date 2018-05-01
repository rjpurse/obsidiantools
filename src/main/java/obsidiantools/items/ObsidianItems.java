package obsidiantools.items;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import obsidiantools.materials.ObsidianMaterials;

@ObjectHolder("obsidiantools")
public class ObsidianItems {

	 @ObjectHolder("ingot_obsidian")
	 public static final ItemIngot INGOT_OBSIDIAN = new ItemIngot("ingot_obsidian");
	 
	 @ObjectHolder("axe_obsidian")
	 public static final ToolAxe AXE_OBSIDIAN = new ToolAxe("axe_obsidian", ObsidianMaterials.TOOL_OBSIDIAN);
	 
	 @ObjectHolder("hoe_obsidian")
	 public static final ToolHoe HOE_OBSIDIAN = new ToolHoe("hoe_obsidian", ObsidianMaterials.TOOL_OBSIDIAN);
	 
	 @ObjectHolder("pickaxe_obsidian")
	 public static final ToolPickaxe PICKAXE_OBSIDIAN = new ToolPickaxe("pickaxe_obsidian", ObsidianMaterials.TOOL_OBSIDIAN);;
	 
	 @ObjectHolder("shovel_obsidian")
	 public static final ToolShovel SHOVEL_OBSIDIAN = new ToolShovel("shovel_obsidian", ObsidianMaterials.TOOL_OBSIDIAN);;
	 
	 @ObjectHolder("sword_obsidian")
	 public static final WeaponSword SWORD_OBSIDIAN = new WeaponSword("sword_obsidian", ObsidianMaterials.TOOL_OBSIDIAN);
	 

	
}
