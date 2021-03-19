package site.levimarvin.pxautomessage.util;

import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;

public class NmsUtil {
    public static final JavaPlugin plugin = PxAutoMessage.getPlugin();

    public static Class<?> getNmsClass(String name) throws ClassNotFoundException {
        String version = plugin.getServer().getClass().getPackage().getName().split("\\.")[3];
        return Class.forName("net.minecraft.server." + version + "." + name);
    }

    public static Class<?> getObcClass(String name) throws ClassNotFoundException {
        String version = plugin.getServer().getClass().getPackage().getName().split("\\.")[3];
        return Class.forName("org.bukkit.craftbukkit." + version + "." + name);
    }
}
