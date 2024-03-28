package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.BaseTest;
import com.base.DriverManager;

public class CartPage extends BaseTest{
  private static Logger log = LoggerFactory.getLogger(CartPage.class);
  
  
 
  public CartPage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  private String PRODUCT_TEXT_CART_PLACEHOLDER =
      "//div[@class='cart-item']/descendant::span[contains(text(),'%s')]"; //div[@class='cart-item']/descendant::span[contains(text(),'Margherita')]

  private static String PRODUCT_PRICETEXT_PLACEHOLDER =
      "//div[@class='cart-item']/descendant::span[@class='rupee']";

  
  private static String  COMPLETE_YOUR_MEAL_ADD_BUTTON="//div[text()='%s']/ancestor::div[@class='upsell__img-wrpr']/following-sibling::div/div[text()='Add']";
  

  @FindBy(xpath = "//div[@class='sub-hdng']//span[@class='sub-hdng--lft']")
  private WebElement subHeadingText;
  
  @FindBy(xpath = "//div[@class='cart-item']/descendant::span[@class='rupee']") private WebElement eachProductTotalPrice;

  @FindBy(xpath = "//div[@class='sc-eTuwsz kiYUSk']//div[1]//span[@class='rupee']")
  private WebElement productSubToltalPriceText;
  

  @FindBy(xpath = "//button[@data-label='Place Order']")
  private WebElement placeOrderButton;

  @FindBy(xpath = "//input[@name='firstName']")
  private WebElement firstNameTextField;

  @FindBy(xpath = "//input[@name='lastName']")
  private WebElement lastNameTextField;

  @FindBy(xpath = "//input[@name='mobileNumber']")
  private WebElement mobileNumberTextField;

  @FindBy(xpath = "//input[@name='emailBox']")
  private WebElement emailBoxTextField;

  @FindBy(xpath = "//input[@name='addressBox']")
  private WebElement addressBoxTextField;

  @FindBy(xpath = "//input[@name='houseNumber']")
  private WebElement houseNumberTextField;

  @FindBy(xpath = "//input[@value='Save & Continue']")
  private WebElement saveContinueButton;

  public void verifyCartPage() {
    DriverManager.getCommonActions().waitForTimeOutInSec(5);
    Assert.assertTrue(DriverManager.getCommonActions().isElementDisplayed(subHeadingText),
        "User Is NOT Navigated to Cart Page. Please check the URL ");
    log.info("Verified that user is navigated to Cart Page");
    ExtentCucumberAdapter.addTestStepLog("Verified that user is navigated to Cart Page");
  }
  
  public void verifyProductOnCartPage(String product) {
	    DriverManager.getCommonActions().waitForTimeOutInSec(2);
	    DriverManager.getCommonActions()
	        .scrollIntoCenterView(By.xpath(String.format(PRODUCT_TEXT_CART_PLACEHOLDER, product)));
	    DriverManager.getCommonActions().waitForTimeOutInSec(2);
	    Assert.assertTrue(
	        DriverManager.getCommonActions()
	            .isElementDisplayed(String.format(PRODUCT_TEXT_CART_PLACEHOLDER, product)),
	        product + " : Product is not displayed in cart page");
	    log.info("Verified that " + product + " is present into Cart Page");
	    ExtentCucumberAdapter.addTestStepLog("Verified that " + product + " is present into Cart Page");
	  }

  public void addFewProductsCompleteYourMeal(String quantity, String product) {
	  DriverManager.getCommonActions().click(String.format(COMPLETE_YOUR_MEAL_ADD_BUTTON, product));
	 log.info("Added "+quantity+ " number of " +product+" to complete meal"); 
	 ExtentCucumberAdapter.addTestStepLog("Added "+quantity+ " number of " +product+" to complete meal");
  }
 
  public void verifyCompleteMealProductAdded_Into_SelectedItems(String comleteMealProduct) {
	  
	  Assert.assertTrue(DriverManager.getCommonActions().isElementDisplayed(String.format(PRODUCT_TEXT_CART_PLACEHOLDER, comleteMealProduct)), comleteMealProduct +" is not present in selected items");

	  log.info(comleteMealProduct+ " is added into selected items section ");
	  ExtentCucumberAdapter.addTestStepLog(comleteMealProduct+ " is added into selected items section ");
  }
 
  public void verifyPriceDetails(String product, String productPrice) {
    String actaulprice = DriverManager.getCommonActions()
        .getText(String.format(PRODUCT_PRICETEXT_PLACEHOLDER, product));
    Assert.assertEquals(actaulprice, productPrice,
        "price details of " + product + " NOT matching with expected price" + productPrice);
    log.info("price details of " + product + " matching with expected price" + productPrice);
    ExtentCucumberAdapter.addTestStepLog(
        "price details of " + product + " matching with expected price" + productPrice);
  }

  public void clickOnPlaceOrderButton() {
	  DriverManager.getCommonActions().waitForTimeOutInSec(2);
	  DriverManager.getCommonActions().scrollIntoCenterView(placeOrderButton);
	
    placeOrderButton.click();
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    log.info("Clicked Place Order Button");
    ExtentCucumberAdapter.addTestStepLog("Clicked Place Order Button");
  }

  public void enterFirstNameTextField(String value) {
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    firstNameTextField.sendKeys(value);
    firstNameTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in First Name Text field as: " + value);
  }

  public void enterLastNameTextField(String value) {
    lastNameTextField.sendKeys(value);
    lastNameTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in Last Name Field as: " + value);
  }

  public void enterMobileNumberTextField(String value) {
    mobileNumberTextField.sendKeys(value);
    mobileNumberTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in Mobile Number Field as: " + value);
  }

  public void enterEmailBoxTextField(String value) {
    emailBoxTextField.sendKeys(value);
    emailBoxTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in EmailBox Field as: " + value);
  }

  public void enterAddressBoxTextField(String value) {
    addressBoxTextField.sendKeys(value);
    addressBoxTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in Address Field as: " + value);
  }

  public void enterHouseNumberTextField(String value) {
    houseNumberTextField.sendKeys(value);
    houseNumberTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in HouseNumber Field as: " + value);
  }

  public void clickOnSaveContinueButton() {
    saveContinueButton.click();
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    log.info("Clicked Save Continue Button");
    ExtentCucumberAdapter.addTestStepLog("Clicked Save Continue Button");
  }
  
  public void verifySubTotalPrice() {
	  List<WebElement> prices = DriverManager.getDriver().findElements(By.xpath(PRODUCT_PRICETEXT_PLACEHOLDER));
	  
	  double expectedTotalPrice=0;
	  for(WebElement productPrice:prices) {
	
		  double price = Double.parseDouble(productPrice.getText());
		  
		
		expectedTotalPrice=price+expectedTotalPrice;
		 expectedTotalProductPrice=String.format("%.2f",expectedTotalPrice );
		 System.out.println("expected total product price is "+expectedTotalProductPrice);
	  }
	  String actualProductTotal_Price = DriverManager.getCommonActions().getText(productSubToltalPriceText);
	  
	  Assert.assertEquals(actualProductTotal_Price, expectedTotalProductPrice, "Actual price is not matching with expectd price");
	log.info("Actual total price "+actualProductTotal_Price+" is mathcing with expected price"+expectedTotalProductPrice);  
  }

}
