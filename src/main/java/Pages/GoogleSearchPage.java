package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	public GoogleSearchPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id = "hdtb-tls")
	WebElement ToolsBtn;
	
	@FindBy(id = "result-stats")
	WebElement resultStats;
	
	public void countOfResultStats() throws InterruptedException {
		
		ToolsBtn.click();
		Thread.sleep(5000);
		
		String text = resultStats.getText();
		System.out.println("Search Results Count in Console: " + text);
		
	}
	
	@FindBy(linkText = "News")
	WebElement newsBtn;
	
	public void clickNewsButton() throws InterruptedException {
		newsBtn.click();
		Thread.sleep(3000);
	}
	
	public void getCountOfNewsResults() throws InterruptedException {
		
		ToolsBtn.click();
		Thread.sleep(2000);
		
		String text = resultStats.getText();
		System.out.println("News Results Count in Console: " + text);
		
	}
	
	@FindBy(linkText = "Images")
	WebElement ImageBtn;
	
	public void clickImagesButton() throws InterruptedException {
		ImageBtn.click();
		Thread.sleep(3000);
	}
	
	@FindBy(linkText = "Videos")
	WebElement VideoBtn;
	
	public void clickVideosButton() throws InterruptedException {
		VideoBtn.click();
		Thread.sleep(3000);
	}
	
public void getCountOfVideosResults() throws InterruptedException {
		
		ToolsBtn.click();
		Thread.sleep(2000);
		
		String text = resultStats.getText();
		System.out.println("Videos Results Count in Console: " + text);
		
	}

}
