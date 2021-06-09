package common_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import page_Objects.Home_Page;
import page_Objects.Login_Page;

public class CommonFunctions {

	public static Properties properties=null;
	public static WebDriver driver=null;
	public ExtentReports extentReport;
	public ExtentHtmlReporter htmlReport;
	public ExtentTest logger;
	Home_Page home;
	public Properties LoadProperty() throws IOException {

		FileInputStream inputstream = new FileInputStream("C:\\Users\\Satheesh Chinnasamy\\eclipse-workspace\\HungerRush\\src\\main\\java\\config\\config.properties");
		properties = new Properties();
		properties.load(inputstream);
		return properties;
	}

	public void LoginHUB() {
		
		Login_Page logino=new Login_Page();
		logino.Login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@BeforeSuite
	public void LaunchBrowser() throws IOException, InterruptedException {
		extentReport = new ExtentReports();
		htmlReport = new ExtentHtmlReporter("HungerTestReport.html");
		extentReport.attachReporter(htmlReport);

		LoadProperty();
		String url = properties.getProperty("url");
		String driverLocation = properties.getProperty("driverlocation");

		System.setProperty("Webdriver.chrome.driver", driverLocation);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginHUB();
	}

	public static String GetScreenShot(String screenshotname) throws IOException {
		String date = new SimpleDateFormat("ddmmyyyyhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + screenshotname + date + ".png";
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;
	}

	@AfterMethod
	public void Testresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test case failed " + result.getName());
			logger.log(Status.FAIL, "Test case failed " + result.getThrowable());
			String spath=CommonFunctions.GetScreenShot(result.getName());
			logger.addScreenCaptureFromPath(spath);
			}
	}

	@AfterSuite
	public void TearDown() {

		driver.quit();
		extentReport.flush();
	}
}
