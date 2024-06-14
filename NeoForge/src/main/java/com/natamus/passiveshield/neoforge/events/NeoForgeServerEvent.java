package com.natamus.passiveshield.neoforge.events;

import com.natamus.passiveshield.events.ServerEvent;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeServerEvent {
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