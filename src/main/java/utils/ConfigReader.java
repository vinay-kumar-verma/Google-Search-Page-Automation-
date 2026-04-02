package utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

	
	private static Properties properties = new Properties();
	
	public static void readConfig()
	{
		try 
		{
			FileReader file = new FileReader("C:\\Users\\2408321\\eclipse-workspace\\MiniProjectSelenium\\src\\test\\resources\\config.properties");
			properties.load(file);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static String getPropertyValue(String key)
	{
		
	  return properties.getProperty(key);	
	}
	
}


