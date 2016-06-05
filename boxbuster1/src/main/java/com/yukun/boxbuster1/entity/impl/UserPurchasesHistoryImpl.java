package com.yukun.boxbuster1.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.UserPurchasesHistory;
@Entity
@Table(name = "user_purchase_history")
public class UserPurchasesHistoryImpl implements UserPurchasesHistory {
	@Id
	@Column(name = "iduser_purchase_history")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = UserImpl.class)
	@JoinColumn(name = "users_idusers")
	private User user;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = TicketImpl.class)
	@JoinColumn(name = "ticket_idticket")
	private Ticket ticket;
	
	@Column(name="operation_datetime")
	private String operationDateTime;
	
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
	
	public UserPurchasesHistoryImpl(Ticket ticket) {

		this.ticket = ticket;
	}
	@Override
	public String getOperationDate() {
		return operationDateTime;
	}
	
	public void setOperationDate(String time) {
		this.operationDateTime = time;
	}
	
}
