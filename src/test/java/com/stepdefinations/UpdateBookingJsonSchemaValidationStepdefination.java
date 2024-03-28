package com.stepdefinations;

import com.base.BaseTest;

import io.cucumber.java.en.Then;

public class UpdateBookingJsonSchemaValidationStepdefination extends BaseTest {
	
	@Then("Validate UpdateBooking Json Schema {string}")
	public void validate_update_booking_json_schema(String updateBookingjsonSchema) {
		
		String jsonSchemapath="\\jsonschema\\"+updateBookingjsonSchema+".json";
		restUtil.verifyJsonSchema(jsonSchemapath);
	   
	}
	

}
