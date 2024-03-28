package com.stepdefinations;

import com.base.BaseTest;

import io.cucumber.java.en.Then;

public class PartialUpdateBookingJsonSchemaValidationStepdefination extends BaseTest{
	
	@Then("Validate partialUpdate Booking JsonSchema {string}")
	public void validate_partial_update_booking_json_schema(String jsonschema) {
		String jsonSchemapath="\\jsonschema\\"+jsonschema+".json";
	   restUtil.verifyJsonSchema(jsonSchemapath);
	}



}
