package site.levimarvin.pxautomessage.service.sender;

import org.bukkit.entity.Player;
import site.levimarvin.pxautomessage.PxAutoMessage;
import site.levimarvin.pxautomessage.implement.SenderImpl;

import static site.levimarvin.pxautomessage.service.TextManagerSrv.sendTitle;

public class TitleSender implements SenderImpl {
    @Override
    public void run() {
        for (Player p : PxAutoMessage.playerList) {
            sendTitle(p, "Title", "SubTitle",1,1,1);
        }
    }

    public void stopRunning() {

    }

    public void outInfo() {

    }
}
