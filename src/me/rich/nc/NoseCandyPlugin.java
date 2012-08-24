package me.rich.nc;

import me.rich.nc.listener.NoseCandyPlayerListener;
import me.rich.nc.persistence.Configuration;
import me.rich.nc.persistence.Database;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.FileManager;

public class NoseCandyPlugin extends JavaPlugin {

	private static NoseCandyPlugin instance;

	public static NoseCandyPlugin getInstance() {
		return instance;
	}

	private Database database;
	private Configuration config;
	
	public CustomItems customItems;

	@Override
	public void onDisable() {
		this.database.closeConnection();
	}

	@Override
	public void onEnable() {
		NoseCandyPlugin.instance = this;
		this.database = new Database(this, "NoseCandy");
		
		database.createNewPlayerRecord("test");

		this.config = new Configuration(this);
		this.addToCache();
		this.customItems = new CustomItems(this);
		Bukkit.getServer().getPluginManager().registerEvents(new NoseCandyPlayerListener(this), this);
	}

	private void addToCache() {
		FileManager fm = SpoutManager.getFileManager();
		fm.addToPreLoginCache(this, "https://dl.dropbox.com/u/86467984/NoseCandy/Image/bud.png");
	}

	public Database getNCDatabase() {
		return this.database;
	}
	
	public FileConfiguration getConfiguration() {
		return this.config.getConfig();
	}
	
}
