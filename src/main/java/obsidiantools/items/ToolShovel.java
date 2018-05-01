package obsidiantools.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import obsidiantools.ObsidianTools;

public class ToolShovel extends ItemSpade {

	public ToolShovel(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		
		setRegistryName(name);     
        setUnlocalizedName(ObsidianTools.MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
	}
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
