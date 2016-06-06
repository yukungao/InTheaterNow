package com.yukun.boxbuster1.repository;

import java.util.Date;
import java.util.List;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;

public interface TicketRepository {
	long addTicket(Ticket ticket);
	
	List<Ticket> getTicketByMovie(Movie movie);
	
	//This one is for future restful usage
	List<Ticket> getTicketByMovieTitle(String movieTitle);
	
	List<Ticket> getTicketByTheater(Theater theater);
	
	//This one is for future restful usage
	List<Ticket> getTicketByTheaterName(String theaterName);
	
	//Don't know how to use this feature
	List<Ticket> getTicketByMovieTime(String time);
	
	//Get the exact tickets
	List<Ticket> searchExactTicket(String movieName, String theaterName, String time);
	
	//Get available tickets
	List<Ticket> getAvailableTicket(String movieName, String theaterName);
	
	Ticket getTicketById(long id);
	
	void update(Ticket ticket);
	
	List<Ticket> getAllTickets();
}
