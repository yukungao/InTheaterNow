package com.yukun.boxbuster1.http.entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.yukun.boxbuster1.entity.Ticket;


@XmlRootElement(name = "ticket")
public class HttpTicket {
	@XmlElement
	public long id;

	@XmlElement
	public long movieId;

	@XmlElement
	public long theaterId;

	@XmlElement
	public double price;

	@XmlElement
	public boolean status;
	
	protected HttpTicket() {
	}

	public HttpTicket(Ticket ticket) {
		this.id = ticket.getId();
		this.movieId = ticket.getMovie().getId();
		this.theaterId = ticket.getTheater().getId();
		this.price = ticket.getPrice();
		this.status = ticket.getStatus();
	}
	
}
