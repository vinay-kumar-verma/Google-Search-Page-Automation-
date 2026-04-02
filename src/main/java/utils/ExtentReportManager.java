package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	
	private static ExtentReports extent;
    private static ExtentTest test;
    
    public static ExtentReports getExtentReport() {
        if (extent == null) {
        	
            String reportPath = "C:\\Users\\2408321\\eclipse-workspace\\MiniProjectSelenium\\Report"+ "ExtentReport_" + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
    
    public static ExtentTest startTest(String testName) {
        test = getExtentReport().createTest(testName);
        return test;
    }
    
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }

  }
}
