package com.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class DriverManager {

	static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	private static CommonActions commonActions;
	private static Scenario scenario;

	public void setDriver(WebDriver driver) {
		webDriver.set(driver);
		
	}

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	public void setCommonActions(DriverManager driver) {
		commonActions = new CommonActions(driver);
	}

	public static CommonActions getCommonActions() {
		return commonActions;
	}

	public static Scenario getScenario() {
		return scenario;
	}

	public static void setScenario(Scenario scenario) {
		DriverManager.scenario = scenario;
	}

}
