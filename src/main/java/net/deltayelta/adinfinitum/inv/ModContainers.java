package net.deltayelta.adinfinitum.inv;

import net.deltayelta.adinfinitum.AdInfinitum;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {
    public static DeferredRegister<ContainerType<?>> Containers = DeferredRegister.create(ForgeRegistries.CONTAINERS, AdInfinitum.MOD_ID);

    public static final RegistryObject<ContainerType<BloomeryContainer>> BLOOMERY_CONTAINER =
            Containers.register("bloomery_container", () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new BloomeryContainer(windowId, world, pos, inv, inv.player);
            })));

    public static void register(IEventBus eventBus) {
        Containers.register(eventBus);
    };
}
