package com.yukun.boxbuster1.service;

import java.util.List;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.utils.Genres;

public interface BrowseService {
	List<Movie> browseAllMovies();

	List<Theater> browseAllTheaters();

	List<Movie> getAllMoviesInTheater(Theater theater);

	List<Theater> getAllTheatersOfMovie(Movie movie);

	List<Movie> getMovieByTitle(String title);
	
	//Filtering the movie by IMDB rating
	List<Movie> getMovieByImdbRate(double rate);

	List<Movie> getMovieByGenre(Genres genre);
	
	Theater getTheaterByName(String name);

	Theater getTheaterByAddress(Address address);
}
