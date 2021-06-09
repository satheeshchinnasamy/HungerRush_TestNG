package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class Menu_Page extends CommonFunctions{
	
	@FindBy(xpath="//h5[contains(text(),'Menu')]")
	public static WebElement menu;
	
	@FindBy(xpath="//mat-select[@id='mat-select-0']")
	public static WebElement storesdropdown;
	
	@FindBy(xpath="//span[contains(text(),'Ly Install')]")
	public static WebElement LyInstall;
	
	@FindBy(xpath="//span[contains(text(),'Add Menu')]")
	public static WebElement addmenu;
	
	@FindBy(xpath="//li[contains(text(),'Group')]")
	public static WebElement group;
	
	@FindBy(xpath="//span[contains(text(),'Add Group')]")
	public static WebElement addgroup;
	
	@FindBy(xpath="//span[contains(text(),'Delete Group')]")
	public static WebElement deletegroup;
	
	@FindBy(xpath="//p[contains(text(),'Add Group')]//following::input[@formcontrolname='groupName']")
	public static WebElement groupname;
	
	@FindBy(xpath="//p[contains(text(),'Add Group')]//following::input[@formcontrolname='buttonName']")
	public static WebElement buttonname;
	
	@FindBy(xpath="//section[@class='mat-modal-buttons']//span[contains(text(),'Add')]")
	public static WebElement add;
	
	@FindBy(xpath="//section[@class='mat-modal-buttons']//span[contains(text(),'cancel')]")
	public static WebElement cancel;
	
	@FindBy(xpath="//li[contains(text(),'View Changes / Publish to Store')]")
	public static WebElement viewchanges;
	@FindBy(xpath="//td[contains(text(),' TEST1 ')]//preceding::div[1]")
	public static WebElement checkbox;
	@FindBy(xpath="//span[contains(text(),'Publish changes')]")
	public static WebElement publish_Changes;
	@FindBy(xpath="//h1[normalize-space()='Menu Editor']")
	public static WebElement menueditor;
	
	public Menu_Page() {
		PageFactory.initElements(driver, this);
	}

	public void ClickingMenuObjects(WebElement menuobjects) {
		menuobjects.click();
		
	}
	public void EnteringNames(String grpName, String btnName) {
		groupname.sendKeys(grpName);
		buttonname.sendKeys(btnName);
		
	}
}
