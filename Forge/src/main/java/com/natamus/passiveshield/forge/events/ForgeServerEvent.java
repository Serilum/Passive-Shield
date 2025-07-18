package com.natamus.passiveshield.forge.events;

import com.natamus.passiveshield.events.ServerEvent;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeServerEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeServerEvent.class);

		LivingHurtEvent.BUS.addListener(ForgeServerEvent::onEntityDamageTaken);
	}

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