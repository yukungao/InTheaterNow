package com.yukun.boxbuster1.service;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;

public interface BrowseService {
	List<Movie> browseAllMovies();

	List<Theater> browseAllTheaters();

	List<Movie> getAllMoviesInTheater(Theater theater);

	List<Theater> getAllTheatersOfMovie(Movie movie);

	Movie getMovieByTitle(String title);
	
	//Filtering the movie by IMDB rating
	Movie getMovieByImdbRate(float rate);

	Movie getMovieByGenre(String genre);
	
	Theater getTheaterByName(String name);

	Theater getTheaterByAddress(Address address);
}
