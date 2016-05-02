package com.yukun.boxbuster1.service;

import com.yukun.boxbuster1.entity.User;

public interface UserService {
	
	User addUser(User user);
	
	User getUser(long userId);

	boolean isPinValid(long userId, String pin);	
}
