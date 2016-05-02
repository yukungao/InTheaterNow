package com.yukun.boxbuster1.entity.impl;

import java.util.List;

import com.yukun.boxbuster1.entity.Movie;

public class MovieImpl implements Movie {
	
	private long id;
	private String title;
	private String genre;
	private Status movieStatus;
	private float iMDBRating;
	private List<String> movieCasts;
	
	public long getId() {
		
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		
		return this.genre;
	}
	
	public void setGenre(String genre) {
		
		this.genre = genre;
		
	}
	
	public List<String> getMovieCasts() {

		return this.movieCasts;
	}
	
	public void addToMovieCasts(String cast) {
		
	}
	
	public Status getMovieStatus() {
		
		return this.movieStatus;
	}
	
	public void setMovieStatus(Status status) {
		this.movieStatus = status;
	}
	
	
	public float getIMDBRating() {
		
		return this.iMDBRating;
	}
	
	public void setIMDBRating(float rating) {
		
		this.iMDBRating = rating;
	}
	
	
}
