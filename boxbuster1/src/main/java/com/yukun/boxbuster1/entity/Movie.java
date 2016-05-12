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
	
	//For filtering by Rating
	float getIMDBRating();

}
