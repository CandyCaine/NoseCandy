package me.rich.nc.drug.paraphenalia;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Fertilizer extends GenericCustomItem {

	public static final String name = "Fertilizer";
	
	public Fertilizer(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
