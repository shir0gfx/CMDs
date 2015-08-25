package eu.shotwar.commands;

import org.bukkit.Bukkit;  
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.shotwar.Main;
import eu.shotwar.PERM;

public class ClearChat implements CommandExecutor {

	public Main plugin;
	public ClearChat() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("clearchat")) {
			
			if (!player.hasPermission(PERM.ADMINKA_CLEAR_CHAT_CMD)) {
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 20.0F, 20.0F);
			
				player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + plugin.getConfig().getString("Config.Spravy.NoPerm").replace('&', '§'));
			}
			
			if (args.length == 0) {
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 20.0F, 20.0F);
				
				for (int i = 0; i < 200; i++) {
					Bukkit.broadcastMessage(" ");
				}
				
				Bukkit.broadcastMessage("§c➲ §eChat bol vyčistený uživateľom §8» §6" + player.getName());
			}
			
			if (args.length == 1) {
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 20.0F, 20.0F);
				
				player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Tato funkcia ešte nieje dokončená.");
				player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Shirovi sa to nechcelo písat.. a myslím, že ani nebude chcieť. §2#imLazy");
				player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Môžeš ma kontaktovať na maily §f§lshiro@shotwar.eu §7či to náhodou nenapíšem. :D");
				
				return true;
			}
		}
		return false;
	}
}