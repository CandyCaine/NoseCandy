package me.rich.nc.drug.paraphenalia;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Needle extends GenericCustomItem {

	public static final String name = "Needle";
	
	public Needle(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
