package com.natamus.passiveshield.forge.events;

import com.natamus.passiveshield.events.ClientEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeClientEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeClientEvent.class);

		RenderHandEvent.BUS.addListener(ForgeClientEvent::onHandRender);
	}

	@SubscribeEvent
	public static boolean onHandRender(RenderHandEvent e) {
		if (!ClientEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			return true;
		}
		return false;
	}
}