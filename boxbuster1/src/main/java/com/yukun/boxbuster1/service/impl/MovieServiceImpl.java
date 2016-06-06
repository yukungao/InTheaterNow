package com.yukun.boxbuster1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.repository.MovieRepository;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.utils.Genres;
import com.yukun.boxbuster1.utils.Ratings;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public long addMovie(Movie movie) {
		movieRepository.addMovie(movie);
		return movie.getId();
	}

	@Override
	public List<Movie> getMovieByTitle(String title) {
		return movieRepository.getMovieByTitle(title);
	}

	@Override
	public List<Movie> getMovieByGenre(Genres genre) {
		return movieRepository.getMovieByGenre(genre);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovies();
	}

	@Override
	public void update(Movie movie) {
		 movieRepository.update(movie);
	}

	@Override
	public Movie getMovieById(long id) {
		return movieRepository.getMovieById(id);
	}

	@Override
	public List<Movie> getMovieByImdbRate(double iMDBRating) {
		return movieRepository.getMovieByImdbRate(iMDBRating);
	}

	@Override
	public List<Movie> getMovieByRate(Ratings rating) {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByRating(rating);
	}

}
