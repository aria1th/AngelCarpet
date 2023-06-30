package aria1th.angelcarpet.carpet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

public class GeneralCarpetTranslations {
	public static Map<String, String> getTranslationFromResourcePath(String baseModName, String lang)
	{
		InputStream langFile = GeneralCarpetTranslations.class.getClassLoader().getResourceAsStream("assets/%s/lang/%s.json".formatted(baseModName, lang));
		if (langFile == null) {
			// we don't have that language
			return Collections.emptyMap();
		}
		String jsonData;
		try {
			jsonData = IOUtils.toString(langFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
			return Collections.emptyMap();
		}
		Gson gson = new GsonBuilder().setLenient().create(); // lenient allows for comments
		return gson.fromJson(jsonData, new TypeToken<Map<String, String>>() {}.getType());
	}

	public static Map<String, String> getTranslationFromResourcePath(String lang)
	{
		return getTranslationFromResourcePath("angelcarpet", lang);
	}
}
