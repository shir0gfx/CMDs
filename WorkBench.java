package eu.shotwar.commands;

import org.bukkit.Effect; 
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.shotwar.Main;
import eu.shotwar.PERM;

public class WorkBench implements CommandExecutor {

	public Main plugin;
	public WorkBench() {		}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("wb")) {
			Player player = (Player) sender;
			if ((sender instanceof Player)) {
				if (player.hasPermission(PERM.CMD_WORKBENCH)) {
					player.openWorkbench(null, true);
				}
				player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
				
				return true;
			}
		}
		return false;
	}
}