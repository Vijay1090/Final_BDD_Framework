package com.stepdefinations.UI;

import java.io.FileNotFoundException;
import java.util.Map;

import com.base.BaseTest;
import com.base.DriverManager;
import com.base.PageObjectManager;
import com.utils.ExcelReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuPageStepDefination extends BaseTest {
	ExcelReader excelReader=new ExcelReader();
	Map<String, String> testData;
	String productname;
	String quantity;

	@Then("Verify navigated to Menu page")
	public void verify_navigated_to_menu_page() {
		pageObjectManager.getMenuPage().verifyUserIsOnMenuPage();
	}

	@When("Click on {string} Menu")
	public void click_on_menu(String menu) {
		pageObjectManager.getMenuPage().clickOnMenu(menu);
	}

	@When("Click on {string} Add to Cart button under {string} section")
	public void click_on_add_to_cart_button_for(String product, String type) {
		pageObjectManager.getMenuPage().clickOnAddToCartButton(type, product);
	}


	@When("Make a note of one {string} Price under {string} section")
	public void make_a_note_of_pizz_amount_for(String product, String type) {
		//productDetails.setProductPrice(pageObjectManager.getMenuPage().getPriceOfSingleProduct(product, type));

		productDetails.setProductPrice(String.valueOf(decimalFormat
				.format(Double.parseDouble(pageObjectManager.getMenuPage()
						.getPriceOfSingleProduct(product, type)))));
	}
	@When("Add {string} more quantity of {string} under {string} section")
	public void add_More_Quantity_Of_Under_Section(String extraQua, String product, String type) {

		pageObjectManager.getMenuPage().increaseQuantityofProduct(extraQua, type, product);
	}

	@Then("Verify {string} added in the checkout section")
	public void verify_Added_In_The_Checkout_Section(String product) {
		pageObjectManager.getMenuPage().verifyProductIsAddedInCart(product);
	}

	@Then("Verify total {string} {string} product price in the checkout section")
	public void verify_Price_In_The_Checkout_Section(String totalquantity, String product) {
		System.out.println("total price : "+productDetails.getProductPrice());
		String ProductPrice = productDetails.getProductPrice();
		double oneProductPrice = Double.parseDouble(ProductPrice);
		double totalProducts = Double.parseDouble(totalquantity);
		Double totalProductsprice=oneProductPrice*totalProducts;

		String totalExpectedProductPrice =(String.valueOf(decimalFormat
				.format(totalProductsprice)));

		System.out.println("Total expected Product price : "+totalExpectedProductPrice);


		pageObjectManager.getMenuPage().verifytotalPriceOfProductAddedInCart(product,
				totalExpectedProductPrice);
	}
	@Then("Verify {string} and total quantity of {string} added in the checkout section")
	public void verify_And_Total_Quantity_Added_In_The_Checkout_Section(String product, String totalproduct) {
		pageObjectManager.getMenuPage().verifyquantityOfProductIntoMiniCart(product, totalproduct);
	}

	@When("Click on checkout button")
	public void click_On_Checkout_Button() {
		pageObjectManager.getMenuPage().clickOnMiniCartCheckoutButon();
	}

	@When("Add Multiple veg Pizzas also note there price")
	public void add_Multiple_Veg_Pizzas_Also_Note_There_Price() throws FileNotFoundException {
		testData=excelReader.getTestDataFromExcel();
		for(var data:testData.entrySet()) {
			productname=data.getKey();
			quantity=data.getValue();
			pageObjectManager.getMenuPage().addproductsIntoCart(productname, Integer.parseInt(quantity));
		}   
	}
	
	@When("Add Multiple NonVeg Pizzas also note there price")
	public void Add_Multiple_NonVeg_Pizzas_Also_Note_There_Price() throws FileNotFoundException {
		testData=excelReader.getTestDataForNonVegFromExcel();
		for(var data:testData.entrySet()) {
			productname=data.getKey();
			quantity=data.getValue();
			System.out.println(productname+"====== "+quantity);
			pageObjectManager.getMenuPage().addNonVegPizzaIntoCart(productname, Integer.parseInt(quantity));
		}
	}
	@When("Add multiple Veg pizzas with beverages also note there price consider {string}")
	public void Add_Multiple_Veg_Pizzas_Along_With_Beverages_Also_Note_There_Price(String sheetName) throws Throwable {
		testData=excelReader.getTestDataFromExcelSheet(sheetName);
		for(var data:testData.entrySet()) {
			productname=data.getKey();
			quantity=data.getValue();
			pageObjectManager.getMenuPage().addVegPizzaWithBeverageIntoCart(productname, Integer.parseInt(quantity));
		}	
	}
	
	@When("Add multiple nonVeg pizzas with beverages also note there price consider {string}")
	public void Add_Multiple_NonVeg_Pizzas_Along_With_Beverages_Also_There_Price(String sheetName) throws Throwable {
	      //testData=excelReader.getTestDataForNonVegWithBeverageFromExcel();
		testData=excelReader.getTestDataFromExcelSheet(sheetName);
		for(var data:testData.entrySet()) {
			productname=data.getKey();
			quantity=data.getValue();
			pageObjectManager.getMenuPage().addNonVegPizzaWithBeverageIntoCart(productname, Integer.parseInt(quantity));
		}	
	}
	
	
	
}
