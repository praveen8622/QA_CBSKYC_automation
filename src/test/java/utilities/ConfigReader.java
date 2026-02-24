package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	public static Properties getProperties() {
		try {
			FileInputStream fis = new FileInputStream("src/main/java/resources/Config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
