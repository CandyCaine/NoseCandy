package me.rich.nc.drug.paraphenalia;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Bong extends GenericCustomItem {

	public static final String name = "Bong";
	
	public Bong(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
