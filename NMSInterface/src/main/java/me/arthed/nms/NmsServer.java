package me.arthed.nms;

import me.arthed.nms.objects.BiomeColors;
import me.arthed.nms.objects.BiomeKey;
import org.bukkit.block.Block;

public interface NmsServer {
    NmsBiome getBiomeFromBiomeKey(BiomeKey biomeKey);

    NmsBiome getBiomeFromBiomeBase(Object biomeBase);

    boolean doesBiomeExist(BiomeKey biomeKey);

    void loadBiome(BiomeKey biomeKey, BiomeColors biomeColors);

    void setBlocksBiome(Block block, NmsBiome nmsBiome);

    Object getBlocksBiomeBase(Block block);

    void registerBiome(Object biomeBase, Object biomeMinecraftKey);
}