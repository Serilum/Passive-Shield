package com.natamus.passiveshield.neoforge.events;

import com.natamus.passiveshield.events.ClientEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT)
public class NeoForgeClientEvent {
	@SubscribeEvent
	public static void onHandRender(RenderHandEvent e) {
		if (!ClientEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			e.setCanceled(true);
		}
	}
}