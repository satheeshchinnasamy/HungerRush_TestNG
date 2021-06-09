package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class Communicate_Page extends CommonFunctions{

	@FindBy(xpath="//h5[normalize-space()='Documents']")
	public static WebElement documents;
	@FindBy(xpath="//*[@id='MainRightContent']//following::h1[contains(text(),'Documents')]")
	public static WebElement doc_content;
	
	
	public Communicate_Page() {
		PageFactory.initElements(driver, this);
	}
}
