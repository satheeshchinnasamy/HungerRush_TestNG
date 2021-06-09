package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;


public class People_Page extends CommonFunctions{
	
	@FindBy(xpath="//h5[normalize-space()='Summary']")
	public static WebElement summary;
	@FindBy(xpath="//div[@id='main-content']//h2[contains(text(),'Weekly Time Clock Review')]")
	public static WebElement timrclock;
	

	public People_Page() {
		PageFactory.initElements(driver, this);

	}
}