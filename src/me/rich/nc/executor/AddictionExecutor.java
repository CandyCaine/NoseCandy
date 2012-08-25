package me.rich.nc.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

import me.rich.nc.NoseCandyPlugin;
import me.rich.nc.persistence.Database.Column;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddictionExecutor implements CommandExecutor {

	public static final String name = "addiction";

	private final String COCAINE = "cocaine", HEROIN = "heroin", WEED = "weed";
	
	private NoseCandyPlugin plugin;

	public AddictionExecutor(NoseCandyPlugin plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Player player = null;

		if (sender instanceof Player) {
			player = (Player) sender;
		}

		if (command.getName().equalsIgnoreCase(name)) {

			if (args.length == 0) {
				if (player != null) {
					if (player.hasPermission("nosecandy.addiction.get.self")) {
						this.sendAddiction(player, player);
						return true;
					} else {
						player.sendMessage("You do not have permission.");
						return true;
					}
				} else {
					sender.sendMessage("Command must be sent from a player.");
					return true;
				}
			} else if (args.length == 1) {
				if (player != null) {
					if (player.hasPermission("nosecandy.addiction.get.other")) {
						if (Bukkit.getServer().getPlayer(args[0]) != null) {
							this.sendAddiction(player, Bukkit.getServer().getPlayer(args[0]));
							return true;
						} else {
							player.sendMessage("Player is not online.");
							return true;
						}
					} else {
						player.sendMessage("You do not have permission.");
						return true;
					}
				} else {
					if (Bukkit.getServer().getPlayer(args[0]) != null) {
						this.sendAddiction(player, Bukkit.getServer().getPlayer(args[0]));
						return true;
					} else {
						sender.sendMessage("Player is not online.");
						return true;
					}
				}
				
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("set")) {
					if (player != null) {
						if (player.hasPermission("nosecandy.addiction.set")) {
							if (Bukkit.getServer().getPlayer(args[1]) != null) {
								if (args[2].equalsIgnoreCase(COCAINE)
										|| args[2].equalsIgnoreCase(HEROIN)
										|| args[2].equalsIgnoreCase(WEED)) {
									
									int addiction = 0;
									try {
										addiction = Integer.parseInt(args[3]);
									} catch (NumberFormatException e) {
										player.sendMessage("Incorrect Syntax, expected number. /addiction [set] [player] [cocaine|heroin|weed] [addiction]");
										return true;
									}
									
									if (args[2].equalsIgnoreCase(COCAINE)) {
										this.setAddiction(player, Bukkit.getServer().getPlayer(args[1]), Column.COCAINE_ADDICTION, addiction);
										return true;
									} else if (args[2].equalsIgnoreCase(HEROIN)) {
										this.setAddiction(player, Bukkit.getServer().getPlayer(args[1]), Column.HEROIN_ADDICTION, addiction);
										return true;
									} else if (args[2].equalsIgnoreCase(WEED)) {
										this.setAddiction(player, Bukkit.getServer().getPlayer(args[1]), Column.WEED_ADDICTION, addiction);
										return true;
									}
									
								} else {
									player.sendMessage("Incorrect Syntax, drug expected. /addiction [set] [player] [cocaine|heroin|weed] [addiction]");
									return true;
								}
							} else {
								player.sendMessage("Specified player is not online.");
								return true;
							}
						} else {
							player.sendMessage("You do not have permission to perform this command");
							return true;
						}
					} else {
						if (Bukkit.getServer().getPlayer(args[1]) != null) {
							if (args[2].equalsIgnoreCase(COCAINE)
									|| args[2].equalsIgnoreCase(HEROIN)
									|| args[3].equalsIgnoreCase(WEED)) {
								
								int addiction = 0;
								try {
									addiction = Integer.parseInt(args[3]);
								} catch (NumberFormatException e) {
									sender.sendMessage("Incorrect Syntax, expected number. /addiction [set] [player] [cocaine|heroin|weed] [addiction]");
									return true;
								}
								
								if (args[2].equalsIgnoreCase(COCAINE)) {
									this.setAddiction(sender, Bukkit.getServer().getPlayer(args[1]), Column.COCAINE_ADDICTION, addiction);
									return true;
								} else if (args[2].equalsIgnoreCase(HEROIN)) {
									this.setAddiction(sender, Bukkit.getServer().getPlayer(args[1]), Column.HEROIN_ADDICTION, addiction);
									return true;
								} else if (args[2].equalsIgnoreCase(WEED)) {
									this.setAddiction(sender, Bukkit.getServer().getPlayer(args[1]), Column.WEED_ADDICTION, addiction);
									return true;
								}
								
							} else {
								sender.sendMessage("Incorrect Syntax, drug expected. /addiction [set] [player] [cocaine|heroin|weed] [addiction]");
								return true;
							}
						} else {
							sender.sendMessage("Specified player is not online.");
							return true;
						}
					}
				} else {
					sender.sendMessage("Command unrecognised");
					return true;
				}
			}
		}
		return false;
	}

	public void sendAddiction(CommandSender toSend, Player getInfo) {
		ResultSet result = null;
		String query = "SELECT * FROM nosecandy WHERE playername='" + getInfo.getName() + "';";
		result = this.plugin.getNCDatabase().getSQLite().query(query);

		try {
			if (result != null && result.next()) {
				toSend.sendMessage("=== NoseCandy ===");
				toSend.sendMessage("Name: " + getInfo.getName());
				toSend.sendMessage("Cocaine Addiction: " + result.getInt(Column.COCAINE_ADDICTION.getName()));
				toSend.sendMessage("Heroin Addiction: " + result.getInt(Column.HEROIN_ADDICTION.getName()));
				toSend.sendMessage("Weed Addiction: " + result.getInt(Column.WEED_ADDICTION.getName()));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setAddiction(CommandSender sender, Player player, Column column, int addiction) {
		String basequery = "UPDATE nosecandy SET %s=%s WHERE playername='%s';";
		String query = String.format(basequery, column.getName(), addiction, player.getName());
		this.plugin.getNCDatabase().getSQLite().query(query);
		this.sendAddiction(sender, player);
	}
}
