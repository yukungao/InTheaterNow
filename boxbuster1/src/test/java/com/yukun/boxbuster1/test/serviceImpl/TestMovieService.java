package com.yukun.boxbuster1.test.serviceImpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.impl.MovieImpl;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.utils.Genres;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestMovieService extends AbstractJUnit4SpringContextTests {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MovieService movieService;

	@Test
	public void addAndGetMovie() {
		MovieImpl newMovie = new MovieImpl();
		newMovie.setTitle("CaptainAmerica");
		newMovie.setGenre(Genres.ACTION);

		long added_id = movieService.addMovie(newMovie);
		logger.info("movie added " + added_id);
		Movie added = movieService.getMovieById(added_id);
		
	}
	
	@Test
	public void getAllMovie() {
		List<Movie> allMovie = movieService.getAllMovies();
		for(Movie element : allMovie) {
			System.out.println(element.toString());
		}
		
	}
	
	@Test
	public void getMovieByTitle() {
		List<Movie> movies = movieService.getMovieByTitle("CaptainAmerica");
		for(Movie element : movies) {
			System.out.println(element.toString());
		}
		//System.out.println(movie.getTitle());
	}	
	
	@Test
	public void getMovieByGenre() {
		List<Movie> movies = movieService.getMovieByGenre(Genres.ACTION);
		for(Movie element : movies) {
			System.out.println(element.toString());
		}
		//System.out.println(movie.getTitle());
	}
	
	
}

