package com.yukun.boxbuster1.repository;

import java.util.List;

import com.yukun.boxbuster1.entity.User;

public interface UserRepository {
	long addUser(User user);
	User getUser(long userId);
	List<User> search(String firstName, String lastName);
	void update(User user);
}
