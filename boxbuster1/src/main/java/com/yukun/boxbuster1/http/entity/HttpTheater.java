package com.yukun.boxbuster1.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;

@XmlRootElement(name = "theater")
public class HttpTheater {
	
	@XmlElement
	public long id;
	@XmlElement
	public String name;
	
	// Can't handle interface, how to solve it?
	//@XmlElement
	//public Address address;
	
	@XmlElement
	public int seats;
	
	protected HttpTheater() {}
	
	public HttpTheater(Theater theater) {
		this.id = theater.getId();
		this.name = theater.getName();
		//this.address = theater.getAddress();
		this.seats = theater.getSeats();
	}

}
