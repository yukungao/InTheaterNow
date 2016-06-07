package com.yukun.boxbuster1.test.serviceImpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.impl.UserAddressImpl;
import com.yukun.boxbuster1.entity.impl.UserImpl;
import com.yukun.boxbuster1.service.UserService;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestUserService extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserService userService;
	
	@Test
	public void testAddAndGetUser() {
		//Step 1: Create Address
		Address address1 = new UserAddressImpl(); 
		((UserAddressImpl) address1).setZipCode("95134");
		
		
		//Step 2: Create User and Add it to the database
		UserImpl user = new UserImpl();
	
		user.setBalance(100);
		user.setLastname("gao");
		user.setFirstname("yukun");
		
		long added_id = userService.addUser(user);
		
		user = (UserImpl) userService.getUser(added_id);
		user.setAddress(address1);
		
		((UserAddressImpl) address1).setUser(user);
		userService.updateUser(user);
		System.out.println(added_id);
		
	}
	
}
