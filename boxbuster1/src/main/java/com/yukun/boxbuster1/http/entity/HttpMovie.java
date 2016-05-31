package com.yukun.boxbuster1.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.yukun.boxbuster1.entity.Movie;

@XmlRootElement(name = "movie")
public class HttpMovie {

	@XmlElement
	public long id;
	
	@XmlElement
	public String title;
	
	//Required by framework
	protected HttpMovie() {}
	
	public HttpMovie(Movie movie){
		this.id = movie.getId();
		this.title = movie.getTitle();
	}
}
