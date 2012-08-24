package me.rich.nc.listener;

import me.rich.nc.NoseCandyPlugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NoseCandyPlayerListener implements Listener {

	private NoseCandyPlugin plugin;
	
	public NoseCandyPlayerListener(NoseCandyPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {
		if (!this.plugin.getNCDatabase().hasPlayer(event.getPlayer().getName())) {
			this.plugin.getNCDatabase().createNewPlayerRecord(event.getPlayer().getName());
		}
	}
}
