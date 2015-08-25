package eu.shotwar.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.shotwar.Main;
import eu.shotwar.PERM;

public class ServerData implements CommandExecutor {

	Main plugin;
	public ServerData() {}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("check-server")) {
			
			Player _user = (Player) sender;
			
			if (_user.hasPermission(PERM.ADMINKA_DATA_CMD)) {
			
				Runtime runtime = Runtime.getRuntime();
				
				System.gc();
			
				String nameOS = System.getProperty("os.name");
			
				sender.sendMessage("§a§l§m=============================================");
				sender.sendMessage("");
				sender.sendMessage("§8▍  §3RAM §8▏ ➲ §7USED §8/ §7TOTAL §8/ §7FREE " + ChatColor.AQUA + (runtime.totalMemory() - runtime.freeMemory()) / 1048576L + " MB / " + runtime.totalMemory() / 1048576L + " MB / " + runtime.freeMemory() / 1048576L + " MB");
				
				sender.sendMessage("§8▍  §3CPU §8▏ ➲ §7Available (cores) " + ChatColor.AQUA + Runtime.getRuntime().availableProcessors());
				
				sender.sendMessage("§8▍  §3CPU §8▏ ➲ §7Architecture " + ChatColor.BLUE + System.getenv("PROCESSOR_ARCHITECTURE"));
				
				sender.sendMessage("§8▍  §3OS §8▏ ➲   " + ChatColor.LIGHT_PURPLE + nameOS);
				
				sender.sendMessage("");
				sender.sendMessage("§a§l§m=============================================");
				
				sender.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Tento plugin napísal » §9 Shiro");
				
				_user.playSound(_user.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 2.0F);
				_user.playEffect(_user.getLocation(), Effect.FIREWORKS_SPARK, 1);
			}
		}
		return false;
	}
}
