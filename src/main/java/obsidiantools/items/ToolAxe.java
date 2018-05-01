package obsidiantools.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import obsidiantools.ObsidianTools;

public class ToolAxe extends ItemAxe {

	public ToolAxe(String name, ToolMaterial toolMaterial) {
		super(toolMaterial, 8.0F, -1.0F);
		
		setRegistryName(name);     
        setUnlocalizedName(ObsidianTools.MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
	}
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
    	ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
