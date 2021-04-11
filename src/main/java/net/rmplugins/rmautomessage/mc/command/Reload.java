package net.rmplugins.rmautomessage.mc.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import net.rmplugins.rmautomessage.RmAutoMessage;
import net.rmplugins.rmautomessage.annotation.Permission;

/**
 * @author Levi Marvin
 */
@Permission(permission = "pxam.cmd.reload")
public class Reload implements CommandExecutor {
    private static final JavaPlugin PLUGIN = RmAutoMessage.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PLUGIN.reloadConfig();
        return true;
    }
}
