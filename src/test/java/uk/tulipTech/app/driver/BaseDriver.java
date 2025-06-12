package uk.tulipTech.app.driver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {

	public static WebDriver driver;


	public static String loginPageUrl = "https://dev.stucommunify.co.uk/login";

	@BeforeSuite
	public WebDriver setup() throws Exception {

		String browser = "chrome";

		// Check if it is 'firefoxx'
		if (browser.equalsIgnoreCase("firefox")) {
			// set path to firefox
			driver = new FirefoxDriver();

		}
		// Check if it is 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chrome
			driver = new ChromeDriver();

		}
		// Check if it is 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			// set path to Edge
			driver = new EdgeDriver();

		} else {
			// If no browser is passed throw exception
			throw new Exception("Incorrect Browsere");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Starting Maximize Window
		driver.manage().window().maximize();
		driver.get(loginPageUrl);
		return driver;
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
	    if (ITestResult.FAILURE == result.getStatus()) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(source, new File("screenshots/" + result.getName() + ".png"));
	            System.out.println("Screenshot taken for failed test: " + result.getName());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();

	}

}
