package com.yukun.boxbuster1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.service.BrowseService;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.service.TheaterService;
import com.yukun.boxbuster1.service.TicketService;
import com.yukun.boxbuster1.utils.Genres;

@Service
@Transactional
public class BrowseServiceImpl implements BrowseService {
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TheaterService theaterService;
	
	
	@Override
	public List<Movie> browseAllMovies() {
		// Call the movieService
		return movieService.getAllMovies();
	}

	@Override
	public List<Theater> browseAllTheaters() {
		// TODO Auto-generated method stub
		return theaterService.getAllTheaters();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getAllMoviesInTheater(Theater theater) {
		// TODO Auto-generated method stub
		return (List<Movie>) ticketService.getTicketByTheater(theater);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getAllTheatersOfMovie(Movie movie) {
		// TODO Auto-generated method stub
		return (List<Theater>) ticketService.getTicketByMovie(movie);
	}

	@Override
	public List<Movie> getMovieByTitle(String title) {
		return movieService.getMovieByTitle(title);
	}

	@Override
	public List<Movie> getMovieByImdbRate(double rate) {
		return movieService.getMovieByImdbRate(rate);
	}

	@Override
	public List<Movie> getMovieByGenre(Genres genre) {
		return movieService.getMovieByGenre(genre);
	}

	@Override
	public Theater getTheaterByName(String name) {
		return theaterService.getTheaterByName(name);
	}

	@Override
	public Theater getTheaterByAddress(Address address) {
		return theaterService.getTheaterByAddress(address);
	}

}
