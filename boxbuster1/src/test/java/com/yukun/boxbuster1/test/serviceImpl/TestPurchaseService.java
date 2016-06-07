package com.yukun.boxbuster1.test.serviceImpl;

import org.junit.Assert;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.yukun.boxbuster1.entity.impl.UserImpl;
import com.yukun.boxbuster1.service.PurchaseService;
import com.yukun.boxbuster1.service.TicketService;
import com.yukun.boxbuster1.service.UserService;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestPurchaseService extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TicketService ticketService;
	
	
	//Test-Buy-Ticket Service
	@Test
	public void testBuyTicket() {
		//Step 1: Create a User
		UserImpl user = new UserImpl();
		user.setFirstname("usr2");
		user.setLastname("usr2");
		user.setBalance(5);
		long added_id = userService.addUser(user);
		
		//Step 2: Test different scenario. 
		
		// Balance not enough
		System.out.println( purchaseService.buyTicket("AngryBirds", "Harkins", "12:33", user) );
		
		// No such ticket
		System.out.println( purchaseService.buyTicket("AngryBirds", "amc1", "12:33", user) );
		
		// Successfully buy ticket
		
		// Increase the balance and then buy it
		user = (UserImpl) userService.getUser(added_id);
		user.setBalance(2000);
		userService.updateUser(user);
		user = (UserImpl) userService.getUser(added_id);
		
		System.out.println( purchaseService.buyTicket("AngryBirds", "Harkins", "12:33", user) );
		
	}
	

}
