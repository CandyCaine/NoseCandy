package me.rich.nc.util.runnable;

import me.rich.nc.NoseCandyPlugin;
import me.rich.nc.util.EffectFactory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HepatitisRunnable implements Runnable {

	private NoseCandyPlugin plugin;

	public HepatitisRunnable(NoseCandyPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			if (this.plugin.getNCDatabase().hasHepatitis(player.getName())) {
				EffectFactory.getInstance().applyHepatitisEffect(player);
				player.sendMessage("You have Hepatitis.");
			}
		}
	}
}
