package me.arthed.custombiomecolors.nms;

import me.arthed.nms.NmsBiome;
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
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class Biome implements NmsBiome {



    @Override
    public Object getBiomeBase() {
        return null;
    }

    @Override
    public BiomeColors getBiomeColors() {
        return null;
    }

    @Override
    public NmsBiome cloneWithDifferentColors(NmsServer nmsServer, BiomeKey newBiomeKey, BiomeColors newColors) {
        return null;
    }
}