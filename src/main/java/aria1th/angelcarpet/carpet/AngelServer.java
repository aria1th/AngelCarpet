package aria1th.angelcarpet.carpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AngelServer implements CarpetExtension, ModInitializer {
	public static final String VERSION = "1.0.0";
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
}