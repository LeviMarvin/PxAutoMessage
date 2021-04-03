package site.levimarvin.pxautomessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.minecraft.Command;
import site.levimarvin.pxautomessage.minecraft.nms.NmsClass;
import site.levimarvin.pxautomessage.service.SenderManagerSrv;
import site.levimarvin.pxautomessage.util.ServerUtil;

import java.util.ArrayList;
import java.util.List;

public final class PxAutoMessage extends JavaPlugin {
    private static PxAutoMessage plugin;
    public static PxAutoMessage getPlugin() {
        return plugin;
    }

    public static final String PREFIX = "§e[§6PxAutoMessage§e] ";
    public static List<Player> playerList = new ArrayList<>();
    public static String serverVersion;

    public PxAutoMessage() {}

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
        Command.registerCmd();
        //Init thread manager.
        Thread senderManager = new Thread(new SenderManagerSrv(), "Sender Manager Thread");
        senderManager.setDaemon(true);
        senderManager.start();
    }

    private void sendMessage(String text) {
        Bukkit.getConsoleSender().sendMessage(text);
    }
}
