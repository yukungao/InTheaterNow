package com.yukun.boxbuster1.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.impl.TicketImpl;
import com.yukun.boxbuster1.service.PurchaseService;
import com.yukun.boxbuster1.service.TicketService;


@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	private TicketService ticketService;
	
	@Override
	public void buyTicket(TicketImpl ticket) {
		ticketService.createTicket(ticket);
	}

}
