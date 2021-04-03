package site.levimarvin.pxautomessage.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.minecraft.command.Debug;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Command {
    private static final JavaPlugin plugin = PxAutoMessage.getPlugin();
    private static HashMap<String, Class<?>> cmdMap = new HashMap<>();

    public static void registerCmd() {
        cmdMap.put("debug", Debug.class);
        cmdMap.forEach((k, v) -> {
            CommandExecutor commandExecutor = null;
            try {
                commandExecutor = (CommandExecutor) v.getDeclaredConstructor().newInstance();
            } catch (
                    InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e
            ) {
                e.printStackTrace();
            }
            plugin.getServer().getConsoleSender().sendMessage(PxAutoMessage.PREFIX + "§a |   注册命令：" + k);
            plugin.getServer().getPluginCommand(k + "").setExecutor(commandExecutor);
        });
    }
}
