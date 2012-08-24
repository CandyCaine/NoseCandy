package me.rich.nc.util;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectFactory {
	private static EffectFactory instance = new EffectFactory();
	
	public static EffectFactory getInstance() {
		return instance;
	}
	
	private EffectFactory() {
		
	}
	
	public PotionEffect createEffect(PotionEffectType type, int duration, int amplifier) {
		return new PotionEffect(type, duration, amplifier);
	}
	
	public void applyHepatitisEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HUNGER, 1200, 2));
	}
	
	public void applyCocaineEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.SPEED, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.FAST_DIGGING, 600, 3));
	}
	
	public void applyWeedEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HUNGER, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 1));
	}
	
	public void applyHeroinEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.BLINDNESS, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 4));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW_DIGGING, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.WEAKNESS, 300, 1));
	}
	
	public void applyMorphineEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HEAL, 200, 2));
	}
}
