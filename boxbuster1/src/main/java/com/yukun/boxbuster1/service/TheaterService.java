package com.yukun.boxbuster1.service;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;

public interface TheaterService {
	long addTheater(Theater theater);

	Theater getTheaterByName(String name);

	Theater getTheaterByAddress(Address address);

	List<Theater> getAllTheaters();

	void update(Theater theater);
}
