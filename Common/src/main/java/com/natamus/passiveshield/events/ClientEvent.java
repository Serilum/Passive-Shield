package com.natamus.passiveshield.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.natamus.collective.services.Services;
import com.natamus.passiveshield.config.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class ClientEvent {
	private static final Minecraft mc = Minecraft.getInstance();

	public static boolean onHandRender(InteractionHand hand, PoseStack poseStack, ItemStack itemStack) {
		if (hand.equals(InteractionHand.OFF_HAND)) {
			if (ConfigHandler.hideShieldWhenNotInUse) {
				if (Services.TOOLFUNCTIONS.isShield(itemStack)) {
					ItemStack useItem = mc.player.getUseItem();
					return mc.player.isUsingItem() && Services.TOOLFUNCTIONS.isShield(useItem);
				}
			}
		}

		return true;
	}
}