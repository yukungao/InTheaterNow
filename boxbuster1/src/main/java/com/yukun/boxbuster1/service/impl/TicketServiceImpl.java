package com.yukun.boxbuster1.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.impl.TicketImpl;
import com.yukun.boxbuster1.repository.TicketRepository;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.service.TheaterService;
import com.yukun.boxbuster1.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TheaterService theaterService;
	
	
	@Override
	public float createTicket(TicketImpl ticket) {
		ticketRepository.createTicket(ticket);
		// Need to generate confirmation info here?
		generateQRCode(ticket);
		return ticket.getId();
	}

	@Override
	public Ticket getTicketByMovie(Movie movie) {
		return ticketRepository.getTicketByMovie(movie);
	}

	@Override
	public Ticket getTicketByTheater(Theater theater) {
		return ticketRepository.getTicketByTheater(theater);
	}

	@Override
	public Ticket getTicketByMovieTime(Date time) {
		return ticketRepository.getTicketByMovieTime(time);
	}

	@Override
	public void update(Ticket ticket) {
		ticketRepository.update(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.getAllTickets();
	}

	
	private void generateQRCode(TicketImpl ticket) {
		UUID qrCode = UUID.randomUUID();
		ticket.setQRCode(qrCode);
	}
	
}
