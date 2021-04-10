package site.levimarvin.pxautomessage.service.sender;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import site.levimarvin.pxautomessage.PxAutoMessage;

import static site.levimarvin.pxautomessage.service.TextManager.sendTitle;

/**
 * @author Levi Marvin
 */
public class TitleSender extends BukkitRunnable {
    @Override
    public void run() {
        for (Player p : PxAutoMessage.playerList) {
            sendTitle(p, "Title", "SubTitle",1,1,1);
        }
    }
}
