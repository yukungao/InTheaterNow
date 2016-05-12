package com.yukun.boxbuster1.entity.impl;

import java.util.List;

import com.yukun.boxbuster1.entity.Movie;

public class MovieImpl implements Movie {
	
	private long id;
	private String title;
	private String genre;
	private float iMDBRating;
	private List<String> movieCasts;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public float getIMDBRating() {
		return iMDBRating;
	}
	public void setIMDBRating(float iMDBRating) {
		this.iMDBRating = iMDBRating;
	}
	
	@Override
	public List<String> getMovieCasts() {
		return movieCasts;
	}
	public void setMovieCasts(List<String> movieCasts) {
		this.movieCasts = movieCasts;
	}
	
}
