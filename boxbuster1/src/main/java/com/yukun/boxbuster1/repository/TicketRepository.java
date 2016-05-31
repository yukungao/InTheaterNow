package com.yukun.boxbuster1.repository;

import java.util.Date;
import java.util.List;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;

public interface TicketRepository {
	long createTicket(Ticket ticket);
	
	Ticket getTicketByMovie(Movie movie);
	
	Ticket getTicketByTheater(Theater theater);
	
	Ticket getTicketByMovieTime(Date time);
	
	void update(Ticket ticket);
	
	List<Ticket> getAllTickets();
}
