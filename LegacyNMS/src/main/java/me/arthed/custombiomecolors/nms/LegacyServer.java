package me.arthed.custombiomecolors.nms;

import me.arthed.nms.NmsBiome;
import me.arthed.nms.NmsPackets;
import me.arthed.nms.NmsServer;
import me.arthed.nms.Util;
import me.arthed.nms.objects.BiomeColors;
import me.arthed.nms.objects.BiomeKey;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;

public class LegacyServer implements NmsServer {

    private static final String NMS_VERSION;

    static {
        if (Util.getClass("org.bukkit.craftbukkit.CraftServer", false) == null) {
            String CRAFTBUKKIT_VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

            if (Util.getClass("net.minecraft.server.MinecraftServer", false) == null) {
                NMS_VERSION = CRAFTBUKKIT_VERSION;
            } else {
                NMS_VERSION = "";
            }
        } else {
            NMS_VERSION = "";
        }

        if (NMS_VERSION.equals(""))
            throw new UnsupportedOperationException("LegacyIndependentNmsPackets must only be used on versions lower than 1.17");
    }

    @Override
    public NmsBiome getBiomeFromBiomeKey(BiomeKey biomeKey) {
        return null;
    }

    @Override
    public NmsBiome getBiomeFromBiomeBase(Object biomeBase) {
        return null;
    }

    @Override
    public boolean doesBiomeExist(BiomeKey biomeKey) {
        return false;
    }

    @Override
    public void loadBiome(BiomeKey biomeKey, BiomeColors biomeColors) {

    }

    @Override
    public void setBlocksBiome(Block block, NmsBiome nmsBiome) {

    }

    @Override
    public Object getBlocksBiomeBase(Block block) {
        return null;
    }

    @Override
    public void registerBiome(Object biomeBase, Object biomeMinecraftKey) {

    }
}