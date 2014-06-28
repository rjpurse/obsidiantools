package com.rjpurse.obsidiantools.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


import com.rjpurse.obsidiantools.ObsidianTools;
import com.rjpurse.obsidiantools.inventory.ContainerObsidianFurnace;
import com.rjpurse.obsidiantools.tileentity.TileEntityObsidianFurnace;

public class GuiObsidianFurnace extends GuiContainer {

	public static final ResourceLocation bground = new ResourceLocation(ObsidianTools.MODID + ":" + "textures/gui/obsidian_furnace.png");
	
	public TileEntityObsidianFurnace tileEntityObsidianFurnace;
	
	public GuiObsidianFurnace(InventoryPlayer playerInventory, TileEntityObsidianFurnace entity ) {
		super(new ContainerObsidianFurnace(playerInventory, entity));
	 
		this.tileEntityObsidianFurnace = entity;
		
		this.xSize = 175;
		this.ySize = 165;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.tileEntityObsidianFurnace.hasCustomInventoryName() ? this.tileEntityObsidianFurnace.getInventoryName() :
			I18n.format(this.tileEntityObsidianFurnace.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize /2 - this.fontRendererObj.getStringWidth(name) / 2 , 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2 , 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
		int i1;

        if (this.tileEntityObsidianFurnace.isBurning())
        {
            i1 = this.tileEntityObsidianFurnace.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.tileEntityObsidianFurnace.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}

}
