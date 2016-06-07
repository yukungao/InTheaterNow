package com.yukun.boxbuster1.test.serviceImpl;

import org.junit.Assert;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.impl.TicketImpl;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.service.TheaterService;
import com.yukun.boxbuster1.service.TicketService;


@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestTicketService  extends AbstractJUnit4SpringContextTests {
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TheaterService theaterService;
	
	//First to test generate tickets
	@Test
	public void testPopulateTicketService() {
		List<Movie> movies = movieService.getAllMovies();
		List<Theater> theaters = theaterService.getAllTheaters();
		populateTickets(movies, theaters);
	}
	

	private void populateTickets(List<Movie> movies, List<Theater> theaters) {
		for(Movie movie : movies) {
			for(Theater theater : theaters) {
				ticketService.createTickets(movie, theater, 10);
			}
		}
		
	}
	
	@Test
	public void getTicketsBydifferentMethond() {
		List<Ticket> res1 = ticketService.getTicketByMovieTitle("SILICONVALLEY");
		Assert.assertEquals(14, res1.size());
		
		List<Ticket> res2 = ticketService.getTicketByTheaterName("cinemark");
		Assert.assertEquals(14, res2.size());
		
		List<Movie> res3 = ticketService.searchMoviesByTheaterName("cinemark");
		
		Assert.assertEquals(2, res3.size());
		for(Movie movie : res3) {
			System.out.println(movie.toString());
		}
		
		List<Theater> res4 = ticketService.searchTheatersByMovieName("AngryBirds");
		Assert.assertEquals(1, res4.size());
		
		List<Movie> res5 = ticketService.searchMoviesByTheaterName("Harkins");
		Assert.assertEquals(1, res5.size());
		
	}
	
	@Test
	public void addTicketandGet() {
		
		//This is angry bird
		Movie movie = movieService.getMovieById(12);
		Assert.assertEquals("AngryBirds", movie.getTitle());
		
		//This is Harkins theater
		Theater theater = theaterService.getTheaterById(19);
		Assert.assertEquals("Harkins", theater.getName());
		
		//Create "AngryBird" @ "Harkins" with $100
		TicketImpl ticket = new TicketImpl();
		ticket.setMovie(movie);
		ticket.setTheater(theater);
		ticket.setPrice(100);
		
		long added_id = ticketService.addTicket(ticket);
		TicketImpl ticket2 = (TicketImpl) ticketService.getTicketById(added_id);
		
		Assert.assertEquals(ticket2.getMovie().getTitle(), ticket.getMovie().getTitle());
		
	}
	
}
