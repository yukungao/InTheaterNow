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
import com.yukun.boxbuster1.entity.Theater;

@Entity
@Table(name="theater")
public class TheaterImpl implements Theater {
	@Id
	@Column(name = "idtheater")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "seats")
	private static int seats; 
	
	
	/*Theater maintain this relationship*/
	@OneToOne(fetch = FetchType.LAZY, targetEntity = TheaterAddressImpl.class)
	@JoinColumn(name = "theater_address_idtheater_address")
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
	
	@Override
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		 TheaterImpl.seats = seats;
	}
	
	
}
