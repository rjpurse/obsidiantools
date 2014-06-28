package com.rjpurse.obsidiantools.tileentity;

import org.lwjgl.opengl.GL11;

import com.rjpurse.obsidiantools.ObsidianTools;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityRenderPipe extends TileEntitySpecialRenderer {

	ResourceLocation texture = new ResourceLocation(ObsidianTools.MODID, "textures/models/pipe.png");
	
	boolean drawInside = true;
	
	float pixel = 1F / 16F;
	float texturePixel = 1F / 32F;
	
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double translationX, double translationY,
			double translationZ, float f) {
		GL11.glTranslated(translationX, translationY, translationZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(texture);
		drawCore(tileEntity);
		
		TileEntityPipe pipe = (TileEntityPipe) tileEntity;
		for(int i = 0; i < pipe.connections.length; i++)
		{
			if(pipe.connections[i] != null)
				drawConnector(pipe.connections[i]);
			
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-translationX, -translationY, -translationZ);
	}
	
	public void drawConnector(ForgeDirection d){
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if(d == ForgeDirection.UP) {
			// Rotate
		}
		else if(d == ForgeDirection.DOWN) {
			GL11.glRotatef(180, 1, 0, 0);
		}
		else if(d == ForgeDirection.SOUTH) {
			GL11.glRotatef(90, 1, 0, 0);
		}
		else if(d == ForgeDirection.NORTH) {
			GL11.glRotatef(270, 1, 0, 0);
		}
		else if(d == ForgeDirection.WEST) {
			GL11.glRotatef(90, 0, 0, 1);
		}
		else if(d == ForgeDirection.EAST) {
			GL11.glRotatef(270, 0, 0, 1);
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			
		tessellator.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
		tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
		tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		
		tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
		tessellator.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
		tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
		tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
		
		tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
		tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
		tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
		
		tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
		tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			
		
		tessellator.draw();
		
		GL11.glPopMatrix();
		
//		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
//		if(d == ForgeDirection.UP) {
//			// Rotate
//		}
//		else if(d == ForgeDirection.DOWN) {
//			GL11.glRotatef(-180, 1, 0, 0);
//		}
//		else if(d == ForgeDirection.SOUTH) {
//			GL11.glRotatef(-90, 1, 0, 0);
//		}
//		else if(d == ForgeDirection.NORTH) {
//			GL11.glRotatef(-270, 1, 0, 0);
//		}
//		else if(d == ForgeDirection.WEST) {
//			GL11.glRotatef(-90, 0, 0, 1);
//		}
//		else if(d == ForgeDirection.EAST) {
//			GL11.glRotatef(-270, 0, 0, 1);
//		}
//		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		
	}
	
	public void drawCore(TileEntity tileEntity){
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
//			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
//			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
//			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
//			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
//			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
//			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
//			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
//			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
		}
		tessellator.draw();
	}

}
