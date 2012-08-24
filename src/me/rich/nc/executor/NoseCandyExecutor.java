package me.rich.nc.executor;

import me.rich.nc.NoseCandyPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NoseCandyExecutor implements CommandExecutor {

	public static final String name = "nosecandy";
	
	private NoseCandyPlugin plugin;
	
	public NoseCandyExecutor(NoseCandyPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		
		if (command.getName().equalsIgnoreCase(name)) {
			
		}
		return false;
	}
}
