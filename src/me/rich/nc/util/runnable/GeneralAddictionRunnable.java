package me.rich.nc.util.runnable;

import me.rich.nc.NoseCandyPlugin;

public abstract class GeneralAddictionRunnable implements Runnable {

	protected NoseCandyPlugin plugin;
	
	public GeneralAddictionRunnable(NoseCandyPlugin plugin) {
		this.plugin = plugin;
	}
}
