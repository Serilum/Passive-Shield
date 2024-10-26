package com.natamus.passiveshield.forge.events;

import com.natamus.passiveshield.events.ClientEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT)
public class ForgeClientEvent {
	@SubscribeEvent
	public void onHandRender(RenderHandEvent e) {
		if (!ClientEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			e.setCanceled(true);
		}
	}
}