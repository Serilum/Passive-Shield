package com.natamus.passiveshield.events;

import com.natamus.collective.services.Services;
import com.natamus.passiveshield.config.ConfigHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ServerEvent {
	public static float onEntityDamageTaken(Level world, Entity entity, DamageSource damageSource, float damageAmount) {
		if (world.isClientSide) {
			return damageAmount;
		}

		if (entity instanceof Player) {
			Player player = (Player)entity;
			if (!(Services.TOOLFUNCTIONS.isShield(player.getMainHandItem()))) {
				if (!(Services.TOOLFUNCTIONS.isShield(player.getOffhandItem()))) {
					return damageAmount;
				}
			}
			
			double modifier = 1.0 -ConfigHandler.passiveShieldPercentageDamageNegated;
			return (float)(damageAmount*modifier);
		}

		return damageAmount;
	}
}