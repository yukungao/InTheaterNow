package com.yukun.boxbuster1.entity.impl;
import java.util.Date;
import java.util.UUID;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;

public class TicketImpl implements Ticket {
	
	private long id;
	private float price;
	private Movie movie;
	private Theater theater;
	private Date movieTime;
	private UUID qrCode;
	
	@Override
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	@Override
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	@Override
	public Date getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(Date movieTime) {
		this.movieTime = movieTime;
	}
	
	@Override
	public UUID getQRCode() {
		return qrCode;
	}

	public void setQRCode(UUID qrCode) {
		this.qrCode = qrCode;
	}
	
}
