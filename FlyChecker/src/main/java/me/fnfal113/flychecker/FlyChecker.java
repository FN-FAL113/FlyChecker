package me.fnfal113.flychecker;

import me.fnfal113.flychecker.Commands.ReloadPlugin;
import me.fnfal113.flychecker.Listener.FlyListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlyChecker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("IslandFlyChecker has started.\nThis small plugin was developed by FN_FAL113");

        getServer().getPluginManager().registerEvents(new FlyListener(this), this);
        getCommand("flychecker").setExecutor(new ReloadPlugin(this));
    }


}
