package com.natamus.passiveshield.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.passiveshield.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean hideShieldWhenNotInUse = true;
	@Entry(min = 0.0, max = 1.0) public static double passiveShieldPercentageDamageNegated = 0.3333;

	public static void initConfig() {
		configMetaData.put("hideShieldWhenNotInUse", Arrays.asList(
			"When enabled, the shield will be hidden unless a player presses right-click."
		));
		configMetaData.put("passiveShieldPercentageDamageNegated", Arrays.asList(
			"The percentage of damage that will be negated when a player is hit while holding a shield that's not held high."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}