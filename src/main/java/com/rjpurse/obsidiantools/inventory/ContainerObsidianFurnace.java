package com.rjpurse.obsidiantools.inventory;

import com.rjpurse.obsidiantools.tileentity.TileEntityObsidianFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerObsidianFurnace extends Container {
	
	private TileEntityObsidianFurnace tileObsidianFurnace;
	private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
	
	
	public ContainerObsidianFurnace(InventoryPlayer playerInventory, TileEntityObsidianFurnace entity) {
		this.tileObsidianFurnace = entity;
		
		this.addSlotToContainer(new Slot(entity, 0, 56, 17));
        this.addSlotToContainer(new Slot(entity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(playerInventory.player, entity, 2, 116, 35));
        int i;
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
	}

	public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.tileObsidianFurnace.cookTime);
        crafting.sendProgressBarUpdate(this, 1, this.tileObsidianFurnace.burnTime);
        crafting.sendProgressBarUpdate(this, 2, this.tileObsidianFurnace.currentItemBurnTime);
    }
	
	public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.tileObsidianFurnace.cookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileObsidianFurnace.cookTime);
            }

            if (this.lastBurnTime != this.tileObsidianFurnace.burnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tileObsidianFurnace.burnTime);
            }

            if (this.lastItemBurnTime != this.tileObsidianFurnace.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tileObsidianFurnace.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.tileObsidianFurnace.cookTime;
        this.lastBurnTime = this.tileObsidianFurnace.burnTime;
        this.lastItemBurnTime = this.tileObsidianFurnace.currentItemBurnTime;
    }

	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tileObsidianFurnace.cookTime = par2;
        }

        if (par1 == 1)
        {
            this.tileObsidianFurnace.burnTime = par2;
        }

        if (par1 == 2)
        {
            this.tileObsidianFurnace.currentItemBurnTime = par2;
        }
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileObsidianFurnace.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int inventorySlot)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(inventorySlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (inventorySlot == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (inventorySlot != 1 && inventorySlot != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityObsidianFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (inventorySlot >= 3 && inventorySlot < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (inventorySlot >= 30 && inventorySlot < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(entityPlayer, itemstack1);
        }

        return itemstack;
    }

}
