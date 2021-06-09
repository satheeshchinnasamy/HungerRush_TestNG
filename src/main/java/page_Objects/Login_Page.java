package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class Login_Page extends CommonFunctions {
	
	
	@FindBy(id="UserName")
	private WebElement username;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="newLogonButton")
	private WebElement loginbtn;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}

	public Home_Page Login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new Home_Page();
		
	}
}
