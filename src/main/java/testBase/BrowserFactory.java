/**
 * Author: Prakash Narkhede
 * Blog: www.AutomationTalks.com
 * LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */
package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	// create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {
		RemoteWebDriver driver = null;
		// BROWSER => chrome / firefox
		// HUB_HOST => localhost / 10.0.1.3 / hostname

		String host = "localhost";
		DesiredCapabilities dc;
		dc = new DesiredCapabilities();
		// WebDriver driver = null;
		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dc.setCapability("browserName", "firefox");
		} else {
			WebDriverManager.chromedriver().setup();
			// dc.setCapability("browserName", "chrome");
			dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			// dc.setCapability(CapabilityType.BROWSER_NAME, "IE");
			System.out.println("CHROME CAPABILITY IS SET!!!");
		}

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		//String testName = ctx.getCurrentXmlTest().getName();
		//System.out.println("testName:" + testName);
		String completeUrl = "http://" + host + ":4444/wd/hub";
		System.out.println("completeUrl:" + completeUrl);
		//dc.setCapability("name", testName);
		driver = new RemoteWebDriver(new URL(completeUrl), dc);
		return driver;
	}

}
