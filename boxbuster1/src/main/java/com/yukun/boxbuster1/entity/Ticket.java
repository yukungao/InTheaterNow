package com.yukun.boxbuster1.entity;
import java.util.Date;

public interface Ticket {
	
	long getId();
	
	float getPrice();
	
	Movie getMovie();
	
	Theater getTheater();
	
	Date getMovieStartTime();
	
	Date getMovieEndTime();

}
