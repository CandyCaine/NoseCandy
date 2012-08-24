package me.rich.nc.executor;

import me.rich.nc.NoseCandyPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpawnDrugExecutor implements CommandExecutor {

	private NoseCandyPlugin plugin;
	
	public SpawnDrugExecutor(NoseCandyPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] argument) {
		SpoutPlayer player = null;
		
		if (sender instanceof Player) {
			player = (SpoutPlayer) sender;
		}
		
		if (command.getName().equalsIgnoreCase("spawndrug")) {
			SpoutItemStack stack = new SpoutItemStack(plugin.customItems.bud, 1);
			player.getInventory().addItem(stack);
		}
		
		return false;
	}
	
}
