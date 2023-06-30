package aria1th.angelcarpet.carpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.utils.Translations;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class AngelServer implements CarpetExtension, ModInitializer {
	public static final String VERSION = "1.0.1";
	public static final Logger LOGGER = LogManager.getLogger("AngelCarpet");

	@Override
	public String version() {
		return "AngelCarpet" + VERSION;
	}

	@Override
	public void onInitialize() {
		CarpetServer.manageExtension(new AngelServer());

	}
	@Override
	public void onGameStarted() {
		LOGGER.debug("Angel carpet %s started!".formatted(VERSION));
		CarpetServer.settingsManager.parseSettingsClass(CarpetExtensionSettings.class);
	}

	@Override
	public Map<String, String> canHasTranslations(String lang) {
		return GeneralCarpetTranslations.getTranslationFromResourcePath(lang);
	}
}