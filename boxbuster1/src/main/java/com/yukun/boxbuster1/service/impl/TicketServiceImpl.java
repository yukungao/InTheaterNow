package com.yukun.boxbuster1.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.transaction.Transactional;

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
@Transactional
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketRepository ticketRepository;
	
	private void generateQRCode(Ticket ticket) {
		String qrCode = new String("code" + new Random().nextLong());
		((TicketImpl) ticket).setQRCode(qrCode);
	}

	@Override
	public long addTicket(Ticket ticket) {
		//Need to generate bar-code for this ticket
		generateQRCode(ticket);
		return ticketRepository.addTicket(ticket);
	}

	@Override
	public List<Ticket> getTicketByMovie(Movie movie) {
		return ticketRepository.getTicketByMovie(movie);
	}


	@Override
	public List<Ticket> getTicketByMovieTitle(String movieTitle) {
		return ticketRepository.getTicketByMovieTitle(movieTitle);
	}


	@Override
	public List<Ticket> getTicketByTheater(Theater theater) {
		return ticketRepository.getTicketByTheater(theater);
	}


	@Override
	public List<Ticket> getTicketByTheaterName(String theaterName) {
		return ticketRepository.getTicketByTheaterName(theaterName);
	}



	@Override
	public List<Ticket> getTicketByMovieTime(String time) {
		return ticketRepository.getTicketByMovieTime(time);
	}

	@Override
	public List<Ticket> searchExactTicket(String movieName, String theaterName, String time) {
		return ticketRepository.searchExactTicket(movieName, theaterName, time);
	}


	@Override
	public Ticket getTicketById(long id) {
		return ticketRepository.getTicketById(id);
	}


	@Override
	public void update(Ticket ticket) {
		ticketRepository.update(ticket);
	}


	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.getAllTickets();
	}

	@Override
	public List<Movie> searchMoviesByTheaterName(String theaterName) {
		List<Movie> movieList = new ArrayList<Movie>();

		List<Ticket> tickets = ticketRepository.getTicketByTheaterName(theaterName);
		for (Ticket t : tickets) {
			if (!movieList.contains(t.getMovie())) {
				movieList.add(t.getMovie());
			}
		}
		return movieList;
	}

	@Override
	public List<Theater> searchTheatersByMovieName(String movieName) {
		List<Theater> theaterList = new ArrayList<Theater>();

		List<Ticket> tickets = ticketRepository.getTicketByMovieTitle(movieName);
		for (Ticket t : tickets) {
			if (!theaterList.contains(t.getTheater())) {
				theaterList.add(t.getTheater());
			}
		}
		return theaterList;
	}

	@Override
	public List<Ticket> searchAvailabeTicket(String movieName, String theaterName) {
		return ticketRepository.getAvailableTicket(movieName, theaterName);
	}

	@Override
	public List<Ticket> createTickets(Movie movie, Theater theater, double price) {
		int numberofSeats = theater.getSeats();
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		//Create the tickets based on the capacity of theater
		while(numberofSeats/4 > 0) {
			
			Ticket currTicket = new TicketImpl();
			((TicketImpl) currTicket).setMovie(movie);
			((TicketImpl) currTicket).setTheater(theater);
			((TicketImpl) currTicket).setPrice(price);
			generateQRCode(currTicket);
			ticketRepository.addTicket(currTicket);
			tickets.add(currTicket);
			numberofSeats--;
		}
		
		return tickets;
	}
	
}
