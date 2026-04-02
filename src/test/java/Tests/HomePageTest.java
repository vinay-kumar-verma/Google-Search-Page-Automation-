package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.GoogleHomePage;
import Pages.GoogleSearchPage;
import utils.ScreenshotUtil;

public class HomePageTest extends BaseTest{
	
  @Test(priority = 1)
  public void countAllLinks() {
	  
	  GoogleHomePage homepage = new GoogleHomePage(driver);
	  System.out.println("Total Links present on HomePage is: " + homepage.getLinkCount());
  }
  
  
  //Print all the link names. 
  
  @Test(priority = 2)
  public void displayLinkNames() {
	  
	  
	  GoogleHomePage homepage = new GoogleHomePage(driver);
	  homepage.printLinkNames();
	  System.out.println();
  }
  
  
  //Type "Cognizant" in search text box. 
  
  @Test(priority = 3)
  public void typeCognizant() throws InterruptedException {
	  
	  GoogleHomePage homepage = new GoogleHomePage(driver);
	  homepage.typeCognizantInSearchBox();
	  
	  ScreenshotUtil.takeScreenshot(driver, "search_results_page");
  }
  
  @Test(priority = 4)
  public void sizeOfSearchResults() {
	  
	  GoogleHomePage homepage = new GoogleHomePage(driver);
	  System.out.println("Number of search suggestions displayed: " + homepage.sizeOfOptionsDisplayed());
	  System.out.println();
  }
  
//Find the number of search options displayed.   
  @Test(priority = 5)
  public void getSearchOptions() {
	  
	  GoogleHomePage homepage = new GoogleHomePage(driver);
	  
	  homepage.getSuggestionitems();
	  homepage.sizeOfOptionsDisplayed();
  }
  
  
//Click Google Search Button  
  @Test(priority = 6)
  public void clickGoogleSearchButton() throws InterruptedException {
	  GoogleHomePage homepage = new GoogleHomePage(driver);
	  homepage.clickSearchButton();
  }
  
  @Test(priority = 7)
  public void printResultStatCount() throws InterruptedException {
	  
	  GoogleSearchPage search = new GoogleSearchPage(driver);
	  search.countOfResultStats();
  }
  
  @Test(priority = 8)
  public void clickNews() throws InterruptedException {
	  
	  GoogleSearchPage search = new GoogleSearchPage(driver);
	  
	  search.clickNewsButton();
	  Thread.sleep(2000);
	  	  
  }
  
  @Test(priority = 9)
  public void printCountOfNewsResults() throws InterruptedException {
	  
	  GoogleSearchPage search = new GoogleSearchPage(driver);
	  
	  search.getCountOfNewsResults();
	  System.out.println();
	  
	  ScreenshotUtil.takeScreenshot(driver, "news_results_page");
	  	  
  }
  
  @Test(priority = 10)
  public void clickImages() throws InterruptedException {
	  
	  GoogleSearchPage search = new GoogleSearchPage(driver);
	  
	  search.clickImagesButton();
	  
	  ScreenshotUtil.takeScreenshot(driver, "images_results_page");
  }
  
  @Test(priority = 11)
  public void clickVideos() throws InterruptedException {
	  
	  GoogleSearchPage search = new GoogleSearchPage(driver);
	  
	  search.clickVideosButton();

	  ScreenshotUtil.takeScreenshot(driver, "videos_results_page");
  }
  
  @Test(priority = 12)
  public void printCountOfVideosResults() throws InterruptedException {
	  
	  GoogleSearchPage search = new GoogleSearchPage(driver);
	  
	  try {
		  search.getCountOfVideosResults();
		  System.out.println();
	  }catch(Exception e) {
		  System.out.println("No count displayed for 'Videos' tab.");
		  e.printStackTrace();
	  }
	 
	  	  
  }
  
}
