package site.levimarvin.pxautomessage.mc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import site.levimarvin.pxautomessage.annotation.Permission;
import site.levimarvin.pxautomessage.annotation.Commander;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {
    private final org.bukkit.command.CommandExecutor COMMAND_EXECUTOR;

    public CommandExecutor(org.bukkit.command.CommandExecutor CE) {
        this.COMMAND_EXECUTOR = CE;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Permission permission = COMMAND_EXECUTOR.getClass().getAnnotation(Permission.class);
        Commander commander = COMMAND_EXECUTOR.getClass().getAnnotation(Commander.class);
        if (sender.hasPermission(permission.permission())) {
            //TODO: THERE MAYBE HAVE SOME BUGS!
            switch (commander.only()) {
                case "console":
                    if (sender instanceof Player) {
                        sender.sendMessage("Only the CONSOLE can execute this!");
                        break;
                    }
                    COMMAND_EXECUTOR.onCommand(sender, command, label, args);
                    break;
                case "player":
                    if (sender instanceof Player) {
                        sender.sendMessage("Only the PLAYER can execute this!");
                        break;
                    }
                    COMMAND_EXECUTOR.onCommand(sender, command, label, args);
                    break;
                default:
                    COMMAND_EXECUTOR.onCommand(sender, command, label, args);
            }
        } else {
            sender.sendMessage("§cYou have not permission to do this!");
        }
        return true;
    }
}
