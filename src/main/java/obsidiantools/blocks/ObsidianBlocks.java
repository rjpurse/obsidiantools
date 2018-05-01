package obsidiantools.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder("obsidiantools")
public class ObsidianBlocks {
	
	@ObjectHolder("obsidian_brick")
    public static final ObsidianBrick OBSIDIAN_BRICK = new ObsidianBrick();
}
