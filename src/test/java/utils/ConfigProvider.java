package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigProvider class is the util class used to read the properties from the Application.properties file
 * @author Avinash
 */
public class ConfigProvider {
	static Properties properties = new Properties();

	/**
	 * 
	 * @param propertyName
	 * @return property value
	 * @throws IOException
	 * getProperty method extracts the value for a particular key from the application.properties file
	 */
	public static String getProperty(String propertyName) throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//Application.properties");
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return properties.getProperty(propertyName);
	}
}

