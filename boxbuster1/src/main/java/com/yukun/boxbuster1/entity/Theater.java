package com.yukun.boxbuster1.entity;

public interface Theater {
	long getId();
	String getName();
	Address getAddress();
	
	//Adding seat field to identify 
	//# of seat available in that theater
	int getSeats();
}
