package com.natamus.passiveshield;

import com.mojang.blaze3d.vertex.PoseStack;
import com.natamus.collective.fabric.callbacks.CollectiveRenderEvents;
import com.natamus.passiveshield.events.ClientEvent;
import net.fabricmc.api.ClientModInitializer;
import com.natamus.passiveshield.util.Reference;
import com.natamus.collective.check.ShouldLoadCheck;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		registerEvents();
	}

	private void registerEvents() {
		CollectiveRenderEvents.RENDER_SPECIFIC_HAND.register((InteractionHand interactionHand, PoseStack poseStack, ItemStack itemStack) -> {
			return ClientEvent.onHandRender(interactionHand, poseStack, itemStack);
		});
	}
}
