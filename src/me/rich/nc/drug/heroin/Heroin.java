package me.rich.nc.drug.heroin;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Heroin extends GenericCustomItem {

	public static final String name = "Heroin";
	
	public Heroin(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
