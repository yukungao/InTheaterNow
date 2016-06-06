package com.yukun.boxbuster1.test.serviceImpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.yukun.boxbuster1.service.TicketService;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestTicketService  extends AbstractJUnit4SpringContextTests {
	@Autowired
	private TicketService ticketService;
	
	//First to test 
}
