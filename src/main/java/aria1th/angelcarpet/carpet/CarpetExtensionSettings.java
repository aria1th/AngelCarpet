package aria1th.angelcarpet.carpet;

import carpet.api.settings.Rule;

import static carpet.api.settings.RuleCategory.*;

public class CarpetExtensionSettings {
	@Rule(
		categories = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean renewableCalcite = false;
	@Rule(
		categories = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean warmSheep = false;
	// sheeps don't freeze in powder snow
	@Rule(
		categories = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean plantableWitherRoseOnNetherBricks = false;
	// wither roses can be planted on nether bricks and red variants

	// auto trade with villagers
	@Rule(
		categories = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean autoTrade = false;

	// auto trade with villagers with limit, if option is true, autoTrade will be limited as usual
	@Rule(
		categories = {FEATURE, SURVIVAL, EXPERIMENTAL}
	)
	public static boolean autoTradeLimit = false;
}