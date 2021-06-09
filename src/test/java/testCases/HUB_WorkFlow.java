package testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common_Functions.CommonFunctions;
import page_Objects.Communicate_Page;
import page_Objects.Display_Page;
import page_Objects.Home_Page;
import page_Objects.HungerRushOnly_Page;
import page_Objects.Inventory_Page;
import page_Objects.Menu_Page;
import page_Objects.People_Page;
import page_Objects.Reports_Page;

public class HUB_WorkFlow extends CommonFunctions{

	
	Home_Page home;
	Reports_Page report;
	Menu_Page menupa;
	Communicate_Page commu;
	
	@Test(priority=0)
	public void OpentheReportPage() throws InterruptedException{
		logger= extentReport.createTest("Report Validation");
		home=new Home_Page();
		Thread.sleep(3000);
		home.HomeOptions(home.reports);
		String title=driver.getTitle();
		String actualtitle="HungerRush HUB | Reports";
		Assert.assertEquals(title, actualtitle);
		}

	@Test(priority=1)
	public void SelectSingleStore() throws InterruptedException {
		logger= extentReport.createTest("Selecting the store");
		report=new Reports_Page();
		report.SelecetSales();
		Thread.sleep(5000);
		String text=report.singleStore.getText();
		String actualText="Daily Performance - Single Store";
		Assert.assertEquals(text, actualText);
		}
	
	@Test(priority=2)
	public void ViewReport() throws InterruptedException {
		logger= extentReport.createTest("Viewing the Report");
		report=new Reports_Page();
		report.ViewReport("Jan 01 2021", "Mar 31 2021");
		Thread.sleep(3000);
		String text=report.reportsOption.getText();
		String actualText="Report Options";
		Assert.assertEquals(text, actualText);
	}

	@Test(priority=3)
	public void Manage() {
		logger= extentReport.createTest("Menu Validation");
		home=new Home_Page();
		menupa=new Menu_Page();
		home.HomeOptions(home.manage);
		menupa.ClickingMenuObjects(menupa.menu);
		String title=driver.getTitle();
		Assert.assertEquals(title, "HungerRush HUB | HUB");
	}

	/*
	 * @Test(priority=4) public void SelecttheStore() { logger=
	 * extentReport.createTest("Storelist Validation");
	 * menupa=new Menu_Page();
	 * menupa.ClickingMenuObjects(menupa.storesdropdown);
	 * menupa.ClickingMenuObjects(menupa.LyInstall); String
	 * text=menupa.addmenu.getText(); String actualText="Add Menu";
	 * Assert.assertEquals(actualText, text); }
	 * 
	 * @Test(priority=5) public void AddGroup() throws InterruptedException {
	 * logger= extentReport.createTest("Add Group Validation");
	 * menupa=new Menu_Page();
	 * menupa.ClickingMenuObjects(menupa.group);
	 * menupa.ClickingMenuObjects(menupa.addgroup); Thread.sleep(7000);
	 * menupa.EnteringNames("aaaaaaa", "bbbbbbb");
	 * menupa.ClickingMenuObjects(menupa.add);
	 * menupa.ClickingMenuObjects(menupa.viewchanges);
	 * menupa.ClickingMenuObjects(menupa.checkbox);
	 * menupa.ClickingMenuObjects(menupa.publish_Changes);
	 * 
	 * }
	 */
	@Test(priority=6)	
	public void Communicate() {
		
		logger= extentReport.createTest("Communicate Validation");
		logger.log(Status.INFO, "Communicate test started");
		home=new Home_Page();
		commu=new Communicate_Page();
		
		home.HomeOptions(home.communicate);
		commu.documents.click();
		String doc_page=commu.doc_content.getText();
		String actual_doc_page="Documents";
		Assert.assertEquals(actual_doc_page, doc_page);
		}
	
	@Test(priority=7)
	public void People() {
		logger= extentReport.createTest("Add Group Validation");
		People_Page peoplep=new People_Page();
		home=new Home_Page();
		
		home.HomeOptions(home.people);
		peoplep.summary.click();
		String review=peoplep.timrclock.getText();
		String actualreview="Weekly Time Clock Review";
		Assert.assertEquals(actualreview, review);
	}

	@Test(priority=8)
	public void Inventory() throws IOException {
		logger= extentReport.createTest("Inventory Validation");
		Inventory_Page invent=new Inventory_Page();
		home=new Home_Page();
		
		home.HomeOptions(home.inventory);
		String invent_page=invent.inventory_page.getText();
		String actual_invent_page="Inventory Management";
		Assert.assertEquals(actual_invent_page, invent_page);
	
	}

	@Test(priority=9)
	public void Display() {
		logger= extentReport.createTest("Display Validation");
		Display_Page disob=new Display_Page();
		home=new Home_Page();
		
		home.HomeOptions(home.display);
		disob.Drive.click();
		String tripdetails=disob.trip.getText();
		String actual_tripdetails="Current Trip";
		Assert.assertEquals(actual_tripdetails, tripdetails);

	}

	@Test(priority=10)
	public void SiteDesigner() {
		logger= extentReport.createTest("SiteDesigner Validation");
		home=new Home_Page();
		
		home.HomeOptions(home.sitedesigner);
	}
	
	@Test(priority=9)
	public void HungerRushOnly() throws IOException {
		logger= extentReport.createTest("HungerRush Validation");
		HungerRushOnly_Page hung=new HungerRushOnly_Page();
		//home=new Home_Page();
		
		home.hungerRush.click();
		hung.allCustomers.click();
		String cus_name=hung.customertitle.getText();
		String actual_cus_name="Reds Pizza";
		Assert.assertEquals(actual_cus_name, cus_name);
		}

}