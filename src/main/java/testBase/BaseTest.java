package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.ActionEngine;
import utils.PropertiesOperations;
import utils.StartDocker;
import utils.StopDocker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest extends ActionEngine{

	

	/*
	 * @BeforeTest public void setupDriver(ITestContext ctx) throws
	 * MalformedURLException { // BROWSER => chrome / firefox // HUB_HOST =>
	 * localhost / 10.0.1.3 / hostname
	 * 
	 * String host = "localhost"; DesiredCapabilities dc; dc = new
	 * DesiredCapabilities();
	 * DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
	 * 
	 * if (System.getProperty("BROWSER") != null &&
	 * System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
	 * WebDriverManager.firefoxdriver().setup(); dc.setCapability("browserName",
	 * "firefox"); } else { WebDriverManager.chromedriver().setup();
	 * //dc.setCapability("browserName", "chrome");
	 * dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	 * //dc.setCapability(CapabilityType.BROWSER_NAME, "IE");
	 * System.out.println("CHROME CAPABILITY IS SET!!!"); }
	 * 
	 * if (System.getProperty("HUB_HOST") != null) { host =
	 * System.getProperty("HUB_HOST"); }
	 * 
	 * String testName = ctx.getCurrentXmlTest().getName();
	 * System.out.println("testName:" + testName); String completeUrl = "http://" +
	 * host + ":4444/wd/hub"; System.out.println("completeUrl:" + completeUrl);
	 * dc.setCapability("name", testName); this.driver = new RemoteWebDriver(new
	 * URL(completeUrl), dc);
	 * 
	 * }
	 * 
	 * @AfterTest public void quitDriver() { this.driver.quit(); }
	 */

	
	

	
	
	
	
	BrowserFactory bf = new BrowserFactory();

	@BeforeSuite
	public void startDocker() throws IOException, InterruptedException {
		new StartDocker().startDockerScale() ;
	}
	
	@AfterSuite
	public void stopDocker() throws IOException, InterruptedException {
		new StopDocker().stopDockerDeleteFile();
	}
	
	@BeforeTest
	public void LaunchApplication() throws Exception {
		
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = 	PropertiesOperations.getPropertyValueByKey("url");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(url);

	}
	
	 

	@AfterTest
	public void tearDown() throws IOException, InterruptedException {
		DriverFactory.getInstance().closeBrowser();
		
	}
}
