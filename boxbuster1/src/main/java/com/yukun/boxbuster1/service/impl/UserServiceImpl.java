package com.yukun.boxbuster1.service.impl;

import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.service.UserService;

public class UserServiceImpl implements  UserService{

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return new UserImpl(userId) ;
	}

	public boolean isPinValid(long userId, String pin) {
		// TODO Auto-generated method stub
		return false;
	}

}
