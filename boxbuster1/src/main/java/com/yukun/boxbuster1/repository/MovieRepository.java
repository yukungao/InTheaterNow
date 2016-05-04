package com.yukun.boxbuster1.repository;

import java.util.List;

import com.yukun.boxbuster1.entity.Movie;

public interface MovieRepository {
	long addMovie(Movie movie);

	Movie getMovieByTitle(String name);

	Movie getMovieByRate(float iMDBRating);

	Movie getMovieByGenre(String genre);

	List<Movie> getAllMovies();

	void update(Movie movie);
}
