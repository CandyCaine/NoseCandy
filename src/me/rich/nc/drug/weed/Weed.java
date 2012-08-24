package me.rich.nc.drug.weed;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Weed extends GenericCustomItem {

	public static final String name = "Weed";
	
	public Weed(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}
}
