package com.yukun.boxbuster1.service;

import java.util.List;

import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.User;

public interface AddressService {
	List<User> getUserbyZip(String zip);
	List<Theater> getTheaterbyZip(String zip);
}
