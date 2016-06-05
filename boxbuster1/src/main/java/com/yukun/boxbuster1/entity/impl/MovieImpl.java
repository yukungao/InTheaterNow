package com.yukun.boxbuster1.entity.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.utils.Genres;
import com.yukun.boxbuster1.utils.Ratings;
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
	@Enumerated(EnumType.STRING)
	private Genres genre;
	
	@Column(name = "iMDBRating")
	private double iMDBRating;
	
	@Column(name = "rating")
	@Enumerated(EnumType.STRING)
	private Ratings rating;
	
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
	public Genres getGenre() {
		return genre;
	}
	public void setGenre(Genres genre) {
		this.genre = genre;
	}
	@Override
	public double getIMDBRating() {
		return iMDBRating;
	}
	public void setIMDBRating(double iMDBRating) {
		this.iMDBRating = iMDBRating;
	}
	
	@Override
	public String toString() {
		return "MovieImpl [id=" + id + ", title=" + title + ", genre=" + genre + ", iMDBRating=" + iMDBRating + "]";
	}
	
	@Override
	public Ratings getRating() {
		// TODO Auto-generated method stub
		return rating;
	}
	
	public void setRating(Ratings rating) {
		// TODO Auto-generated method stub
		this.rating = rating;
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
