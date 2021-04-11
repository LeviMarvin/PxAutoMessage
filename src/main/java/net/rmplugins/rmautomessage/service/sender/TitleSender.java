package net.rmplugins.rmautomessage.service.sender;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.rmplugins.rmautomessage.RmAutoMessage;

import static net.rmplugins.rmautomessage.service.TextManager.sendTitle;

/**
 * @author Levi Marvin
 */
public class TitleSender extends BukkitRunnable {
    @Override
    public void run() {
        for (Player p : RmAutoMessage.playerList) {
            sendTitle(p, "Title", "SubTitle",1,1,1);
        }
    }
}
