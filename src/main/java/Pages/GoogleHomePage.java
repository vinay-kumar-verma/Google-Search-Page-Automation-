package Pages;

import java.util.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class GoogleHomePage {

	public GoogleHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
		
	//locating all the Links Present on the HomePage
	@FindBy(tagName = "a" ) 
	List<WebElement> allLinks;
	
	//Method to count all the links 
	public int getLinkCount() {
		return allLinks.size();
	}
	
	//Method to print all the Link Names
	public void printLinkNames() {
		for(WebElement x : allLinks) {
			String text = x.getText().trim();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
	}
	
	//locating the search box
	@FindBy(xpath = "//*[@id=\"APjFqb\"]")
	WebElement searchBox;
	
	//Type "Cognizant" in search text box.
	public void typeCognizantInSearchBox() throws InterruptedException {
		searchBox.sendKeys("Cognizant");
		Thread.sleep(3000);
	}
		
	
	//locating the all the search Results
	@FindBy(xpath = "//ul[@role = 'listbox']//li//div[@role='option']") List<WebElement> searchOptionsDisplayed;	
	
	//Find the number of search options displayed. 
	public void getSuggestionitems(){
		
		for(WebElement x : searchOptionsDisplayed) {
			String text = x.getText();
			System.out.println("search result: " + text);
		}
	}
	
	
	public int sizeOfOptionsDisplayed() {
		return searchOptionsDisplayed.size();
	}
	
	//Locate Search Button
	@FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]") WebElement SearchBtn;
	
	//Click Search Button
	public void clickSearchButton() throws InterruptedException {
		SearchBtn.sendKeys(Keys.ENTER);
		Thread.sleep(35000);
	}
	
	
	
}
