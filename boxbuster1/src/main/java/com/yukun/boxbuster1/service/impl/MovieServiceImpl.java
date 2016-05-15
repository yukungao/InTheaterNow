package com.yukun.boxbuster1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.repository.MovieRepository;
import com.yukun.boxbuster1.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public long addMovie(Movie movie) {
		movieRepository.addMovie(movie);
		return movie.getId();
	}

	@Override
	public Movie getMovieByTitle(String title) {
		return movieRepository.getMovieByTitle(title);
	}

	@Override
	public Movie getMovieByImdbRate(float iMDBRating) {
		return movieRepository.getMovieByRate(iMDBRating);
	}

	@Override
	public Movie getMovieByGenre(String genre) {
		return movieRepository.getMovieByGenre(genre);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovies();
	}

	@Override
	public void update(Movie movie) {
		// TODO Auto-generated method stub
		 movieRepository.update(movie);
	}

}
