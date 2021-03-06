package com.yukun.boxbuster1.entity;
import java.util.Date;
import java.util.UUID;

public interface Ticket {
	
	long getId();
	
	double getPrice();
	
	Movie getMovie();
	
	Theater getTheater();
	
	String getMovieTime();
	
	String getQRCode();

	//This status is to see if the ticket 
	// is sold out or not
	Boolean getStatus();
}
