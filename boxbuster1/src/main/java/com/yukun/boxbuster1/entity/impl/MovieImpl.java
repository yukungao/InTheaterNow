package com.yukun.boxbuster1.entity.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yukun.boxbuster1.entity.Movie;
@Entity
@Table(name = "movie")
public class MovieImpl implements Movie {
	@Id
	@Column(name = "idmovie")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "iMDBRating")
	private float iMDBRating;
	
	//private List<String> movieCasts;
	
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
	public String toString() {
		return "MovieImpl [id=" + id + ", title=" + title + ", genre=" + genre + ", iMDBRating=" + iMDBRating + "]";
	}
	
	/*
	@Override
	public List<String> getMovieCasts() {
		return movieCasts;
	}
	public void setMovieCasts(List<String> movieCasts) {
		this.movieCasts = movieCasts;
	}
	*/
	
}
