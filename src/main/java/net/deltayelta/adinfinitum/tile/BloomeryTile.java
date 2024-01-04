package net.deltayelta.adinfinitum.tile;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BloomeryTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemStackHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    int burnTime;
    int burnTimeTotal = 100;
    int cookTime;
    int cookTimeTotal = 200;
    public BloomeryTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public void tick() {
        if (burnTime > 0) {
            burnTime--;
        }
        if(cookTime > 0) {
            cookTime--;
        }
        if(burnTime == 0 && canSmelt()) {
            burnTime = burnTimeTotal;
            cookTime = cookTimeTotal;
            ItemStack input = itemStackHandler.getStackInSlot(0);
            input.shrink(1);
            if (input.isEmpty()) {
                itemStackHandler.setStackInSlot(0, ItemStack.EMPTY);
            }
            ItemStack output = itemStackHandler.getStackInSlot(2);
            if (output.isEmpty()) {
                itemStackHandler.setStackInSlot(2, new ItemStack(Items.IRON_BARS));
            } else if (output.getItem() == input.getItem()) {
                output.grow(1);
            }
        }
    }

    public BloomeryTile() {
        this(ModTileEntities.BLOOMERY_TILE.get());
    }

    private boolean canSmelt() {
        ItemStack input = itemStackHandler.getStackInSlot(0);
        if (input.isEmpty()) { // No input
            return false;
        }
        ItemStack fuel = itemStackHandler.getStackInSlot(1);
        if (fuel.isEmpty() || fuel.getItem() != Items.CHARCOAL) { // No fuel or wrong item in fuel, wrong item shouldn't happen
            return false;
        }
        ItemStack output = itemStackHandler.getStackInSlot(2);

        return output.getCount() < output.getMaxStackSize();// Output isn't full
    }
    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemStackHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemStackHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot) {
                    case 0: return stack.getItem() == Items.IRON_ORE;
                    case 1: return stack.getItem() == Items.CHARCOAL;
                }
                return super.isItemValid(slot, stack);
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }


}