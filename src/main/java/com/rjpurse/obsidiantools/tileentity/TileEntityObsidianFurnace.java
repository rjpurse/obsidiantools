package com.rjpurse.obsidiantools.tileentity;

import com.rjpurse.obsidiantools.blocks.ObsidianFurnace;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityObsidianFurnace extends TileEntity implements ISidedInventory {
	
	private String localizedName;
	
	private static final int[] slotsTop = new int[]{0};
	
	private static final int[] slotsBottom = new int[]{2, 1};
	
	private static final int[] slotsSide = new int[]{1};
	
	private ItemStack[] slots = new ItemStack[3];
	
	public int furnaceSpeed = 50;
	
	/** The number of ticks that the furnace will keep burning */
	public int burnTime;
	
	/**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
	public int currentItemBurnTime;
	
	/** The number of ticks that the current item has been cooking for */
	public int cookTime; 
	
	public void setGuiDisplayName(String displayName)
	{
		this.localizedName = displayName;
	}

	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.localizedName : "container.obsidianFurnace";
		
	}
	
	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.slots[i] != null)
        {
            ItemStack itemstack;

            if (this.slots[i].stackSize <= j)
            {
                itemstack = this.slots[i];
                this.slots[i] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.slots[i].splitStack(j);

                if (this.slots[i].stackSize == 0)
                {
                    this.slots[i] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null)
        {
            ItemStack itemstack = this.slots[i];
            this.slots[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		this.slots[i] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
		
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? 
				false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return slot == 2 ? false : (slot == 1 ? isItemFuel(itemStack) : true);
	}
	
	public static boolean isItemFuel(ItemStack itemStack)
	{
		return getItemBurnTime(itemStack) > 0; 
	}

	private static int getItemBurnTime(ItemStack itemStack) {
		if(itemStack != null) {
			Item item = itemStack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
				Block block = Block.getBlockFromItem(item);
			}
				if(item==Items.lava_bucket) return 30000;
				
				//Use other mod fuel types
				//return GameRegistry.getFuelValue(itemStack);
			
		}
		
		return 0;
	}

	public void updateEntity() {
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;
		
		if(this.isBurning()) this.burnTime--;
		
		if(!this.worldObj.isRemote){
			if(this.burnTime == 0 && this.canSmelt()){
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				
				if (this.isBurning()) {
					flag1 = true;
					
					if(this.slots[1] != null) {
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize == 0){
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}
			if(this.isBurning() && this.canSmelt()) {
				this.cookTime++;
				
				if(this.cookTime == this.furnaceSpeed){
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			} else {
				this.cookTime = 0;
			}
			
			if(flag != this.isBurning()){
				flag1 = true;
				ObsidianFurnace.updateObsidianFurnaceBlockState(this.isBurning(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		
			}
			if(flag1){
				this.markDirty();
			}
		}
		
	}
	
	private void smeltItem() {
		if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);

            if (this.slots[2] == null)
            {
                this.slots[2] = itemstack.copy();
            }
            else if (this.slots[2].getItem() == itemstack.getItem())
            {
                this.slots[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.slots[0].stackSize;

            if (this.slots[0].stackSize <= 0)
            {
                this.slots[0] = null;
            }
        }
	}

	private boolean canSmelt() {
		if (this.slots[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
            
            if (itemstack == null) return false;
            
            if (this.slots[2] == null) return true;
            
            if (!this.slots[2].isItemEqual(itemstack)) return false;
            
            int result = slots[2].stackSize + itemstack.stackSize;
            
            	return result <= getInventoryStackLimit() && result <= this.slots[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
	}

	public boolean isBurning() {
		return this.burnTime  > 0;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return i == 0 ? slotsBottom : (i == 1 ? slotsTop : slotsSide);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		
		return this.isItemValidForSlot(i, itemStack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return j!= 0 || i != 1 || itemStack.getItem() == Items.bucket;
	}

	public int getBurnTimeRemainingScaled(int i) {
		if(this.currentItemBurnTime == 0)
			this.currentItemBurnTime = this.furnaceSpeed;
		
		return this.burnTime * i / this.currentItemBurnTime;
	}
	
	public int getCookProgressScaled(int i){
		return this.cookTime * i / this.furnaceSpeed;
	}
	
	public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            byte b = nbttagcompound.getByte("Slot");

            if (b >= 0 && b < this.slots.length)
            {
                this.slots[b] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        this.burnTime = nbt.getShort("BurnTime");
        this.cookTime = nbt.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.slots[1]);

        if (nbt.hasKey("CustomName", 8))
        {
            this.localizedName = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short)this.burnTime);
        nbt.setShort("CookTime", (short)this.cookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.slots.length; ++i)
        {
            if (this.slots[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.slots[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        nbt.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            nbt.setString("CustomName", this.localizedName);
        }
    }
}
