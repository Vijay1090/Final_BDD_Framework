package com.pojos.userdetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDetails {
	public int bookingid;
	public Booking booking;
}
