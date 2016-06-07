package com.yukun.boxbuster1.entity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.UserPurchasesHistory;

@Entity
@Table(name = "users")
public class UserImpl implements User{
	@Id
	@Column(name = "idusers")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@OneToOne(targetEntity=UserAddressImpl.class, optional=true, cascade=CascadeType.ALL, mappedBy="user")
	private Address address;
	
	@Column(name = "pin")
	private String pin;
	
	@Column(name = "balance")
	private double balance;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", targetEntity = UserPurchasesHistoryImpl.class, cascade = CascadeType.ALL)
	private List<UserPurchasesHistory> userPurchasesHistory;
	
	public UserImpl(){};

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getFirstName() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String getLastName() {
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
	
	@Override
	public double getBalance() {
		return balance;
	}

	
	public void setBalance(double d) {
		this.balance = d;
	}
	
	@Override
	public void costBalance(double price) {
		this.balance = balance - price;
	}
	
	@Override
	public List<UserPurchasesHistory> getUserPurchasesHistory() {
		return userPurchasesHistory;
	}

	@Override
	public void addUserPurchasesHistory(UserPurchasesHistory userPurchasesHistory) {
		if(this.userPurchasesHistory == null) {
			this.userPurchasesHistory = new ArrayList<UserPurchasesHistory>();
		}
		this.userPurchasesHistory.add(userPurchasesHistory);
	}
}
