package me.fnfal113.flychecker.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class IslandFlyListener implements Listener {

    @EventHandler
    public void onFly(PlayerMoveEvent event) {
        Player target = event.getPlayer();


        if(!target.isOp()) {
            if (!(target.hasPermission("bskyblock.island.fly"))) {
                if (target.isFlying()) {
                    target.setFlying(false);
                    target.setAllowFlight(false);
                }
            }
        }
    }

}