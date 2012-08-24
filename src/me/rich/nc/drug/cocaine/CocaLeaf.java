package me.rich.nc.drug.cocaine;

import me.rich.nc.NoseCandyPlugin;

import org.getspout.spoutapi.material.item.GenericCustomItem;

public class CocaLeaf extends GenericCustomItem {

	public static final String name = "Coca Leaf";
	
	public CocaLeaf(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}

}
