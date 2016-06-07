package com.yukun.boxbuster1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.repository.TheaterRepository;
import com.yukun.boxbuster1.service.AddressService;
import com.yukun.boxbuster1.service.TheaterService;

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private AddressService addressService;
	
	@Override
	public long addTheater(Theater theater) {
		return theaterRepository.addTheater(theater);
	}

	@Override
	public Theater getTheaterById(long id) {
		return theaterRepository.getTheaterById(id);
	}

	@Override
	public List<Theater> getTheaterByName(String name) {
		return theaterRepository.getTheaterByName(name);
	}

	@Override
	public Theater getTheaterByAddress(Address address) {
		return theaterRepository.getTreaterByAddress(address);
	}

	@Override
	public List<Theater> getAllTheaters() {
		return theaterRepository.getAllTheaters();
	}

	@Override
	public List<Theater> getTheaterByZip(String zip) {
		return addressService.getTheaterbyZip(zip);
	}

	@Override
	public void update(Theater theater) {
		theaterRepository.update(theater);
		
	}

}
