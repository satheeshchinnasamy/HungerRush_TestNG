package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class Display_Page extends CommonFunctions{
	
	@FindBy(xpath="//h5[normalize-space()='Drive']")
	public static WebElement Drive;
	@FindBy(xpath="//span[contains(text (),'Current Trip')]")
	public static WebElement trip;

	
	public  Display_Page() {
		PageFactory.initElements(driver, this);
	}

}
