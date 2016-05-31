package com.yukun.boxbuster1.service;

import java.util.List;

import com.yukun.boxbuster1.entity.Movie;

public interface MovieService {
	long addMovie(Movie movie);

	Movie getMovieByTitle(String title);

	Movie getMovieByImdbRate(float iMDBRating);

	Movie getMovieByGenre(String genre);
	
	Movie getMovieById(long id);
	
	List<Movie> getAllMovies();

	void update(Movie movie);
}
