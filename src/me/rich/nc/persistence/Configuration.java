package me.rich.nc.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import me.rich.nc.NoseCandyPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Configuration {

	private File dataFolder;

	private File configFile;
	private FileConfiguration config;
	
	public Configuration(NoseCandyPlugin plugin) {
		this.dataFolder = plugin.getDataFolder();
		this.validateDirectory(plugin);
	}
	
	public void validateDirectory(NoseCandyPlugin plugin) {
		if (!this.dataFolder.exists()) {
			this.dataFolder.mkdirs();
		}
		
		this.configFile = new File(this.dataFolder, "config.yml");
		if (!this.configFile.exists()) {
			this.copyFile(plugin.getResource("config.yml"), this.configFile);
		}
		this.load();
	}
	
	public void load() {
		this.config = new YamlConfiguration();
		try {
			this.config.load(configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void copyFile(InputStream in, File file) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public FileConfiguration getConfig() {
		return this.config;
	}
}
