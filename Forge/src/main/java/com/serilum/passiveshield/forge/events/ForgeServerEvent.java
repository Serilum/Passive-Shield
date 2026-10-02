package com.serilum.passiveshield.forge.events;

import com.serilum.passiveshield.events.ServerEvent;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeServerEvent {
	@SubscribeEvent
	public static void onEntityDamageTaken(LivingHurtEvent e) {
		Entity entity = e.getEntity();

		float damageAmount = e.getAmount();
		float newAmount = ServerEvent.onEntityDamageTaken(entity.level(), entity, e.getSource(), damageAmount);

		if (newAmount != damageAmount) {
			e.setAmount(newAmount);
		}
	}
}