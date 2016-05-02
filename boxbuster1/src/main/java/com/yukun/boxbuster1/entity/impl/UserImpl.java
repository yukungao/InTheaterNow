package com.yukun.boxbuster1.entity.impl;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.UserPurchasesHistory;

public class UserImpl implements User{
	private long id;
	
	private String firstname;
	
	private String lastname;
	
	private Address address;
	
	private String pin;
	
	private long credicardnumber;
	
	private List<UserPurchasesHistory> userPurchasesHistory;
	
	public UserImpl(){}

	
	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public long getCredicardnumber() {
		return credicardnumber;
	}

	public void setCredicardnumber(long credicardnumber) {
		this.credicardnumber = credicardnumber;
	}

	public List<UserPurchasesHistory> getUserPurchasesHistory() {
		return userPurchasesHistory;
	}

	public void addUserPurchasesHistory(UserPurchasesHistory userPurchasesHistory) {
		if(this.userPurchasesHistory == null) {
			this.userPurchasesHistory = new ArrayList<UserPurchasesHistory>();
		}
		this.userPurchasesHistory.add(userPurchasesHistory);
	}	
	
	
	
}
