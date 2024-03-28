package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.DriverManager;

public class HomePage {

  private static Logger log = LoggerFactory.getLogger(HomePage.class);

  public HomePage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  private static String ADDRSS_PLACE_HOLDER = "//span[contains(text(),'%s')]";

  @FindBy(xpath = "//button[text()='ORDER ONLINE NOW']")
  private WebElement orderOnlineButton;

  @FindBy(xpath = "//input[@placeholder='Enter your delivery address']")
  private WebElement locateMePlaceHolder;

  @FindBy(xpath = "//input[@placeholder='Enter Area / Locality']")
  private WebElement enterAreaLocalityInputField;

  @FindBy(xpath = "//div[@class='esc-btn crss-icn-rght']/span")
  private WebElement escIconLocator;

  public void verifyUserIsOnHomePage() {
    DriverManager.getCommonActions().waitForTimeOutInSec(3);
    Assert.assertTrue(DriverManager.getCommonActions().isElementDisplayed(orderOnlineButton),
        "User Is NOT Navigated to HomePage. Please check the URL ");
    log.info("Verified that user is navigated to Home page");
    ExtentCucumberAdapter.addTestStepLog("Verified that user is navigated to Home page");
  }

  public void clickOnOrderOnlineButton() {
    orderOnlineButton.click();
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
  }

  public void clickOnLocateMe() {
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    DriverManager.getCommonActions().click(locateMePlaceHolder);
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
  }

  public void enterAreaText(String location) {
    DriverManager.getCommonActions().click(locateMePlaceHolder);
    DriverManager.getCommonActions().waitForTimeOutInSec(1);
    enterAreaLocalityInputField.sendKeys(location);
    DriverManager.getCommonActions().waitForTimeOutInSec(1);
    DriverManager.getCommonActions()
        .click(By.xpath(String.format(ADDRSS_PLACE_HOLDER, location.trim())));
    DriverManager.getCommonActions().waitForTimeOutInSec(1);
    // if (DriverManager.getCommonActions().isPresent(escIconLocator)) {
    // DriverManager.getCommonActions().click(escIconLocator);
    // }
  }
}
