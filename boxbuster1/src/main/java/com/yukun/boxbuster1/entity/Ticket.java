package com.yukun.boxbuster1.entity;
import java.util.Date;

public interface Ticket {
	
	long getId();
	
	long getMovie(long movieId);
	
	Date getMovieStartTime();
	
	Date getMovieEndTime();
	
	float getPrice();
	
	//How to design this part?
	Theather getTheather();
	
}
