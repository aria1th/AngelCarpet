package aria1th.angelcarpet.carpet;

import carpet.settings.Rule;

import static carpet.settings.RuleCategory.*;

public class CarpetExtensionSettings {
	@Rule(
		desc = "Bonemealing Cobblestone will convert it into Calcite",
		category = { FEATURE, SURVIVAL}
	)
	public static boolean renewableCalcite = false;
}