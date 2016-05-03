package com.yukun.boxbuster1.entity.impl;

import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.UserPurchasesHistory;

public class UserPurchasesHistoryImpl implements UserPurchasesHistory {
	private long id;
	private User user;
	private Ticket ticket;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
