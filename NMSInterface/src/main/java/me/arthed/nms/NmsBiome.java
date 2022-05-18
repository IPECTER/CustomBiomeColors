package me.arthed.nms;

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

public interface NmsBiome {
    Object getBiomeBase();

    BiomeColors getBiomeColors();

    NmsBiome cloneWithDifferentColors(NmsServer nmsServer, BiomeKey newBiomeKey, BiomeColors newColors);
}