package me.rich.nc;

import me.rich.nc.executor.AddictionExecutor;
import me.rich.nc.executor.NoseCandyExecutor;
import me.rich.nc.executor.SpawnDrugExecutor;
import me.rich.nc.listener.NoseCandyPlayerListener;
import me.rich.nc.persistence.Configuration;
import me.rich.nc.persistence.Database;
import me.rich.nc.util.runnable.CocaineAddictionRunnable;
import me.rich.nc.util.runnable.HIVRunnable;
import me.rich.nc.util.runnable.HepatitisRunnable;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
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
		this.config = new Configuration(this);
		this.addToCache();
		this.registerCommands();
		this.customItems = new CustomItems(this);
		Bukkit.getServer().getPluginManager().registerEvents(new NoseCandyPlayerListener(this), this);
		this.startTasks();
	}

	private void addToCache() {
		FileManager fm = SpoutManager.getFileManager();
		fm.addToPreLoginCache(this, "https://dl.dropbox.com/u/86467984/NoseCandy/Image/bud.png");
	}
	
	private void registerCommands() {
		this.getCommand(NoseCandyExecutor.name).setExecutor(new NoseCandyExecutor(this));
		this.getCommand(AddictionExecutor.name).setExecutor(new AddictionExecutor(this));
		this.getCommand(SpawnDrugExecutor.name).setExecutor(new SpawnDrugExecutor(this));
	}

	private void startTasks() {
		BukkitScheduler scheduler = Bukkit.getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new HepatitisRunnable(this), 6000L, 6000L);
		scheduler.scheduleSyncRepeatingTask(this, new HIVRunnable(this), 12000L, 6000L);
		scheduler.scheduleSyncRepeatingTask(this, new CocaineAddictionRunnable(this), 12000L, 12000L);
	}
	
	public Database getNCDatabase() {
		return this.database;
	}
	
	public FileConfiguration getConfiguration() {
		return this.config.getConfig();
	}
	
}
