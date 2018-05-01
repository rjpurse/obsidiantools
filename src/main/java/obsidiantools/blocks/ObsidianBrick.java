package obsidiantools.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import obsidiantools.ObsidianTools;

public class ObsidianBrick extends Block {
	public static final String BLOCK_NAME = "obsidian_brick"; 
	
	
	public ObsidianBrick() {
        super(Material.ROCK);
        setRegistryName(BLOCK_NAME);
        setUnlocalizedName(ObsidianTools.MODID + "." + BLOCK_NAME);
        
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
