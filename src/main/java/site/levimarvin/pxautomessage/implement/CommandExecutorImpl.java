package site.levimarvin.pxautomessage.implement;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import site.levimarvin.pxautomessage.annotation.Permission;

import java.lang.reflect.Method;

public interface CommandExecutorImpl extends CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args);

    default boolean onCommandWithPermission(CommandSender sender, Command command, String label, String[] args) {
        if (hasPermission((Player) sender)) onCommand(sender, command, label, args);
        return false;
    }

    default boolean hasPermission(Player p) {
        Permission permission = this.getClass().getDeclaredAnnotation(Permission.class);
        return p.hasPermission(permission.permission());
    }
}
