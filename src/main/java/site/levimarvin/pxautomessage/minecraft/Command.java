package site.levimarvin.pxautomessage.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.minecraft.command.Debug;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Command {
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
            Bukkit.getConsoleSender().sendMessage(PxAutoMessage.PREFIX + "§a |   注册命令：" + k);
            Bukkit.getPluginCommand(k + "").setExecutor(commandExecutor);
        });
    }
}
