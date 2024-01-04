package net.deltayelta.adinfinitum.tile;

import net.deltayelta.adinfinitum.AdInfinitum;
import net.deltayelta.adinfinitum.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TileEntities = DeferredRegister.create(
            ForgeRegistries.TILE_ENTITIES, AdInfinitum.MOD_ID);

    public static RegistryObject<TileEntityType<BloomeryTile>> BLOOMERY_TILE = TileEntities.register("bloomery_tile", () -> TileEntityType.Builder.create(
            BloomeryTile::new, ModBlocks.BLOOMERY.get()).build(null));


    public static void register(IEventBus eventBus) {
        TileEntities.register(eventBus);
    }
}
