package com.natamus.passiveshield.forge.events;

import com.natamus.passiveshield.events.ServerEvent;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeServerEvent {
	@SubscribeEvent
	public void onEntityDamageTaken(LivingHurtEvent e) {
		Entity entity = e.getEntity();

		float damageAmount = e.getAmount();
		float newAmount = ServerEvent.onEntityDamageTaken(entity.getCommandSenderWorld(), entity, e.getSource(), damageAmount);

		if (newAmount != damageAmount) {
			e.setAmount(newAmount);
		}
	}
}