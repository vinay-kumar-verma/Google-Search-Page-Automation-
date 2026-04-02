package Base;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ConfigReader;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;
import utils.WebDriverFactory;

public class BaseTest {

	protected WebDriver driver;
	protected ExtentTest test;
	
	@BeforeSuite
	public void startReport() 
	{
		ExtentReportManager.getExtentReport();
		
	}
	
	@BeforeTest
	public void setup() throws InterruptedException
	{		
		ConfigReader.readConfig();
		String Browser = ConfigReader.getPropertyValue("browser");
		driver = WebDriverFactory.initDriver(Browser);
		driver.get(ConfigReader.getPropertyValue("url"));
		System.out.println("browser url");
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void createTest(Method method) 
	{
		test = ExtentReportManager.startTest(method.getName());
	}
	
	@AfterMethod
    public void tearDown(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.SUCCESS) 
        {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.log(Status.PASS, result.getName() + " is passed");
            test.addScreenCaptureFromPath(screenshotPath);
        }
		
        if (ITestResult.FAILURE == result.getStatus()) 
        {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.log(Status.FAIL, result.getName() + " is failed");
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }
	
	@AfterTest
    public void tearDown() 
	{
        if (driver != null)
        {
            driver.quit();
        }	   
	}
 
 
	@AfterSuite
    public void endReport() 
    {
        ExtentReportManager.flushReport();
    }
	
	
 
}
