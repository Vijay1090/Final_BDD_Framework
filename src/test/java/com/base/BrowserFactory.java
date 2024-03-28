package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.utils.PropertyFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	WebDriver driver;
	DriverManager driverManager = new DriverManager();
	static PropertyFileReader propertyFileReader = new PropertyFileReader();

	public void openBrowser() {
		String browser = propertyFileReader.getProperty("execution.browser");
		if (browser.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-javascript");
			options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-notifications");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driverManager.setDriver(driver);
		driverManager.setCommonActions(driverManager);
		//driverManager.getDriver().
		
		DriverManager.getDriver().navigate()
				.to(propertyFileReader.getProperty("base.url"));
		DriverManager.getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(10));
	}

	public void closeBrowser() {
		DriverManager.getDriver().quit();
	}

	
}
