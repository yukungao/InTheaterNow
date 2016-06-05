package com.yukun.boxbuster1.repository;

import java.util.List;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.utils.Genres;
import com.yukun.boxbuster1.utils.Ratings;

public interface MovieRepository {
	long addMovie(Movie movie);

	List<Movie> getMovieByTitle(String name);

	List<Movie> getMovieByImdbRate(double iMDBRating);

	List<Movie> getMovieByRating(Ratings rating);
	
	List<Movie> getMovieByGenre(Genres genre);

	Movie getMovieById(long id);
	
	List<Movie> getAllMovies();
	
	void update(Movie movie);
}
