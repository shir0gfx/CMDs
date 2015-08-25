package eu.shotwar.commands;

import net.md_5.bungee.api.ChatColor; 

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import eu.shotwar.Main;
import eu.shotwar.PERM;

public class AlertCMD implements CommandExecutor {

	Main plugin;
	public AlertCMD() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("alert")) {
			if (sender.hasPermission(PERM.ADMINKA_ALERT)) {

				if (args.length < 1) {
					return false;
				}
				
				String alert = "";
				String[] arrayOfString;
				
				int j = (arrayOfString = args).length;
				for (int i = 0; i < j; i++) {
					String str = arrayOfString[i];
					alert = alert + str + " ";
				}
				
				Bukkit.broadcastMessage(ChatColor.GOLD + "§8▍ §6Alert §8▏ " + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', alert));
			} else {
				sender.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + plugin.getConfig().getString("Config.Spravy.NoPerm").replace('&', '§'));
			}
		}
		return false;
	}
}