package com.yukun.boxbuster1.repository;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;

public interface TheaterRepository {
	long addTheater(Theater theater);
	
	Theater getTheaterById(long id);
	
	List<Theater> getTheaterByName(String name);
	
	//This method is not really implemented
	Theater getTreaterByAddress(Address address);
	
	List<Theater> getAllTheaters();
	
	void update(Theater theater);
	
	//Get theater by ZipCode
	List<Theater> getTheaterByZip(String zip);
	
}
