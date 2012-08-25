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
		this.removeAllEffects(player);
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HUNGER, 1200, 2));
	}

	public void applyHivEffect(Player player) {
		this.removeAllEffects(player);
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 1200, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 1200, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HUNGER, 1200, 2));
	}

	public void applyCocaineEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.SPEED, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.FAST_DIGGING, 600, 3));
	}

	public void applyCocaineAddictEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW_DIGGING, 600, 3));
	}

	public void applyWeedEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HUNGER, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 1));
	}

	public void applyWeedAddictEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HUNGER, 600, 1));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW_DIGGING, 600, 2));
	}

	public void applyHeroinEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.BLINDNESS, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW, 600, 4));
		player.addPotionEffect(this.createEffect(PotionEffectType.SLOW_DIGGING, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.WEAKNESS, 300, 1));
	}

	public void applyHeroinAddictEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.WEAKNESS, 600, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 600, 3));
	}

	public void applyMorphineEffect(Player player) {
		player.addPotionEffect(this.createEffect(PotionEffectType.CONFUSION, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 3));
		player.addPotionEffect(this.createEffect(PotionEffectType.HEAL, 200, 2));
	}

	public void removeAllEffects(Player player) {
		for (PotionEffect effect : player.getActivePotionEffects()) {
			player.removePotionEffect(effect.getType());
		}
	}

	public void removeAllNegativeEffects(Player player) {
		for (PotionEffect effect : player.getActivePotionEffects()) {
			if (effect.getType() == PotionEffectType.BLINDNESS || effect.getType() == PotionEffectType.BLINDNESS || effect.getType() == PotionEffectType.CONFUSION
					|| effect.getType() == PotionEffectType.HARM || effect.getType() == PotionEffectType.HUNGER || effect.getType() == PotionEffectType.POISON
					|| effect.getType() == PotionEffectType.SLOW || effect.getType() == PotionEffectType.SLOW_DIGGING || effect.getType() == PotionEffectType.WEAKNESS) {
				player.removePotionEffect(effect.getType());
			}
		}
	}

	public void removeAllPositiveEffects(Player player) {
		for (PotionEffect effect : player.getActivePotionEffects()) {
			if (effect.getType() == PotionEffectType.DAMAGE_RESISTANCE || effect.getType() == PotionEffectType.DAMAGE_RESISTANCE || effect.getType() == PotionEffectType.FAST_DIGGING
					|| effect.getType() == PotionEffectType.FIRE_RESISTANCE || effect.getType() == PotionEffectType.HEAL || effect.getType() == PotionEffectType.INCREASE_DAMAGE
					|| effect.getType() == PotionEffectType.JUMP || effect.getType() == PotionEffectType.REGENERATION || effect.getType() == PotionEffectType.SPEED
					|| effect.getType() == PotionEffectType.WATER_BREATHING) {
				player.removePotionEffect(effect.getType());
			}
		}
	}
}
