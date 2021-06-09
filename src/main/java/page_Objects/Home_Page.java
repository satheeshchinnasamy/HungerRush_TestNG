package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class Home_Page extends CommonFunctions{
	
	@FindBy(id="dashAnchor")
	public  WebElement dashboard;
	
	@FindBy(id="rptAnchor")
	public WebElement reports;
	
	@FindBy(id="manageAnchor")
	public  WebElement manage;
	
	@FindBy(id="peopleAnchor")
	public static WebElement people;
	
	@FindBy(id="communicateAnchor")
	public static WebElement communicate;
	
	@FindBy(id="invAnchor")
	public static WebElement inventory;
	
	@FindBy(id="lySBAnchor")
	public static WebElement sitedesigner;
	
	@FindBy(id="displayAnchor")
	public static WebElement display;
	
	@FindBy(id="sysOnlyAnchor")
	public static WebElement hungerRush;
	
	
	public Home_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void HomeOptions(WebElement pagename) {
		
		pagename.click();
	}
	
}
