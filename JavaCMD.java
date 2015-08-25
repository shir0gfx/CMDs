package eu.shotwar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import eu.shotwar.Main;
import eu.shotwar.PERM;

public class JavaCMD implements CommandExecutor {
	
	Main plugin;
	public JavaCMD() {	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("java-ver")) {
			if (sender.hasPermission(PERM.ADMINKA_JAVA_CMD)) {
				sender.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Server bezi na §fJave: " + Runtime.class.getPackage().getImplementationVersion());
				
				return true;
			} else {
				sender.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + plugin.getConfig().getString("Config.Spravy.NoPerm").replace('&', '§'));
			}
		}
		return false;
	}
}