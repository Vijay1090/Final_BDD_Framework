package com.stepdefinations;

import com.base.BaseTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PartialUpdateBookingStepDefination extends BaseTest {

	@When("I provided payloadbody firstname as {string} and lastname as {string}")
	public void i_provided_payloadbody_firstname_as_and_lastname_as_automation_tester(String firstname,
			String lastname) {

		String payload = "{\"firstname\":\"" + firstname + "\",\"lastname\":\"" + lastname + "}";
		restUtil.setPayloadAs(payload);

	}

	@Then("I should get booking modifiedFname as {string}")
	public void i_should_get_booking_modified_fname_as(String modifiedName) {
		restUtil.verifyExpectedMatchWithActual(modifiedName, partialupdatebookingUserDetails.firstname);
	}

	@Then("I should booking user modifiedLname as {string}")
	public void i_should_booking_user_modified_lname_as(String modifiedLname) {
		restUtil.verifyExpectedMatchWithActual(modifiedLname, partialupdatebookingUserDetails.lastname);
	}

}
