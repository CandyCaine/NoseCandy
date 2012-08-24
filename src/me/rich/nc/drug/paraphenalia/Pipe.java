package me.rich.nc.drug.paraphenalia;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Pipe extends GenericCustomItem {

	public static final String name = "Glass Pipe";
	
	public Pipe(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
