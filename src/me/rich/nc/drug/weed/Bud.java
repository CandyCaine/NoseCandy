package me.rich.nc.drug.weed;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Bud extends GenericCustomItem {

	public static final String name = "Bud";
	
	public Bud(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
