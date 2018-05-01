package obsidiantools;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import obsidiantools.proxy.CommonProxy;

@Mod(modid = ObsidianTools.MODID, version = ObsidianTools.VERSION)
public class ObsidianTools
{
    public static final String MODID = "obsidiantools";
    public static final String VERSION = "1.0";
    
    @SidedProxy(clientSide="obsidiantools.proxy.ClientProxy", 
    	      serverSide="obsidiantools.proxy.ServerProxy")
    public static CommonProxy proxy;
   
    public static Logger logger;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
