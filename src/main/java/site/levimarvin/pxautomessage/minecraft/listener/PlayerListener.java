package site.levimarvin.pxautomessage.minecraft.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import site.levimarvin.pxautomessage.PxAutoMessage;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        PxAutoMessage.playerList.add(e.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        PxAutoMessage.playerList.remove(e.getPlayer());
    }
}
