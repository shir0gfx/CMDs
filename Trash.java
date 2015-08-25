package eu.shotwar.commands;

import org.bukkit.Bukkit; 
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import eu.shotwar.Main;
import eu.shotwar.PERM;

public class Trash implements CommandExecutor {
	
	public Main plugin;
	public Trash() {		}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("trash"))) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission(PERM.CMD_TRASH)) {
					Inventory inv = Bukkit.createInventory(player, 27, "§8§lOdpadkovy kos");
					
					player.openInventory(inv);
					player.playSound(player.getLocation(), Sound.CHEST_CLOSE, 1.0F, 2.0F);
					
					return true;
				} else {
					player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + plugin.getConfig().getString("Config.Spravy.NoPerm").replace('&', '§'));
				}
			} else {
				sender.sendMessage("[Shotwar.eu] Tento prikaz funguje iba hracom na servery. ;)");
			}
		}
		return false;
	}
}
