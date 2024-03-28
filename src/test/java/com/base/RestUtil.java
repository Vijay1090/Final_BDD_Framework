package com.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.utils.PropertyFileReader;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class RestUtil {

	private static final Logger log = LogManager.getLogger(RestUtil.class);

	public static PropertyFileReader propertyFileReader;

	public static Map<String, String> headers = new HashMap<>();

	public static String PAYLOAD = "";
	public static String ENDPOINT = "";

	public static Response response;

	public RestUtil() {
		propertyFileReader = new PropertyFileReader();
		RestAssured.baseURI = propertyFileReader.getProperty("api.uri");
	}

	public void setContentTypeAsApplicationJson() {
		headers.put("Content-Type", "application/json");
	}

	public void setContentType(String key, String value) {
		headers.put(key, value);
		// headers.put("Cookie", "token=" + getToken());
	}

	public void setContentType(String key) {

		headers.put(key, "token=" + getToken());
	}

	public void setPayloadAs(String payload) {
		PAYLOAD = payload;
	}

	public void setEndpoint(String endpoint) {
		ENDPOINT = endpoint;
	}

	public void setToken() {
		System.out.println("My Gen Token :" + getToken());
		headers.put("Cookie", "token=" + getToken());
	}

	public Response hitAPIRequest(String request) {
		if (request.equalsIgnoreCase("GET")) {
			response = RestAssured.given().headers(headers).get(ENDPOINT);
		} else if (request.equalsIgnoreCase("POST")) {
			response = RestAssured.given().headers(headers).body(PAYLOAD)
					.post(ENDPOINT);
		} else if (request.equalsIgnoreCase("PUT")) {
			response = RestAssured.given().headers(headers).body(PAYLOAD)
					.put(ENDPOINT);
		} else if (request.equalsIgnoreCase("PATCH")) {

			response = RestAssured.given().headers(headers).body(PAYLOAD)
					.patch(ENDPOINT);
		} else if (request.equalsIgnoreCase("DELETE")) {
			response = RestAssured.given().headers(headers).delete(ENDPOINT);
		}
		System.out.println(response.getBody().asPrettyString());
		return response;
	}

	public void verifyJsonSchema(String JsonFile) {
		System.out.println(response.body().asPrettyString());
		System.out.println("*****************************");
		response.then().assertThat().body(
				JsonSchemaValidator.matchesJsonSchemaInClasspath(JsonFile));
		log.info("Verified Response Json schema is matching with given JSON:  "
				+ JsonFile);
	}

	public void verifyStatusCodeAs(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
		log.info("Verified Response status code: " + response.getStatusCode());
	}

	public void verifyExpectedMatchWithActual(String expected, String actual) {
		Assert.assertEquals(actual, expected, " Expected value: " + expected
				+ " Is not macthing with the Actual value: " + actual);
		log.info("Verified Expected: " + expected
				+ " is matching with the Actual value: " + actual);
		ExtentCucumberAdapter.addTestStepLog("Verified Expected: " + expected
				+ " is matching with the Actual value: " + actual);
	}

	public void verifyExpectedMatchWithActual(int expected, int actual) {
		Assert.assertEquals(actual, expected, " Expected value: " + expected
				+ " Is not macthing with the Actual value: " + actual);
		log.info("Verified Expected: " + expected
				+ " is matching with the Actual value: " + actual);
		ExtentCucumberAdapter.addTestStepLog("Verified Expected: " + expected
				+ " is matching with the Actual value: " + actual);
	}

	public static String getToken() {
		RestAssured.baseURI = propertyFileReader.getProperty("api.uri");
		String payload = "{\"username\":\"admin\",\"password\":\"password123\"}";
		return RestAssured.given().contentType("application/json").body(payload)
				.when().post("/auth").then().log().body().extract().response()
				.jsonPath().getString("token");

	}

}
