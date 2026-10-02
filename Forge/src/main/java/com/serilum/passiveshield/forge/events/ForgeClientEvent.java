package com.serilum.passiveshield.forge.events;

import com.serilum.passiveshield.events.ClientEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeClientEvent {
	@SubscribeEvent
	public static void onHandRender(RenderHandEvent e) {
		if (!ClientEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			e.setCanceled(true);
		}
	}
}