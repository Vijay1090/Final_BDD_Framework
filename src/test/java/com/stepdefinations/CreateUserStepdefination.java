package com.stepdefinations;

import com.base.BaseTest;

import io.cucumber.java.en.Then;

public class CreateUserStepdefination extends BaseTest {

	@Then("I should get fistname as {string}")
	public void i_should_get_name_as(String expName) {
		System.out.println("actual First name "+bookingDetails.booking.firstname);
		System.out.println("exoected name "+ expName);
		restUtil.verifyExpectedMatchWithActual(expName,
				bookingDetails.booking.firstname);
	}

	@Then("I should get lastname as {string}")
	public void i_should_get_lastname_as(String expjob) {
		restUtil.verifyExpectedMatchWithActual(expjob,
				bookingDetails.booking.lastname);
	}

}
