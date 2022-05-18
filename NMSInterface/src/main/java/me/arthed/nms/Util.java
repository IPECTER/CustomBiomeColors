package me.arthed.nms;

import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Util {
    public static Class<?> getClass(String name, boolean b) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            if (b) {
                throw new RuntimeException(e);
            } else {
                return null;
            }
        }
    }

    public static Class<?> bukkitClass(String name) {
        try {
            return Class.forName(Bukkit.getServer().getClass().getPackage().getName() + "." + name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Method getMethod(Class<?> clazz, String name, Class<?>... parameters) {
        try {
            return clazz.getMethod(name, parameters);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static Method findMethod(Class<?> clazz, Class<?>... parameters) {
        for (Method m : clazz.getMethods()) {
            if (Arrays.equals(parameters, m.getParameterTypes())) {
                return m;
            }
        }

        throw new RuntimeException(new NoSuchMethodException("Method with parameters " + Arrays.stream(parameters).collect(Collectors.toList()) + " not found in class '" + clazz + "'"));
    }
    private static Field getField(Class<?> clazz, String name) {
        try {
            return clazz.getField(name);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    public static Field findField(Class<?> clazz, Class<?> type) {
        for (Field f : clazz.getFields()) {
            if (f.getType().equals(type)) {
                return f;
            }
        }

        throw new RuntimeException(new NoSuchFieldException("Field with type '" + type + "' not found in class '" + clazz + "'"));
    }
}
