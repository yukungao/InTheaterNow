package com.yukun.boxbuster1.service;

import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.impl.TicketImpl;

public interface UserService {
	
	long addUser(User user);
	
	User getUser(long userId);

	boolean isPinValid(long userId, String pin);	

	void updateUser(User user);
}
