package net.deltayelta.adinfinitum.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;

import javax.annotation.Nullable;

public class FuelItem extends Item {
    private final int burnTicks;

    public FuelItem(Properties properties, int burnTime) {
        super(properties);
        this.burnTicks = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable IRecipeType<?> recipeType) {
        return this.burnTicks;
    }
}
// this file seems so redundant and I have no idea why