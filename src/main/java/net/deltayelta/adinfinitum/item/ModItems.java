package net.deltayelta.adinfinitum.item;

import net.deltayelta.adinfinitum.AdInfinitum;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, AdInfinitum.MOD_ID);

    public static final RegistryObject<Item> COKE = Items.register("coke", () -> new FuelItem(new Item.Properties().group(ModItemGroup.BLOCK_GROUP), 2400));
    public static final RegistryObject<Item> BRICK_BLOOMERY = Items.register("brick_bloomery", () -> new Item(new Item.Properties().group(ModItemGroup.BLOCK_GROUP)));

    public static final RegistryObject<Item> NUGGET_GRAPHITE = Items.register("nugget_graphite", () -> new Item(new Item.Properties().group(ModItemGroup.BLOCK_GROUP)));

    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}

// DO THIS