package me.rich.nc.drug.heroin;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Pod extends GenericCustomItem {

	public static final String name = "Pod";
	
	public Pod(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
