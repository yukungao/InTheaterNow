package com.yukun.boxbuster1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.impl.TicketImpl;
import com.yukun.boxbuster1.service.BrowseService;
import com.yukun.boxbuster1.service.PurchaseService;
import com.yukun.boxbuster1.service.TicketService;
import com.yukun.boxbuster1.service.UserService;


@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public void buyTicket(Ticket ticket, User user) {
		
		// Check if there is ticket 
		// Check if user's balance is larger than the ticket price
		if(user.getBalance() >= ticket.getPrice() && ticket.getStatus() != false) {
			
		}
	}

	// This method is for restful buy usage, because at that time, we only provide 
	// 1. movieName 2. theaterName. 3. user
	
	// Return true, if buy successfully
	// Return false, if not buy successfully
	
	@Override
	public boolean buyTicket(String movieName, String theaterName, String showDate, User user) {
		
		// Notice that I don't real use showDate here.
		
		// Check if there are some valid ticket & un-sold ticket exist
		List<Ticket> tickets = ticketService.searchAvailabeTicket(movieName,theaterName);
		
		// If exist, check if user's balance is enough to buy or not
		if(tickets.size() == 0 ) return false;
		Ticket ticket = tickets.get(0);
		
		// If could buy, then user need to update balance, and add it to his buy history
		if(user.getBalance() >= ticket.getPrice()) {
			((TicketImpl) ticket).setStatus(true);
			ticketService.update(ticket);
			// TODO, the Purchase history part
			
			user.costBalance(ticket.getPrice());
			userService.updateUser(user);
			return true;
		}
		
		return false;
	}

}
