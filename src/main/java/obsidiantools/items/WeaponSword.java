package obsidiantools.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import obsidiantools.ObsidianTools;

public class WeaponSword extends ItemSword {

	public WeaponSword(String name, ToolMaterial material) {
		super(material);
		
		setRegistryName(name);     
        setUnlocalizedName(ObsidianTools.MODID + "." + name);
        setCreativeTab(CreativeTabs.COMBAT);
	}
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
