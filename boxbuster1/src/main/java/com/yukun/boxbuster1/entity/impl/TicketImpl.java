package com.yukun.boxbuster1.entity.impl;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;

@Entity
@Table(name = "ticket")
public class TicketImpl implements Ticket {
	@Id
	@Column(name = "idticket")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private float price;
	@OneToOne(fetch = FetchType.EAGER, targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")
	private Movie movie;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity=TheaterImpl.class)
	@JoinColumn(name="theater_idtheater")
	private Theater theater;
	
	@Column(name = "time")
	private Date movieTime;
	
	@Column(name = "qrcode")
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
