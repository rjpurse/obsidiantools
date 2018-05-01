package obsidiantools.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import obsidiantools.items.ObsidianItems;

@EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    
	@Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	ObsidianItems.INGOT_OBSIDIAN.initModel();
    	ObsidianItems.AXE_OBSIDIAN.initModel();
    	ObsidianItems.HOE_OBSIDIAN.initModel();
    	ObsidianItems.PICKAXE_OBSIDIAN.initModel();
    	ObsidianItems.SHOVEL_OBSIDIAN.initModel();
    	ObsidianItems.SWORD_OBSIDIAN.initModel();
    }
    
}