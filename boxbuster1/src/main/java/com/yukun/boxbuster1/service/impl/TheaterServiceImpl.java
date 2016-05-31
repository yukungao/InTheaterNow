package com.yukun.boxbuster1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.repository.TheaterRepository;
import com.yukun.boxbuster1.service.TheaterService;

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Override
	public long addTheater(Theater theater) {
		return (long) theaterRepository.addTheater(theater);
	}

	@Override
	public Theater getTheaterByName(String name) {
		return (Theater) theaterRepository.getTheaterByName(name);
	}

	@Override
	public Theater getTheaterByAddress(Address address) {
		return (Theater) theaterRepository.getTreaterByAddress(address);
	}

	@Override
	public List<Theater> getAllTheaters() {
		return theaterRepository.getAllTheaters();
	}

	@Override
	public void update(Theater theater) {
		theaterRepository.update(theater);
	}

}
