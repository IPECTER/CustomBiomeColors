package me.arthed.custombiomecolors.nms;

import me.arthed.nms.NmsBiome;
import me.arthed.nms.NmsPackets;
import me.arthed.nms.NmsServer;
import me.arthed.nms.Util;
import me.arthed.nms.objects.BiomeColors;
import me.arthed.nms.objects.BiomeKey;
import net.minecraft.server.v1_16_R3.BiomeBase;
import net.minecraft.server.v1_16_R3.BiomeFog;
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

public class LegacyBiome implements NmsBiome {

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

    private final BiomeBase biomeBase;

    public LegacyBiome(BiomeBase biomeBase) {
        this.biomeBase = biomeBase;
    }

    @Override
    public Object getBiomeBase() {
        return this.biomeBase;
    }

    @Override
    public BiomeColors getBiomeColors() {
        try {
            BiomeFog biomeFog = (BiomeFog) ReflectionUtils.getPrivateObject(this.biomeBase, "p");
            assert biomeFog != null;
            return new BiomeColors()
                    .setGrassColor(ReflectionUtils.getPrivateOptionalInteger(biomeFog, "g"))
                    .setFoliageColor(ReflectionUtils.getPrivateOptionalInteger(biomeFog, "f"))
                    .setWaterColor(ReflectionUtils.getPrivateInteger(biomeFog, "c"))
                    .setWaterFogColor(ReflectionUtils.getPrivateInteger(biomeFog, "d"))
                    .setSkyColor(ReflectionUtils.getPrivateInteger(biomeFog, "e"))
                    .setFogColor(ReflectionUtils.getPrivateInteger(biomeFog, "b"));
        } catch(NoSuchFieldException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public NmsBiome cloneWithDifferentColors(NmsServer nmsServer, BiomeKey newBiomeKey, BiomeColors newColors) {
        return null;
    }
}