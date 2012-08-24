package me.rich.nc.drug.cocaine;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Alkaloids extends GenericCustomItem {

	public static final String name = "Alkaloids";
	
	public Alkaloids(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
