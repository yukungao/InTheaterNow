package com.yukun.boxbuster1.entity.impl;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.UserPurchasesHistory;

@Entity
@Table(name = "ticket")
public class TicketImpl implements Ticket {
	@Id
	@Column(name = "idticket")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "price")
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=TheaterImpl.class)
	@JoinColumn(name="theater_idtheater")
	private Theater theater;
	
	@OneToOne(targetEntity = UserPurchasesHistoryImpl.class, cascade = CascadeType.ALL, mappedBy = "ticket")
	private UserPurchasesHistory userPurchasesHistory;
	
	@Column(name = "time")
	private String movieTime;
	
	@Column(name = "qrcode")
	private String qrCode;
	
	@Column(name = "status")
	private boolean status;
	
	@Override
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
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
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	
	@Override
	public String getQRCode() {
		return qrCode;
	}

	public void setQRCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@Override
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
