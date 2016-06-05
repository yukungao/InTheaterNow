package com.yukun.boxbuster1.entity;

import java.util.List;
import com.yukun.boxbuster1.utils.Genres;
import com.yukun.boxbuster1.utils.Ratings;

public interface Movie {
	// Id as the primary key
	long getId();
	
	
	// Basic info to support retrieve by
	// Title, Genre, MovieCast
	String getTitle();
	Genres getGenre();
	Ratings getRating();
	
	//For filtering by Rating
	double getIMDBRating();

}
