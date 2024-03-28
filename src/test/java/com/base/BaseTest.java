package com.base;

import java.text.DecimalFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.pojos.UI.ProductDetails;
import com.pojos.userdetails.Booking;
import com.pojos.userdetails.BookingDetails;
import com.pojos.userdetails.GenerateTokenPOJO;
import com.utils.PropertyFileReader;

import io.restassured.response.Response;

public class BaseTest {

	public RestUtil restUtil = new RestUtil();
	public ObjectMapper mapper = new ObjectMapper();
	public Response responseHolder;

	public static BookingDetails bookingDetails;
	public static BookingDetails bookingDetails2;
	public static Booking updatebookingUserDetails;
	public static Booking partialupdatebookingUserDetails;
	public static GenerateTokenPOJO tokengen;

	/// Web Automation
	public DecimalFormat decimalFormat = new DecimalFormat("0.00");
	public PropertyFileReader propertyFileReader = new PropertyFileReader();
	public PageObjectManager pageObjectManager = new PageObjectManager();
	public static ProductDetails productDetails = new ProductDetails();
	public Faker dataFaker = new Faker();
    public String expectedTotalProductPrice;
    

}
