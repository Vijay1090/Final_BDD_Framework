package com.stepdefinations.UI;

import com.base.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefination extends BaseTest {

	@Given("Verify user is on Dominos Home page")
	public void verify_user_is_on_dominos_home_page() {
		pageObjectManager.getHomePage().verifyUserIsOnHomePage();
	}

	@When("Click on the order online button")
	public void click_on_the_order_online_button() {
		pageObjectManager.getHomePage().clickOnOrderOnlineButton();
	}

	@Then("Verify contact delivery page")
	public void verify_contact_delivery_page() {
		pageObjectManager.getHomePage().clickOnLocateMe();
	}

	@When("Click on locate me button")
	public void click_on_locate_me_button() {
		pageObjectManager.getHomePage().clickOnLocateMe();
	}

	@When("Enter and Select Area as {string}")
	public void enter_and_select_area_as(String place) {
		pageObjectManager.getHomePage().enterAreaText(place);
	}

}
