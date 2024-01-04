package net.deltayelta.adinfinitum.world.gen;

import net.deltayelta.adinfinitum.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    ANTHRACITE(Lazy.of(ModBlocks.ANTHRACITE_ORE), 16, 4, 8, 48);

    private final Lazy<Block> block;
    private final int perChunk;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Lazy<Block> block, int perChunk, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.perChunk = perChunk;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getPerChunk() {
        return perChunk;
    }
    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static net.deltayelta.adinfinitum.world.gen.OreType get(Block block) {
        for (net.deltayelta.adinfinitum.world.gen.OreType ore : values()) {
            if(block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}
