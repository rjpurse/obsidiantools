package obsidiantools.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import obsidiantools.ObsidianTools;

public class ItemIngot extends Item {
	
	public ItemIngot(String name) {
		
        setRegistryName(name);     
        setUnlocalizedName(ObsidianTools.MODID + "." + name);
        setCreativeTab(CreativeTabs.MATERIALS);
    }
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
