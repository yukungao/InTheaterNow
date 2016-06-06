package com.yukun.boxbuster1.service;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.utils.Genres;

public interface BrowseService {
	
	
	List<Movie> browseAllMovies();
	List<Movie> getMovieByTitle(String title);
	
	//Filtering the movie by IMDB rating
	List<Movie> getMovieByImdbRate(double rate);

	List<Movie> getMovieByGenre(Genres genre);
	
	

	//Get movies in theater
	List<Movie> getAllMoviesInTheater(Theater theater);
	List<Movie> getAllMoviesInTheater(String theaterName);

	//Get theater that has such movie
	List<Theater> getAllTheatersOfMovie(Movie movie);
	List<Theater> getAllTheatersOfMovie(String movieName);
	
	
	
	List<Theater> browseAllTheaters();
	List<Theater> getTheaterByName(String name);
	Theater getTheaterByAddress(Address address);
	
	//List all the theaters with some zip code
	List<Theater> getTheaterByZip(String zip);
}
