package obsidiantools.materials;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ObsidianMaterials {
	public static final ArmorMaterial ARMOR_OBSIDIAN = EnumHelper.addArmorMaterial("OBSIDIAN", null, 33, new int[]{3, 8, 6, 3}, 15, null, 0);
	public static final ToolMaterial TOOL_OBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 3, 1500, 14.0F, 8, 15); 
}
