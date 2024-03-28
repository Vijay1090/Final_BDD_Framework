package com.stepdefinations.UI;

import com.base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStepDefination extends BaseTest {

  @Then("Verify navigated to cart page")
  public void verify_navigated_to_cart_page() {
    pageObjectManager.getCartPage().verifyCartPage();
  }
  @Then("Verify {string} is showing in the cart page")
  public void verify_is_showing_in_the_cart_page(String product) {
    pageObjectManager.getCartPage().verifyProductOnCartPage(product);
  }
  
  @When("Add  {string} product of  {string}  from complete your meal section")
  public void add_product_of_from_complete_your_meal_section(String quantity, String product) {
     pageObjectManager.getCartPage().addFewProductsCompleteYourMeal(quantity, product);
  }
  
  @Then("Verify {string} is showing into selected product and note its price")
  public void verify_is_showing_into_selected_product(String completeCealProduct) {
	   pageObjectManager.getCartPage().verifyCompleteMealProductAdded_Into_SelectedItems(completeCealProduct);
  }


 
 

  @Then("Verify price details of total {string} {string} product in cart page")
  public void verify_price_details_in_cart_page(String totalProduct,  String product) {
	  String ProductPrice = productDetails.getProductPrice();
      double oneProductPrice = Double.parseDouble(ProductPrice);
      double totalProducts = Double.parseDouble(totalProduct);
       Double totalProductsprice=oneProductPrice*totalProducts;
       
       String totalExpectedProductPrice =(String.valueOf(decimalFormat
				.format(totalProductsprice)));
    pageObjectManager.getCartPage().verifyPriceDetails(product, totalExpectedProductPrice);
  }
  
  @Then("Verify Subtotal price on cart page")
  public void verifySubTotalPriceOnCartPage() {
	 pageObjectManager.getCartPage().verifySubTotalPrice();
  }

  
  
 

  @When("Fill all following details")
  public void fill_all_following_details() {
    pageObjectManager.getCartPage().enterFirstNameTextField(dataFaker.name().fullName());
    pageObjectManager.getCartPage().enterLastNameTextField(dataFaker.name().lastName());
    pageObjectManager.getCartPage()
        .enterMobileNumberTextField("9730834941");
    pageObjectManager.getCartPage()
        .enterEmailBoxTextField("shivanand.jangam@gmail.com");
    pageObjectManager.getCartPage().enterAddressBoxTextField(dataFaker.address().cityName());
    pageObjectManager.getCartPage().enterHouseNumberTextField(dataFaker.address().buildingNumber());

  }

  @When("Click on save to continue button")
  public void click_on_save_to_continue_button() {
    pageObjectManager.getCartPage().clickOnSaveContinueButton();
  }
  
  @When("Click on place order button")
  public void click_on_place_order_button() {
    pageObjectManager.getCartPage().clickOnPlaceOrderButton();
  }
}
