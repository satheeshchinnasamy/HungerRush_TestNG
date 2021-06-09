package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class Inventory_Page extends CommonFunctions{
	
	@FindBy(xpath="//*[@id='divInventoryHeader']//following::h1[contains(text(),'Inventory Managemen')]")
	public static WebElement inventory_page;

	public Inventory_Page() {
		PageFactory.initElements(driver, this);
	}
	
}
