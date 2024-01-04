package net.deltayelta.adinfinitum.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup BLOCK_GROUP = new ItemGroup("blockGroupTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COKE.get());
        }
    };

}
