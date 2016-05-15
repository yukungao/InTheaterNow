package com.yukun.boxbuster1.service;

import java.sql.Date;
import java.util.List;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.impl.TicketImpl;

public interface TicketService {
	float createTicket(TicketImpl ticket);

	Ticket getTicketByMovie(Movie movie);

	Ticket getTicketByTheater(Theater theater);

	Ticket getTicketByMovieTime(Date time);

	void update(Ticket ticket);

	List<Ticket> getAllTickets();
}
