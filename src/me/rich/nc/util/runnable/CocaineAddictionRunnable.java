package me.rich.nc.util.runnable;

import me.rich.nc.NoseCandyPlugin;
import me.rich.nc.persistence.Database.Column;
import me.rich.nc.util.EffectFactory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CocaineAddictionRunnable extends GeneralAddictionRunnable {

	public CocaineAddictionRunnable(NoseCandyPlugin plugin) {
		super(plugin);
	}

	@Override
	public void run() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (plugin.getNCDatabase().getAddiction(player.getName(), Column.COCAINE_ADDICTION) > 30) {
				EffectFactory.getInstance().applyCocaineAddictEffect(player);
			}
		}
	}

}
