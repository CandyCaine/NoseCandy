package me.rich.nc;

import java.util.HashMap;
import java.util.Map;

import me.rich.nc.drug.cocaine.Alkaloids;
import me.rich.nc.drug.cocaine.CocaLeaf;
import me.rich.nc.drug.cocaine.CocaSeed;
import me.rich.nc.drug.cocaine.Cocaine;
import me.rich.nc.drug.heroin.Heroin;
import me.rich.nc.drug.heroin.Morphine;
import me.rich.nc.drug.heroin.OpiumSap;
import me.rich.nc.drug.heroin.Pod;
import me.rich.nc.drug.heroin.PoppySeed;
import me.rich.nc.drug.paraphenalia.Bong;
import me.rich.nc.drug.paraphenalia.Fertilizer;
import me.rich.nc.drug.paraphenalia.Needle;
import me.rich.nc.drug.paraphenalia.Pipe;
import me.rich.nc.drug.paraphenalia.UsedNeedle;
import me.rich.nc.drug.weed.Bud;
import me.rich.nc.drug.weed.MarijuanaSeed;
import me.rich.nc.drug.weed.Weed;

import org.getspout.spoutapi.material.CustomItem;

public class CustomItems {

	private CocaSeed cocaSeed;
	private CocaLeaf cocaLeaf;
	private Alkaloids alkaloids;
	public Cocaine cocaine;
	
	private PoppySeed poppySeed;
	private Pod pod;
	private OpiumSap opiumSap;
	private Morphine morphine;
	private Heroin heroin;
	
	private MarijuanaSeed marijuanaSeed;
	public Bud bud;
	private Weed weed;
	
	private Bong bong;
	private Fertilizer fertilizer;
	private Needle needle;
	private UsedNeedle usedNeedle;
	private Pipe pipe;
	
	private Map<String, CustomItem> itemMap;
	
	public CustomItems(NoseCandyPlugin plugin) {
		this.itemMap = new HashMap<String, CustomItem>();
		this.loadItems(plugin);
	}
	
	public void loadItems(NoseCandyPlugin plugin) {
		cocaSeed = new CocaSeed("");
		this.itemMap.put("cocaseed", this.cocaSeed);
		cocaLeaf = new CocaLeaf("");
		this.itemMap.put("cocaleaf", this.cocaLeaf);
		alkaloids = new Alkaloids("");
		this.itemMap.put("alkaloids", this.alkaloids);
		cocaine = new Cocaine("https://dl.dropbox.com/u/86467984/NoseCandy/Image/cocaine.png");
		this.itemMap.put("cocaine", this.cocaine);
		
		poppySeed = new PoppySeed("");
		this.itemMap.put("poppyseed", this.poppySeed);
		pod = new Pod("");
		this.itemMap.put("pod", this.pod);
		opiumSap = new OpiumSap("");
		this.itemMap.put("opiumsap", this.opiumSap);
		morphine = new Morphine("");
		this.itemMap.put("morphine", this.morphine);
		heroin = new Heroin("");
		this.itemMap.put("heroin", this.heroin);
		
		marijuanaSeed = new MarijuanaSeed("");
		this.itemMap.put("marijuanaseed", this.marijuanaSeed);
		bud = new Bud("https://dl.dropbox.com/u/86467984/NoseCandy/Image/bud.png");
		this.itemMap.put("bud", this.bud);
		weed = new Weed("");
		this.itemMap.put("weed", this.weed);
		
		bong = new Bong("");
		this.itemMap.put("bong", this.bong);
		fertilizer = new Fertilizer("");
		this.itemMap.put("fertilizer", this.fertilizer);
		needle = new Needle("");
		this.itemMap.put("needle", this.needle);
		usedNeedle = new UsedNeedle("");
		this.itemMap.put("usedneedle", this.usedNeedle);
		pipe = new Pipe("");
		this.itemMap.put("pipe", this.pipe);
	}
	
	public void loadRecipes() {
		
	}
	
	public CustomItem getCustomItem(String name) {
		if (this.itemMap.containsKey(name)) {
			return this.itemMap.get(name);
		}
		return null;
	}
}
