package eu.shotwar.commands;

import java.util.ArrayList; 
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.shotwar.Main;

public class PVP implements CommandExecutor {

	ArrayList<UUID> safePlayers = new ArrayList<UUID>();

	public Main plugin;
	public PVP() {		}

	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[Shotwar.eu] Tento prikaz funguje iba hracom na servery. ;)");
			return true;
		}

		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (args.length == 0) {
				player.sendMessage("");
				player.sendMessage("");
				player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Musis si bud zapnut alebo vypnut pvp prikazmi:");
				player.sendMessage("/pvp on");
				player.sendMessage("/pvp off");
				
			}

			if (args[0].equalsIgnoreCase("on")) {
				if (this.safePlayers.contains(player.getUniqueId())) {
				
					this.safePlayers.remove(player.getUniqueId());
					
					unsafeMessage(player);
				} else {
					player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Ty uz mas PVP zapnute!");
				}
			} else if (args[0].equalsIgnoreCase("off")) {
				if (!this.safePlayers.contains(player.getUniqueId())) {
					
					this.safePlayers.add(player.getUniqueId());
					
					safeMessage(player);
				} else {
					player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Ty uz mas PVP vypnute!");
				}
			} else {
				player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Vyber si medzi 'on' alebo 'off'");
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if (this.safePlayers.contains(player.getUniqueId())) {
			safeMessage(player);
		} else {
			unsafeMessage(player);
		}
	}

	@EventHandler
	public void onPlayerHit(EntityDamageByEntityEvent e) {
		if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player))) {

			Player damager = (Player) e.getDamager();
			Player victim = (Player) e.getEntity();

			if ((!this.safePlayers.contains(damager.getUniqueId())) && (this.safePlayers.contains(victim.getUniqueId()))) {
				damager.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + ChatColor.RED + "Tento hrac je chraneny pred PVP.");
				
				e.setCancelled(true);
			} else if ((this.safePlayers.contains(damager.getUniqueId())) && (!this.safePlayers.contains(victim.getUniqueId()))) {
				damager.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Prv si povol PVP prikazom §6'/pvp on' §7a potom zakladaj utoky!");
				
				e.setCancelled(true);
			} else if ((this.safePlayers.contains(damager.getUniqueId())) && (this.safePlayers.contains(victim.getUniqueId()))) {
				damager.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "Obaja mate PVP ochranu zapnutu!");
				
				e.setCancelled(true);
			}
		}
	}

	void safeMessage(Player player) {
		player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "§aSi chraneny pred PVP!");
	}

	void unsafeMessage(Player player) {
		player.sendMessage(plugin.getConfig().getString("Config.Spravy.Prefix").replace('&', '§') + "§cSi teraz nechraneny pred PVP!");
	}
}