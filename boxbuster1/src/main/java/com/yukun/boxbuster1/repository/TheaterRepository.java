package com.yukun.boxbuster1.repository;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;

public interface TheaterRepository {
	long addTheater(Theater theater);
	
	Theater getTheaterByName(String name);
	
	Theater getTreaterByAddress(Address address);
	
	List<Theater> getAllTheaters();
	
	void update(Theater theater);
	
}
