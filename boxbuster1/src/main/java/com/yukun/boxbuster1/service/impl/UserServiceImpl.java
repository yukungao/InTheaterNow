package com.yukun.boxbuster1.service.impl;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.UserPurchasesHistory;
import com.yukun.boxbuster1.entity.impl.TicketImpl;
import com.yukun.boxbuster1.entity.impl.UserPurchasesHistoryImpl;
import com.yukun.boxbuster1.repository.UserRepository;
import com.yukun.boxbuster1.service.PurchaseService;
import com.yukun.boxbuster1.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private UserService userService;
	
	
	@Override
	public User addUser(User user) {
		// What if the user is identical, who to catch this exception
		long id = userRepository.addUser(user);
		return getUser(id);
	}

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return userRepository.getUser(userId);
	}

	@Override
	public boolean isPinValid(long userId, String pin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buyTicket(TicketImpl ticket, User user) {
		// TODO Buy Ticket Service, to verify the balance of the user
		if (user.getBalance() > ticket.getPrice()) {
			UserPurchasesHistory userPurchaseHistory = new UserPurchasesHistoryImpl(ticket);
			user.addUserPurchasesHistory(userPurchaseHistory);
			purchaseService.buyTicket(ticket);
			user.costBalance(ticket.getPrice());
			userService.updateUser(user);
		}
	}

	@Override
	public void updateUser(User user) {
		userRepository.update(user);
	}

}
