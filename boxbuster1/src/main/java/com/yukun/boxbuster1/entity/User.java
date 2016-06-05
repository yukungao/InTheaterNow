package com.yukun.boxbuster1.entity;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.UserPurchasesHistory;

public interface User {
	//The login related info
	long getId();	
	String getPin();
	
	
	//The User basic info
	String getFirstName();
	String getLastName();
	Address getAddress();
	
	//The User purchase info
	//long getCreditCardNumber();
	double getBalance();
	
	List<UserPurchasesHistory> getUserPurchasesHistory();
	void addUserPurchasesHistory(UserPurchasesHistory userPurchasesHistory);
	void costBalance(double price);
}
