package site.levimarvin.pxautomessage.mc;

import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.mc.command.*;

import java.util.HashMap;

public class Command {
    private static final JavaPlugin plugin = PxAutoMessage.getPlugin();
    private static HashMap<String, Class<?>> cmdMap = new HashMap<>();

    public static void registerCmd() {
        cmdMap.put("debug", Debug.class);
        cmdMap.put("reload", Reload.class);
        cmdMap.forEach((k, v) -> {
            org.bukkit.command.CommandExecutor commandExecutor = null;
            try {
                commandExecutor = (org.bukkit.command.CommandExecutor) v.newInstance();
            } catch (
                    InstantiationException | IllegalAccessException e
            ) {
                e.printStackTrace();
            }
            plugin.getServer().getConsoleSender().sendMessage(PxAutoMessage.PREFIX + "§a |   注册命令：" + k);
            plugin.getServer().getPluginCommand(k + "").setExecutor(new CommandExecutor(commandExecutor));
        });
    }
}
