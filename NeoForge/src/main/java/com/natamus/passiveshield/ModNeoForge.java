package com.natamus.passiveshield;

import com.natamus.collective.check.RegisterMod;
import com.natamus.passiveshield.neoforge.config.IntegrateNeoForgeConfig;
import com.natamus.passiveshield.neoforge.events.NeoForgeClientEvent;
import com.natamus.passiveshield.neoforge.events.NeoForgeServerEvent;
import com.natamus.passiveshield.util.Reference;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	
	public ModNeoForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		IntegrateNeoForgeConfig.registerScreen(ModLoadingContext.get());

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		if (FMLEnvironment.dist.equals(Dist.CLIENT)) {
			NeoForge.EVENT_BUS.register(NeoForgeClientEvent.class);
		}
		NeoForge.EVENT_BUS.register(NeoForgeServerEvent.class);
	}

	private static void setGlobalConstants() {

	}
}