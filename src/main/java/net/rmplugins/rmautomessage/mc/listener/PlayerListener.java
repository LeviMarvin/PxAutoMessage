package net.rmplugins.rmautomessage.mc.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import net.rmplugins.rmautomessage.RmAutoMessage;

/**
 * @author Levi Marvin
 */
public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        RmAutoMessage.playerList.add(e.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        RmAutoMessage.playerList.remove(e.getPlayer());
    }
}
