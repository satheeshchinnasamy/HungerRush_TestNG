package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions.CommonFunctions;

public class Reports_Page extends CommonFunctions {
	
	@FindBy(id="id_8")
	public static WebElement sales;
	@FindBy(xpath="//li[@data-displayname='Daily Performance - Single Store']")
	public static WebElement singleStore;
	@FindBy(id="from")
	public static WebElement from_Date;
	@FindBy(id="to")
	public static WebElement to_Date;
	@FindBy(id="storesDD")
	public static WebElement storelist;
	@FindBy(id="btnview")
	public static WebElement viewbutton;
	@FindBy(id="rptSection1Hdr")
	public static WebElement reportsOption;
	
	public Reports_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void SelecetSales() {
		sales.click();
	}

	public void SingleStore() {
		singleStore.click();
	}

	public void ViewReport(String fdate, String tdate) {
		
		from_Date.clear();
		from_Date.sendKeys(fdate);
		to_Date.clear();
		to_Date.sendKeys(tdate);
		storelist.click();
		viewbutton.click();
		

	}
}