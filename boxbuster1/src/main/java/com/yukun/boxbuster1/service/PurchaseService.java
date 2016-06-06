package com.yukun.boxbuster1.service;

import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.User;

public interface PurchaseService {
	void buyTicket(Ticket ticket , User user);
	boolean buyTicket(String movieName, String theaterName, String showDate, User user);
}
