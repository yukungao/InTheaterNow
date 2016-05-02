package com.yukun.boxbuster1.entity;

import java.util.List;

public interface Movie {
	// Id as the primary key
	long getId();
	
	// Basic info to support retrieve by
	// Title, Genre, MovieCast
	String getTitle();
	String getGenre();
	List<String> getMovieCasts();
	
	// Decide if it could be in movie Theater
	public enum Status{
		Not_Release,
		IN_Theatres,
		OUT_Theatres
	}
	
	Status getMovieStatus();
	
	//For filtering by Rating
	float getIMDBRating();

}
