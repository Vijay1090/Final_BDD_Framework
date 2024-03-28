package com.pages;

import org.hamcrest.DiagnosingMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.DriverManager;

public class MenuPage {

	private static Logger log = LoggerFactory.getLogger(MenuPage.class);



	public MenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}


	private static String MENU_PLACEHOLDER = "//div[@data-label='%s']/span";

	private static String PRODUCT_ADDTOCART_NOT_INCLUDE_RECOMENDED_PLACEHOLDER =
			"//span[text()='%s']/parent::div/following-sibling::div/descendant::button[@data-label='addTocart']";
	

	private static String PRODUCT_ADDTOCART_ONLY_NONVEG_PLACEHOLDER="//div[(@data-label='Non-Veg Pizza')]/descendant::span[text()='%s']/parent::div/following-sibling::div/descendant::button[@data-label='addTocart']";

	private static String PRODUCTNAME_MINICART_PLACEHOLDER="//div[@class='crt-itms']/div[@class='sc-dqBHgY iicSxJ']/descendant::span[text()='%s']";
	private static String SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER="//span[text()='%s']/ancestor::div[@class='crt-cntnt']/descendant::span[@class='rupee']";

	private static String PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER="//span[text()='%s']/ancestor::div[@class='crt-cntnt']/descendant::div[@data-label='increase']";


	private static String MINI_CART_PLACEHOLDER="//div[@class='crt-itms']";


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static String PRODUCT_ADDTOCART_BTN_PLACEHOLER = "//div[@class='ref']/following-sibling::div/div[@data-label='%s']/descendant::div[@data-label='%s']/descendant::button[@data-label='addTocart']";

	private static String PRODUCT_QUNTITY_INCREASE_PLACEHOLDER="//div[@class='ref']/following-sibling::div/div[@data-label='%s']/descendant::div[@data-label='%s']/descendant::div[@data-label='increase']";

	private static String PRODUCT_PRICE_PLACEHOLDER = "//div[@class='ref']/following-sibling::div/div[@data-label='%s']/descendant::div[@data-label='%s']/descendant::span[@class='rupee']";
	private static String MAKE_MY_PIZZA_MORE_YUMMY_POPUP = "//button[@data-label='Add button']/span";

	private static String CART_PRODUCT_NAMETEXT_PLACEHOLDER = "//div[@class='crt-itms']/descendant::span[text()='%s']";
	private static String CART_PRODUCT_PRICE_PLACEHOLDER = "//div[@class='crt-itms']/descendant::span[text()='%s']/ancestor::div[@class='crt-cnt']/following-sibling::div/descendant::span[@class='rupee']";

	private static String PRODUCT_QANTITY_IN_MINICART_PLACEHOLDER="//div[@class='crt-itms']/descendant::span[text()='%s']/ancestor::div[@class='crt-cnt']/following-sibling::div/descendant::span[@class='cntr-val']";

	@FindBy(xpath = "//div[@class='slct-lctn-cnt']")
	private WebElement menuPageAddressLink;

	@FindBy(xpath = "//button[@data-label='miniCartCheckout']")
	private WebElement miniCartCheckoutButton;

	public void verifyUserIsOnMenuPage() {
		DriverManager.getCommonActions().waitForTimeOutInSec(3);
		Assert.assertTrue(
				DriverManager.getCommonActions()
				.isElementDisplayed(menuPageAddressLink),
				"User Is NOT Navigated to Menu Page. Please check the URL ");
		log.info("Verified that user is navigated to Menu Page");
	}

	public void clickOnMenu(String menuName) {
		DriverManager.getCommonActions()
		.click(String.format(MENU_PLACEHOLDER, menuName));
		log.info("User Navigated to " + menuName + " Section");
	}

	public void clickOnAddToCartButton(String product, String type) {
		DriverManager.getCommonActions().click(
				String.format(PRODUCT_ADDTOCART_BTN_PLACEHOLER, product, type));
		log.info("Clicked on Add to Cart Button for : " + product);
		if (DriverManager.getCommonActions()
				.isElementDisplayed(MAKE_MY_PIZZA_MORE_YUMMY_POPUP)) {
			DriverManager.getCommonActions()
			.click(MAKE_MY_PIZZA_MORE_YUMMY_POPUP);
		}
	}

	public void increaseQuantityofProduct(String extraquantity, String type, String product) {
		int quantity = Integer.parseInt(extraquantity);

		for(int i=1;i<=quantity;i++) {
			DriverManager.getCommonActions().click(String.format(PRODUCT_QUNTITY_INCREASE_PLACEHOLDER,type, product));
			DriverManager.getCommonActions().waitForTimeOutInSec(2);
		}
	}

	public String getPriceOfSingleProduct(String product, String type) {
		return DriverManager.getCommonActions().getText(
				String.format(PRODUCT_PRICE_PLACEHOLDER, type, product));
	}


	public void verifyProductIsAddedInCart(String product) {
		DriverManager.getCommonActions().waitForTimeOutInSec(2);

		Assert.assertTrue(
				DriverManager.getCommonActions()
				.isElementDisplayed(String.format(
						CART_PRODUCT_NAMETEXT_PLACEHOLDER, product)),
				product + " : Product is not added in the cart. Please check the before steps..");
		log.info("Verified that Product " + product + " is added in the cart.");
	}

	public void verifyquantityOfProductIntoMiniCart(String product, String totalQuntityProduct) {
		String actualQantity = DriverManager.getCommonActions().getText(String.format(PRODUCT_QANTITY_IN_MINICART_PLACEHOLDER, product));

		Assert.assertEquals(actualQantity, totalQuntityProduct,"actual product quantity "+actualQantity+" is not matching with expected quantity"+totalQuntityProduct);
		log.info(" actual quantity of product matching with expected quantity of product");	
		ExtentCucumberAdapter.addTestStepLog("actual quantity of product "+actualQantity+" matching with expected quantity "+totalQuntityProduct);
	}

	public void verifytotalPriceOfProductAddedInCart(String product, String price) {
		DriverManager.getCommonActions().waitForTimeOutInSec(2);
		String actualPrice = DriverManager.getCommonActions().getText(
				String.format(CART_PRODUCT_PRICE_PLACEHOLDER, product));
		Assert.assertEquals(actualPrice.trim(), price.trim(),
				product + " : Product Actual Price" + actualPrice
				+ " is not matching with the expected Value: " + price);
		log.info("Verified that Product " + product + " Price is " + actualPrice
				+ " is matching with the expected Value " + price);
		ExtentCucumberAdapter.addTestStepLog("Verified that Product " + product + " Price is " + actualPrice
				+ " is matching with the expected Value " + price);
	}

	public void clickOnMiniCartCheckoutButon() {
		DriverManager.getCommonActions().click(miniCartCheckoutButton);
		log.info("Clicked on Mini Cart Checkout Button");
	}

	public void addproductsIntoCart(String product, int quantity) {

		DriverManager.getCommonActions().click(String.format(PRODUCT_ADDTOCART_NOT_INCLUDE_RECOMENDED_PLACEHOLDER, product));

		//		if (DriverManager.getCommonActions().isElementDisplayed(MAKE_MY_PIZZA_MORE_YUMMY_POPUP)) {
		//  			DriverManager.getCommonActions()
		//					.click(MAKE_MY_PIZZA_MORE_YUMMY_POPUP);
		//		}
		if (DriverManager.getCommonActions().isPresent(By.xpath("//span[text()='NO THANKS']"))) {
			DriverManager.getCommonActions().click(By.xpath("//span[text()='NO THANKS']"));
		}
		//scroll the mini cart
		DriverManager.getCommonActions().scrollIntoCenterView(String.format(PRODUCTNAME_MINICART_PLACEHOLDER, product));

		//note price per product
		String pricePerProduct = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));
		System.out.println("price per product of "+product+" is "+pricePerProduct );

		DriverManager.getCommonActions().scrollIntoCenterView(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER, product));
		//add product Quantity

		int remainQuantity=quantity-1;

		for(int i=1;i<=remainQuantity;i++) {
			DriverManager.getCommonActions().click(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER,product ));

		}
		//total price of products is 
		String totalPrice=String.format("%.2f", Double.parseDouble(pricePerProduct) * (quantity));

		System.out.println("total expected price  of "+product+" is "+totalPrice );

		//verify this total price
		String actualprice2 = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));

		System.out.println("total actual price  of "+product+" is "+actualprice2);

		Assert.assertEquals(actualprice2, totalPrice," expected price of "+ product+" not matching with actual price");
		log.info("expected price of "+ product+" matching with actual price");
		ExtentCucumberAdapter.addTestStepLog("expected price of "+ product+" matching with actual price");	

	}
	public void addNonVegPizzaIntoCart(String product, int quantity) {

		DriverManager.getCommonActions().click(String.format(PRODUCT_ADDTOCART_ONLY_NONVEG_PLACEHOLDER, product));

		//				if (DriverManager.getCommonActions().isElementDisplayed(MAKE_MY_PIZZA_MORE_YUMMY_POPUP)) {
		//		  			DriverManager.getCommonActions()
		//							.click(MAKE_MY_PIZZA_MORE_YUMMY_POPUP);
		//				}
		if (DriverManager.getCommonActions().isPresent(By.xpath("//span[text()='NO THANKS']"))) {
			DriverManager.getCommonActions().click(By.xpath("//span[text()='NO THANKS']"));
		}


		//note price per product
		String pricePerProduct = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));
		//System.out.println("price per product of "+product+" is "+pricePerProduct );

		//add product Quantity


		DriverManager.getCommonActions().scrollIntoCenterView(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER, product));
		int remainQuantity=quantity-1;

		for(int i=1;i<=remainQuantity;i++) {
			DriverManager.getCommonActions().scrollandClick(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER, product));

		}
		//total price of products is 
		String totalPrice=String.format("%.2f", Double.parseDouble(pricePerProduct) * (quantity));

		System.out.println("total expected price  of "+product+" is "+totalPrice );

		//verify this total price
		String actualprice2 = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));

		System.out.println("total actual price  of "+product+" is "+actualprice2);

		Assert.assertEquals(actualprice2, totalPrice," expected price of "+ product+" not matching with actual price");
		log.info("expected price of "+ product+" matching with actual price");
		ExtentCucumberAdapter.addTestStepLog("expected price of "+ product+" matching with actual price");	


	}

	public void addVegPizzaWithBeverageIntoCart(String product, int quantity) {

		DriverManager.getCommonActions().click(String.format(PRODUCT_ADDTOCART_NOT_INCLUDE_RECOMENDED_PLACEHOLDER, product));

		//		if (DriverManager.getCommonActions().isElementDisplayed(MAKE_MY_PIZZA_MORE_YUMMY_POPUP)) {
		//  			DriverManager.getCommonActions()
		//					.click(MAKE_MY_PIZZA_MORE_YUMMY_POPUP);
		//		}
		if (DriverManager.getCommonActions().isPresent(By.xpath("//span[text()='NO THANKS']"))) {
			DriverManager.getCommonActions().click(By.xpath("//span[text()='NO THANKS']"));
		}


		//note price per product
		String pricePerProduct = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));
		//System.out.println("price per product of "+product+" is "+pricePerProduct );

		//add product Quantity


		DriverManager.getCommonActions().scrollIntoCenterView(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER, product));
		int remainQuantity=quantity-1;

		for(int i=1;i<=remainQuantity;i++) {
			DriverManager.getCommonActions().scrollandClick(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER, product));

		}
		//total price of products is 
		String totalPrice=String.format("%.2f", Double.parseDouble(pricePerProduct) * (quantity));

		System.out.println("total expected price  of "+product+" is "+totalPrice );

		//verify this total price
		String actualprice2 = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));

		System.out.println("total actual price  of "+product+" is "+actualprice2);

		Assert.assertEquals(actualprice2, totalPrice," expected price of "+ product+" not matching with actual price");
		log.info("expected price of "+ product+" matching with actual price");
		ExtentCucumberAdapter.addTestStepLog("expected price of "+ product+" matching with actual price");	


	}


	public void addNonVegPizzaWithBeverageIntoCart(String product, int quantity) {
		
		
		DriverManager.getCommonActions().scrollIntoCenterView(String.format(PRODUCT_ADDTOCART_NOT_INCLUDE_RECOMENDED_PLACEHOLDER, product));
		DriverManager.getCommonActions().click(String.format(PRODUCT_ADDTOCART_NOT_INCLUDE_RECOMENDED_PLACEHOLDER, product));
		
      
		//DriverManager.getCommonActions().scrollandClick(String.format(PRODUCT_ADDTOCART_NOT_INCLUDE_RECOMENDED_PLACEHOLDER,product ));
		//				if (DriverManager.getCommonActions().isElementDisplayed(MAKE_MY_PIZZA_MORE_YUMMY_POPUP)) {
		//		  			DriverManager.getCommonActions()
		//							.click(MAKE_MY_PIZZA_MORE_YUMMY_POPUP);
		//				}
		if (DriverManager.getCommonActions().isPresent(By.xpath("//span[text()='NO THANKS']"))) {
			DriverManager.getCommonActions().click(By.xpath("//span[text()='NO THANKS']"));
		}


		//note price per product
		String pricePerProduct = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));
		//System.out.println("price per product of "+product+" is "+pricePerProduct );

		//add product Quantity


		DriverManager.getCommonActions().scrollIntoCenterView(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER, product));
		int remainQuantity=quantity-1;

		for(int i=1;i<=remainQuantity;i++) {
			DriverManager.getCommonActions().scrollandClick(String.format(PRODUCT_QUNTITY_INCREASE_MINICART_PLACEHOLDER, product));

		}
		//total price of products is 
		String totalPrice=String.format("%.2f", Double.parseDouble(pricePerProduct) * (quantity));

		System.out.println("total expected price  of "+product+" is "+totalPrice );

		//verify this total price
		String actualprice2 = DriverManager.getCommonActions().getText(String.format(SINGLE_PRODUCT_PRICE_MINI_CHART_PLACEHOLDER, product));

		System.out.println("total actual price  of "+product+" is "+actualprice2);

		Assert.assertEquals(actualprice2, totalPrice," expected price of "+ product+" not matching with actual price");
		log.info("expected price of "+ product+" matching with actual price");
		ExtentCucumberAdapter.addTestStepLog("expected price of "+ product+" matching with actual price");	


	}
}


