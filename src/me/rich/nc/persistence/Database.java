package me.rich.nc.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import lib.PatPeter.SQLibrary.SQLite;
import me.rich.nc.NoseCandyPlugin;

public class Database {

	private SQLite sqlite;

	private NoseCandyPlugin plugin;

	public static enum Column {

		PLAYERNAME("playername"), COCAINE_ADDICTION("cocaine_addiction"), COCAINE_USAGE("cocaine_usage"), HEROIN_ADDICTION("heroin_addiction"), HEROIN_USAGE("heroin_usage"), WEED_ADDICTION(
				"weed_addiction"), WEED_USAGE("weed_usage"), HIV("hiv"), HEPATITIS("hepatitis");

		private String name;

		Column(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}

	public Database(NoseCandyPlugin plugin, String name) {
		this.plugin = plugin;
		this.sqlite = new SQLite(plugin.getLogger(), plugin.getName(), name, plugin.getDataFolder().getAbsolutePath());
		try {
			this.sqlite.open();
		} catch (Exception e) {
			plugin.getLogger().info(e.getMessage());
			plugin.getPluginLoader().disablePlugin(plugin);
		}

		this.checkTable();
	}

	public void checkTable() {
		if (this.sqlite.checkTable("nosecandy")) {
			return;
		} else {
			sqlite.query("CREATE TABLE nosecandy (id INT PRIMARY KEY, playername VARCHAR(50), cocaine_addiction INT, cocaine_usage INT, heroin_addiction INT, heroin_usage INT, weed_addiction INT, weed_usage INT, hiv BOOLEAN NOT NULL DEFAULT 0, hepatitis BOOLEAN NOT NULL DEFAULT 0);");
			plugin.getLogger().info("Database has been created.");
		}
	}

	public void createNewPlayerRecord(String player) {
		if (!this.hasPlayer(player)) {
			this.sqlite.query("INSERT INTO nosecandy (playername, cocaine_addiction, cocaine_usage, heroin_addiction, heroin_usage, weed_addiction, weed_usage, hiv, hepatitis) VALUES ('" + player
					+ "', 0, 0, 0, 0, 0, 0, 0, 0);");
		} else {
			System.out.println("Player already exists");
		}
	}

	public boolean hasPlayer(String player) {
		String query = "SELECT * FROM nosecandy WHERE playername='" + player + "';";
		ResultSet result = null;
		result = this.sqlite.query(query);

		try {
			if (result != null && result.next()) {
				String name = result.getString("playername");
				if (name.equals(player)) {
					result.close();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public int getAddiction(String player, Column column) {
		String query = "SELECT * FROM nosecandy WHERE playername='" + player + "';";
		ResultSet result = null;
		result = this.sqlite.query(query);

		try {
			if (result != null && result.next()) {
				String name = result.getString("playername");
				int addiction = result.getInt(column.getName());
				if (name.equals(player)) {
					result.close();
					return addiction;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int getUsage(String player, Column column) {
		String query = "SELECT * FROM nosecandy WHERE playername='" + player + "';";
		ResultSet result = null;
		result = this.sqlite.query(query);

		try {
			if (result != null && result.next()) {
				String name = result.getString("playername");
				int usage = result.getInt(column.getName());
				if (name.equals(player)) {
					result.close();
					return usage;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public boolean hasHIV(String player) {
		String query = "SELECT * FROM nosecandy WHERE hiv='1';";
		ResultSet result = null;
		result = this.sqlite.query(query);
		boolean hiv = false;
		try {
			if (result != null && result.next()) {
				hiv = result.getBoolean(Column.HIV.getName());
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hiv;
	}

	public void setHIV(String player, boolean hiv) {
		String query, basequery = "UPDATE nosecandy SET hiv=%s WHERE playername='" + player + "';";
		if (hiv) {
			query = String.format(basequery, 1);
		} else {
			query = String.format(basequery, 0);
		}
		
		this.sqlite.query(query);
	}
	
	public boolean hasHepatitis(String player) {
		String query = "SELECT * FROM nosecandy WHERE hepatitis='1';";
		ResultSet result = null;
		result = this.sqlite.query(query);
		boolean hepatitis = false;
		try {
			if (result != null && result.next()) {
				hepatitis = result.getBoolean(Column.HEPATITIS.getName());
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hepatitis;
	}
	
	public void setHepatitis(String player, boolean hepatitis) {
			String query, basequery = "UPDATE nosecandy SET hepatitis=%s WHERE playername='" + player + "';";
			if (hepatitis) {
				query = String.format(basequery, 1);
			} else {
				query = String.format(basequery, 0);
			}
			
			this.sqlite.query(query);
	}

	public SQLite getSQLite() {
		return this.sqlite;
	}

	public void closeConnection() {
		this.sqlite.close();
	}

}
