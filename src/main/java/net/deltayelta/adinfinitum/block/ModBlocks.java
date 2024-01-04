package net.deltayelta.adinfinitum.block;

import net.deltayelta.adinfinitum.AdInfinitum;
import net.deltayelta.adinfinitum.block.custom.BloomeryBlock;
import net.deltayelta.adinfinitum.item.ModItemGroup;
import net.deltayelta.adinfinitum.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, AdInfinitum.MOD_ID);

    public static final RegistryObject<Block> ANTHRACITE_ORE = registerBlock("anthracite_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(4f)));

    public static final RegistryObject<Block> BLOOMERY = registerBlock("bloomery",
            () -> new BloomeryBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(4f)));
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Blocks.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static<T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.BLOCK_GROUP)));
    }
    public static void register(IEventBus eventBus) {
        Blocks.register(eventBus);
    }
}
