package me.fnfal113.flychecker.Listener;

import me.fnfal113.flychecker.FlyChecker;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class FlyListener implements Listener {

    FlyChecker plugin;
    public FlyListener(FlyChecker plugin) { this.plugin = plugin; }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onPermCheck(PlayerMoveEvent event) {
        Player target = event.getPlayer();
        String cmi = "cmi.command.fly";
        String island = "bskyblock.island.fly";
        String perm1 = this.plugin.getConfig().getString("permission-to-check");
        String perm2 = this.plugin.getConfig().getString("permission-to-check2");
        if(!target.isOp() && target.getGameMode() != GameMode.CREATIVE) {
            if(event.getPlayer().getAllowFlight()){
                target.setAllowFlight(true);
            }
            else if((!(event.getPlayer().hasPermission(perm1)) && (!event.getPlayer().hasPermission(perm2))) && target.isFlying() && perm1.equals(cmi) && perm2.equals(island)) {
                    target.setAllowFlight(!target.getAllowFlight());
                    target.setFlying(target.getAllowFlight());
                    target.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[FlyChecker]" + ChatColor.AQUA + " Your fly has expired.");
            }

        }


    }

}

