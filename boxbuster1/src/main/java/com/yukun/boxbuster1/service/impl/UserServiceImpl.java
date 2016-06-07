package com.yukun.boxbuster1.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.repository.UserRepository;
import com.yukun.boxbuster1.service.AddressService;
import com.yukun.boxbuster1.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressService addressService;
	
	@Override
	public long addUser(User user) {
		return userRepository.addUser(user);
	}

	@Override
	public User getUser(long userId) {
		return userRepository.getUser(userId);
	}

	@Override
	public boolean isPinValid(long userId, String pin) {
		// TODO Need to implement in the future
		return true;
	}

	@Override
	public void updateUser(User user) {
		userRepository.update(user);
	}

}
