package me.fnfal113.flychecker.Listener;

import me.fnfal113.flychecker.FlyChecker;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;


public class FlyListener implements Listener {

    FlyChecker plugin;
    public FlyListener(FlyChecker plugin) { this.plugin = plugin; }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onPermCheck(PlayerToggleFlightEvent event) {
        Player target = event.getPlayer();
        if(!target.isOp() && target.getGameMode() != GameMode.CREATIVE && target.isFlying()) {
                if (event.getPlayer().hasPermission("cmi.command.fly") || event.getPlayer().hasPermission("bskyblock.island.fly")) {
                    target.setAllowFlight(true);
                    target.setFlying(true);
                }
                else {
                    target.setAllowFlight(!target.getAllowFlight());
                    target.setFlying(target.getAllowFlight());
                    target.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[FlyChecker]" + ChatColor.AQUA + " Your fly has expired.");
                }
        }
    }

}

