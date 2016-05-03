package com.yukun.boxbuster1.entity.impl;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;

public class TheaterImpl implements Theater {
	private long id;
	private String name;
	private Address address;
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
