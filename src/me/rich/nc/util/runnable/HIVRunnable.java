package me.rich.nc.util.runnable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.rich.nc.NoseCandyPlugin;

public class HIVRunnable implements Runnable {

	private NoseCandyPlugin plugin;
	
	public HIVRunnable(NoseCandyPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			if (this.plugin.getNCDatabase().hasHepatitis(player.getName())) {
				
			}
		}
	}
}
