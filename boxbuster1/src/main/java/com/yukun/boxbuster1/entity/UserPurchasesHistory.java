package com.yukun.boxbuster1.entity;

import java.util.Date;


public interface UserPurchasesHistory {
	long getId();
	User getUser();
	Ticket getTicket();
	String getOperationDate();

}
