package com.yukun.boxbuster1.repository.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.impl.TicketImpl;
import com.yukun.boxbuster1.repository.TicketRepository;

@Repository
public class TicketRepositoryImpl implements TicketRepository{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long addTicket(Ticket ticket) {
		return (Long) this.sessionFactory.getCurrentSession().save(ticket);
	}

	// Get the Ticket By Movie Object
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketByMovie(Movie movie) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class);
		if (!StringUtils.isEmpty(movie)) {
			crit.add(Restrictions.eq("movie", movie));
		}
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketByMovieTitle(String movieTitle) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class);
		if (!StringUtils.isEmpty(movieTitle)) {
			crit.add(Restrictions.eq("movie.title", movieTitle));
		}
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketByTheater(Theater theater) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class);
		if (!StringUtils.isEmpty(theater)) {
			crit.add(Restrictions.eq("theater", theater));
		}
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketByTheaterName(String theaterName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class);
		if (!StringUtils.isEmpty(theaterName)) {
			crit.add(Restrictions.eq("theater.name", theaterName));
		}
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketByMovieTime(String time) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class);
		crit.add(Restrictions.eq("movieTime", time));
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}

	@Override
	public List<Ticket> searchExactTicket(String movieName, String theaterName, String time) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class);
		//
		if (!StringUtils.isEmpty(time)) {
			crit.add(Restrictions.like("time", "%" + time + "%"));
		}
		if (!StringUtils.isEmpty(theaterName)) {
			crit.add(Restrictions.eq("theater.theaterName", theaterName));
		}
		if (!StringUtils.isEmpty(movieName)) {
			crit.add(Restrictions.eq("movie.movieName", movieName));
		}
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}

	@Override
	public Ticket getTicketById(long id) {
		return (Ticket) this.sessionFactory.getCurrentSession().get(TicketImpl.class, id);
	}

	@Override
	public void update(Ticket ticket) {
		this.sessionFactory.getCurrentSession().update(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class);
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}

	
}
