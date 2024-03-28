package com.testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = ".\\src\\test\\resources\\features", glue = {
		"com.stepdefinations",}, plugin = {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				// "html:target/cucumber-reports/cucumber-pretty.html",
				"rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags = "")

public class APITestRunner<CucumberFeatureWrapper> {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass
	public void beforeClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "scenarios", description = "Scenario Name: ")
	public void runScenario(PickleWrapper pickleEvent,
			CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	}

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass
	public void afterClass() {
		testNGCucumberRunner.finish();
	}
}
