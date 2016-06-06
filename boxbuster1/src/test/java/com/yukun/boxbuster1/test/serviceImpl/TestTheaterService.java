package com.yukun.boxbuster1.test.serviceImpl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.impl.TheaterAddressImpl;
import com.yukun.boxbuster1.entity.impl.TheaterImpl;
import com.yukun.boxbuster1.service.TheaterService;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestTheaterService extends AbstractJUnit4SpringContextTests {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterService theaterService;
	/*
	@Before
	public void beforeTestClass(){
		
		
	}
	*/
	
	@Test
	public void addAndGetTheater() {
		//Step 1: Create Address
		Address address1 = new TheaterAddressImpl(); 
		((TheaterAddressImpl) address1).setZipCode("95134");
		
		//Step 2: Create Theater and Add it to the database
		TheaterImpl theater = new TheaterImpl(); 
		//theater.setAddress();
		theater.setName("amc1");
		theater.setSeats(10);
		long added_id = theaterService.addTheater(theater);
		logger.info("Theater added " + added_id);
		theater = (TheaterImpl) theaterService.getTheaterById(added_id);
		
		//Step 3: Set theater's address and update it.
		theater.setAddress(address1);
		System.out.println(theater.getAddress().toString());
		theaterService.update(theater);
		
		/*
		theater = (TheaterImpl) theaterService.getTheaterById(added_id);
		
		System.out.println(theater.getAddress().toString());
		System.out.println(theater.toString());
		*/
		/*
		//Step 3: Get all the theater in database
		List<Theater> allTheaters = theaterService.getAllTheaters();
		for(Theater element : allTheaters) {
			
			//System.out.println(element.getAddress().toString());
			System.out.println(element.toString());
		}
		*/
		
	}
	
	
}
