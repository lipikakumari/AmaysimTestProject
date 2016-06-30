package com.myAmaysim.base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBaseSetup {
	
	private WebDriver driver =null;
	static String driverPath = "/lib/chromedriver";

	public WebDriver getDriver() {
		return driver;
	}

	private static WebDriver initializeChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/"+ driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@BeforeMethod
	public void initializeTestBaseSetup() {
		try {
			driver=initializeChromeDriver("https://www.amaysim.com.au/my-account/my-amaysim/login");

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
