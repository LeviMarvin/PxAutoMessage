package net.rmplugins.rmautomessage.util;

/**
 * @author Levi Marvin
 */
public class ReflectUtil {
    public static final String VERSION = ServerUtil.getServerVersion();

    public static Class<?> getNmsClass(String name) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + VERSION + "." + name);
    }

    public static Class<?> getObcClass(String name) throws ClassNotFoundException {
        return Class.forName("org.bukkit.craftbukkit." + VERSION + "." + name);
    }
}
