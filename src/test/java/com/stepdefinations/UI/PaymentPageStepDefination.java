package com.stepdefinations.UI;

import com.base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentPageStepDefination extends BaseTest {

  @Then("Verify user is navigated payment page")
  public void verify_user_is_navigated_payment_page() {
    pageObjectManager.getPaymentPage().verifyUserIsOnPaymentPage();
  }

  @Then("Verify the order Sub Total")
  public void verify_the_order_sub_total() {
    pageObjectManager.getPaymentPage().verifySubTotalText(productDetails.getProductPrice());
  }
  
  @Then("Verify the SubTotal Price on Payment Page")
  public void Verify_The_SubTotal_Price_On_Payment_Page() {
	  System.out.println("expexted price is "+expectedTotalProductPrice);
   pageObjectManager.getPaymentPage().verifySubTotalPrice(expectedTotalProductPrice);
  }
  

  @Then("Verify Delivery Address details")
  public void verify_delivery_address_details() {

  }

  @When("Select payment mode as Credit Card")
  public void select_payment_mode_as_credit_card() {

  }

  @Then("Verify {string} text displayed")
  public void verify_text_displayed(String string) {

  }
}
