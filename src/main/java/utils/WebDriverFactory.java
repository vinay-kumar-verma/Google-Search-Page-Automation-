package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	
	public static WebDriver initDriver(String browser) {
        
	    WebDriver driver;
	    
        switch (browser) {
        
            case "firefox":
            	WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
            	WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
            	WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        
        driver.manage().window().maximize();
        return driver;
    }
	
}
