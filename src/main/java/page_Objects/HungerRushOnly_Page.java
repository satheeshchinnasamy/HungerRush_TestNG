package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class HungerRushOnly_Page extends CommonFunctions{
	
	@FindBy(xpath="//h5[normalize-space()='All Customers']")
	public static WebElement allCustomers;
	@FindBy(xpath="//td[contains(@title,'Reds Pizza')]")
	public static WebElement customertitle;
	
	public HungerRushOnly_Page() {
		PageFactory.initElements(driver, this);
	}
	
}
