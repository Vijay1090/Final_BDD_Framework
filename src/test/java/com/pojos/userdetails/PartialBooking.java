package com.pojos.userdetails;

public class PartialBooking {

	public String firstname;
	public String lastname;
	public int totalprice;
	public boolean depositpaid;
	public Bookingdates bookingdates2;
	public String additionalneeds;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public Bookingdates getBookingdates() {
		return bookingdates2;
	}

	public void setBookingdates(Bookingdates bookingdates) {
		this.bookingdates2 = bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

}
