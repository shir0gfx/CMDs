package eu.shotwar.commands;

import net.md_5.bungee.api.ChatColor; 

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import eu.shotwar.Main;
import eu.shotwar.PERM;

public class Head implements CommandExecutor {
	
	 Main plugin;
	 public Head() {
	 }
	 
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 if (!(sender instanceof Player)) {
			 sender.sendMessage("[Shotwar.eu] Tento prikaz funguje iba hracom na servery. ;)");
			 return false;
		 }
		 
		 Player player = (Player) sender;
		 
		 if (!player.hasPermission(PERM.CMD_HEAD)) {
			 player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + plugin.getConfig().getString("Config.Spravy.NoPerm").replace('&', '§'));
			 return false;
		 }
		 
		 if (cmd.getName().equalsIgnoreCase("head")) {
			 if (args.length == 0) {
				 player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Spravne pouzitie prikazu: §a§o'/head <nick>'");
			 } else if (args.length == 1) {
				 ItemStack head = getHead(args[0]);
				 
				 player.getInventory().addItem(new ItemStack[] { head });
			 } 
		 }
		 return false;
	 }
	 
	 public ItemStack getHead(String name) {
		 ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		 SkullMeta headMeta = (SkullMeta) headItem.getItemMeta();
		 
		 headMeta.setOwner(name);
		 headMeta.setDisplayName(ChatColor.YELLOW + name + ChatColor.GRAY + " - hlava");
		 headItem.setItemMeta(headMeta);
		 
		 return headItem;
	 }
}