package me.rich.nc.drug.heroin;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class OpiumSap extends GenericCustomItem {

	public static final String name = "Opium Sap";
	
	public OpiumSap(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
