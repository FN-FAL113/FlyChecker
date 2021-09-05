package me.fnfal113.flychecker.Commands;

import me.fnfal113.flychecker.FlyChecker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadPlugin implements CommandExecutor {

    FlyChecker plugin;

    public ReloadPlugin(FlyChecker plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

                    if (sender.hasPermission("flychecker.flycheck")) {
                        if (args.length == 0) {
                            sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[FlyChecker]" + "" + ChatColor.AQUA + " Please use /flychecker help for documentation\n\t\t   Plugin by FN_FAL113");
                        } else if (args[0].equalsIgnoreCase("reload")) {
                            plugin.reloadConfig();
                            sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[FlyChecker]" + "" + ChatColor.AQUA + ChatColor.BOLD + " Config has been reloaded!");
                        } else if (args[0].equalsIgnoreCase("help")) {
                            sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[FlyChecker]" + "" + ChatColor.AQUA + " /flychecker reload to reload the plugin");
                        }
                    } else {
                        sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[FlyChecker]" + "" + ChatColor.AQUA + " You do not have permission to access this command!");
                    }

            return true;

        }
}
