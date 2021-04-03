package site.levimarvin.pxautomessage.util;

import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;

public class ReflectUtil {
    public static final JavaPlugin plugin = PxAutoMessage.getPlugin();
    public static final String version = ServerUtil.getServerVersion();

    public static Class<?> getNmsClass(String name) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + version + "." + name);
    }

    public static Class<?> getObcClass(String name) throws ClassNotFoundException {
        return Class.forName("org.bukkit.craftbukkit." + version + "." + name);
    }
}
