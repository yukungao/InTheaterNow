package com.yukun.boxbuster1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.repository.TheaterAddressRepository;
import com.yukun.boxbuster1.repository.UserAddressRepository;
import com.yukun.boxbuster1.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private TheaterAddressRepository theaterAddressRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Override
	public List<User> getUserbyZip(String zip) {
		// TODO Auto-generated method stub
		return userAddressRepository.getUserbyZip(zip);
	}

	@Override
	public List<Theater> getTheaterbyZip(String zip) {
		// TODO Auto-generated method stub
		return theaterAddressRepository.getTheaterbyZip(zip);
	}

}
