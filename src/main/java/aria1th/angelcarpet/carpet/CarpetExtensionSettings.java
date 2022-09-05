package aria1th.angelcarpet.carpet;

import carpet.settings.Rule;

import static carpet.settings.RuleCategory.*;

public class CarpetExtensionSettings {
	@Rule(
		desc = "Bonemealing Cobblestone will convert it into Calcite",
		category = { FEATURE, SURVIVAL}
	)
	public static boolean renewableCalcite = false;
	@Rule(
		desc = "Introduce allay duping behavior",
		category = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean allayDuping = false;
	@Rule(
		desc = "Introduce allay duping behavior with holding Items",
		category = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean allayDupingWithItems = false;
	@Rule(
		desc = "Sheep does not freeze in powder snow",
		category = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean warmSheep = false;
}