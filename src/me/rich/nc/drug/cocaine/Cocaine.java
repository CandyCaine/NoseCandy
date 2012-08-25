package me.rich.nc.drug.cocaine;

import me.rich.nc.NoseCandyPlugin;
import me.rich.nc.util.EffectFactory;

import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Cocaine extends GenericCustomItem {

	public static final String name = "Cocaine";
	
	public Cocaine(String texture) {
		super(NoseCandyPlugin.getInstance(), name, texture);
	}
	
	@Override
	public boolean onItemInteract(SpoutPlayer player, SpoutBlock block, BlockFace face) {
		EffectFactory.getInstance().applyCocaineEffect(player);
		
		SpoutItemStack stack = new SpoutItemStack(player.getItemInHand());
		if (stack.getAmount() == 1) {
			player.setItemInHand(new ItemStack(0));
		} else {
			player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
		}
		
		return true;
	}
}
