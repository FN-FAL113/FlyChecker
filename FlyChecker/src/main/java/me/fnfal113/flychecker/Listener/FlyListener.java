package me.fnfal113.flychecker.Listener;

import me.fnfal113.flychecker.FlyChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.permissions.Permission;

import java.io.Console;


public class FlyListener implements Listener {

    FlyChecker plugin;
    public FlyListener(FlyChecker plugin) { this.plugin = plugin; }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onPermCheck(PlayerToggleFlightEvent event) {
        Player target = event.getPlayer();
        Permission perm1 = new Permission(this.plugin.getConfig().getString("permission1"));
        Permission perm2 = new Permission(this.plugin.getConfig().getString("permission2"));
        if(!target.isOp() && target.getGameMode() != GameMode.CREATIVE && (this.plugin.getConfig().isSet("permission1") || this.plugin.getConfig().isSet("permission2"))) {
                if ((event.getPlayer().hasPermission(perm1) || event.getPlayer().hasPermission(perm2))) {
                    target.setAllowFlight(true);
                    target.recalculatePermissions();
                } else {
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    target.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[FlyChecker]" + ChatColor.AQUA + " Fly expired!");
                }
        }

    }

}

