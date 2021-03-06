package com.yukun.boxbuster1.repository;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.User;

public interface UserAddressRepository {
	long addAddress(Address address);

	Address getAddressById(long addressId);

	List<Address> searchAddressByZip(String zip);

	void update(Address address);

	List<User> getUserbyZip(String zip);
}
