package site.levimarvin.pxautomessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.minecraft.nms.NmsClass;
import site.levimarvin.pxautomessage.util.ServerUtil;

public final class PxAutoMessage extends JavaPlugin {
    private static PxAutoMessage plugin;
    public static PxAutoMessage getPlugin() {
        return plugin;
    }
    public static final String PREFIX = "§e[§6PxAutoMessage§e] ";
    public static String serverVersion;

    public PxAutoMessage() {}

    @Override
    public void onEnable() {
        plugin = this;
        sendMessage("§a Loading...");
        serverVersion = ServerUtil.getServerVersion();
        System.out.println(serverVersion);
        //NmsClass.getNms().getAllClass();
    }

    @Override
    public void onDisable() {
        sendMessage("§a Closing...");
        System.gc();
    }

    private void sendMessage(String text) {
        Bukkit.getConsoleSender().sendMessage(text);
    }
}
