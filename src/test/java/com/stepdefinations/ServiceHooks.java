package com.stepdefinations;

import com.base.CommonActions;
import com.base.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ServiceHooks {

	@Before
	public void beforeSenario(Scenario scenario) {
		DriverManager.setScenario(scenario);
	}

	@After
	public void afterSenario(Scenario scenario) {
		// if (DriverManager.getScenario().isFailed()) {
		DriverManager.getCommonActions().topEmbedScreenshot();
		DriverManager.getCommonActions().bottomEmbedScreenshot();
//		CommonActions.topEmbedScreenshot();
//		CommonActions.bottomEmbedScreenshot();
		// BrowserFactory.closeBrowser();
		// }
	}

	// @BeforeStep
	// public void beforeSteps(Scenario scenario) {
	// CommonActions.embedScreenshot();
	// }
	//
	// @AfterStep
	// public void afterSteps(Scenario scenario) {
	// CommonActions.embedScreenshot();
	// }
}
