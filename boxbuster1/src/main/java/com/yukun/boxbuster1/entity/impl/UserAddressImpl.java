package com.yukun.boxbuster1.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.User;

@Entity
@Table(name = "user_address")

public class UserAddressImpl implements Address{
	
	@Id
	@Column(name = "iduser_address")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zipCode")
	private String zipCode;
	
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity=UserImpl.class)
	@JoinColumn(name="users_idusers")
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
