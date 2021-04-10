package site.levimarvin.pxautomessage.mc.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import site.levimarvin.pxautomessage.annotation.Permission;
import site.levimarvin.pxautomessage.service.TextManager;

/**
 * @author Levi Marvin
 */
@Permission(permission = "pxam.cmd.debug")
public class Debug implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("pxam.cmd.debug")) {
            if (args.length == 0){
                debug_DefaultTitle(sender);
            }else {
                sender.sendMessage(String.valueOf(ErrorInfo.CE));
            }
        }else {
            sender.sendMessage(String.valueOf(ErrorInfo.HNP));
        }
        return false;
    }

    private void debug_DefaultTitle(CommandSender sender) {
        TextManager.sendTitle((Player) sender, "{\"text\":\"Main\",\"bold\":\"true\"}", "{\"text\":\"sub\",\"bold\":\"false\"}", 1, 1, 1);
    }
}
