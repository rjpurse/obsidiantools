package obsidiantools.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import obsidiantools.blocks.ObsidianBlocks;
import obsidiantools.items.ObsidianItems;

@EventBusSubscriber
	public class CommonProxy {
	
	    public void preInit(FMLPreInitializationEvent event) {
	    }

	    public void init(FMLInitializationEvent event) {
	    }

	    public void postInit(FMLPostInitializationEvent event) {
	    }

	    @SubscribeEvent
	    public static void registerBlocks(RegistryEvent.Register<Block> event) {
	    	event.getRegistry().register(ObsidianBlocks.OBSIDIAN_BRICK);
	    	
	    }

	    @SubscribeEvent
	    public static void registerItems(RegistryEvent.Register<Item> event) {
	    	
	    	event.getRegistry().register(new ItemBlock(ObsidianBlocks.OBSIDIAN_BRICK).setRegistryName(ObsidianBlocks.OBSIDIAN_BRICK.getRegistryName()));
	    	
	    	event.getRegistry().register(ObsidianItems.INGOT_OBSIDIAN);
	    	event.getRegistry().register(ObsidianItems.AXE_OBSIDIAN);
	    	event.getRegistry().register(ObsidianItems.HOE_OBSIDIAN);
	    	event.getRegistry().register(ObsidianItems.PICKAXE_OBSIDIAN);
	    	event.getRegistry().register(ObsidianItems.SHOVEL_OBSIDIAN);
	    	event.getRegistry().register(ObsidianItems.SWORD_OBSIDIAN);
	    }
  
	}

