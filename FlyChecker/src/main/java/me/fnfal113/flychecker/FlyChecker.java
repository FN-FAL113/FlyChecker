package me.fnfal113.flychecker;

import me.fnfal113.flychecker.Listener.IslandFlyListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlyChecker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("IslandFlyChecker has started.\nThis small plugin was developed by FN_FAL113");
        getServer().getPluginManager().registerEvents(new IslandFlyListener(), this);
    }


}
