package eu.shotwar.commands;

import net.md_5.bungee.api.ChatColor; 

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.shotwar.Main;

public class Time implements CommandExecutor {

	public Main plugin;
	public Time() {		}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("shotwar")) && ((sender instanceof Player))) {
			Player p = (Player)sender;
			
			if (args.length >= 1 && args[0].equalsIgnoreCase("time")) {
				int a = p.getTicksLived() / 20;
				int b = a / 60;
				int c = b / 60;
				
				p.sendMessage("");
				p.sendMessage("");
				p.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Od dnesneho pripojenia na server do teraz si na servery stravil:");
				p.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Sekund - " + ChatColor.GREEN.toString() + ChatColor.BOLD + a);
				p.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Minut - " + ChatColor.GREEN.toString() + ChatColor.BOLD + b);
				p.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Hodin - " + ChatColor.GREEN.toString() + ChatColor.BOLD + c);
			}
		}
		return false;
	}
}