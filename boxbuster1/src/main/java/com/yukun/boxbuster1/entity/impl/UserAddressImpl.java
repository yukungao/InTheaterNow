package com.yukun.boxbuster1.entity.impl;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.User;

public class UserAddressImpl implements Address{
	private long id;
	private String number;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	private User user;
	
	@Override
	public String getNumber() {
		return number;
	}
	
	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getState() {
		return state;
	}
	
	@Override
	public String getZipCode() {
		return zipCode;
	}
	
	public User getUser() {
		return user;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
