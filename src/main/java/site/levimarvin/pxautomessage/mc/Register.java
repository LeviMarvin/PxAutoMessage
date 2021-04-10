package site.levimarvin.pxautomessage.mc;

import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.mc.command.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author Levi Marvin
 */
public class Register {
    private static final JavaPlugin PLUGIN = PxAutoMessage.getPlugin();
    private static HashMap<String, Class<?>> cmdMap = new HashMap<>();

    public static void registerCmd() {
        cmdMap.put("debug", Debug.class);
        cmdMap.put("reload", Reload.class);
        cmdMap.forEach((k, v) -> {
            org.bukkit.command.CommandExecutor commandExecutor = null;
            try {
                commandExecutor = (org.bukkit.command.CommandExecutor) v.getDeclaredConstructor().newInstance();
            } catch (
                    InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e
            ) {
                e.printStackTrace();
            }
            PLUGIN.getServer().getConsoleSender().sendMessage(PxAutoMessage.PREFIX + "§a |   注册命令：" + k);
            PLUGIN.getServer().getPluginCommand(k + "").setExecutor(new CommandExecutor(commandExecutor));
        });
    }

    public static void registerListener() {
        //TODO
    }
}
