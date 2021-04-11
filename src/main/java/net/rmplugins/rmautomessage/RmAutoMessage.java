package net.rmplugins.rmautomessage;

import net.rmplugins.rmautomessage.mc.Register;
import net.rmplugins.rmautomessage.mc.nms.NmsClass;
import net.rmplugins.rmautomessage.util.ServerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Levi Marvin
 */
public final class RmAutoMessage extends JavaPlugin {
    private static RmAutoMessage plugin;
    public static RmAutoMessage getPlugin() {
        return plugin;
    }

    public static final String PREFIX = "§e[§6PxAutoMessage§e] ";
    public static List<Player> playerList = new ArrayList<>();
    public static String serverVersion;

    public RmAutoMessage() {}

    @Override
    public void onEnable() {
        plugin = this;
        sendMessage("§a Loading...");
        init();
        //Init player list.
        //Bukkit.getScheduler().runTask(this, new TitleSender());
    }

    @Override
    public void onDisable() {
        sendMessage("§a Closing...");
        System.gc();
    }

    private void init() {
        //Init data.
        serverVersion = ServerUtil.getServerVersion();
        //Init NMS and OBC.
        NmsClass.getNms().init();
        //Register.
        Register.registerCmd();
        Register.registerListener();
    }

    private void sendMessage(String text) {
        Bukkit.getConsoleSender().sendMessage(text);
    }
}
