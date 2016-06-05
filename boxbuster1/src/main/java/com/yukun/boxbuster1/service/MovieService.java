package com.yukun.boxbuster1.service;

import java.util.List;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.utils.Genres;
import com.yukun.boxbuster1.utils.Ratings;

public interface MovieService {
	long addMovie(Movie movie);

	List<Movie> getMovieByTitle(String title);

	List<Movie> getMovieByImdbRate(double iMDBRating);
	
	List<Movie> getMovieByRate(Ratings rating);
	
	List<Movie> getMovieByGenre(Genres genre);
	
	Movie getMovieById(long id);
	
	List<Movie> getAllMovies();

	void update(Movie movie);
}
