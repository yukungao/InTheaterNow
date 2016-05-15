package com.yukun.boxbuster1.repository.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public long createTicket(Ticket ticket) {
		return (long) this.sessionFactory.getCurrentSession().save(ticket);
	}

	@Override
	public Ticket getTicketByMovie(Movie movie) {
		return (Ticket) this.sessionFactory.getCurrentSession().get(TicketImpl.class, (Serializable) movie);
	}

	@Override
	public Ticket getTicketByTheater(Theater theater) {
		return (Ticket) this.sessionFactory.getCurrentSession().get(TicketImpl.class, (Serializable) theater);
	}

	@Override
	public Ticket getTicketByMovieTime(Date time) {
		return (Ticket) this.sessionFactory.getCurrentSession().get(TicketImpl.class, (Serializable) time);
	}

	@Override
	public void update(Ticket ticket) {
		this.sessionFactory.getCurrentSession().update(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Ticket.class);
		List<Ticket> searchResult = crit.list();
		return searchResult;
	}
	
}
