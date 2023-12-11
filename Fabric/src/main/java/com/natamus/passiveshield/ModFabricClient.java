package com.natamus.passiveshield;

import com.mojang.blaze3d.vertex.PoseStack;
import com.natamus.collective.fabric.callbacks.CollectiveRenderEvents;
import com.natamus.passiveshield.events.ClientEvent;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerEvents();
	}

	private void registerEvents() {
		CollectiveRenderEvents.RENDER_SPECIFIC_HAND.register((InteractionHand interactionHand, PoseStack poseStack, ItemStack itemStack) -> {
			return ClientEvent.onHandRender(interactionHand, poseStack, itemStack);
		});
	}
}
