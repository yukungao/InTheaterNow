package com.yukun.boxbuster1.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.impl.TheaterImpl;
import com.yukun.boxbuster1.repository.TheaterRepository;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long addTheater(Theater theater) {
		return (long) this.sessionFactory.getCurrentSession().save(theater);
	}

	@Override
	public Theater getTheaterByName(String name) {
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, name);
	}

	@Override
	public Theater getTreaterByAddress(Address address) {
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, (Serializable) address);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Theater> getAllTheaters() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Theater.class);
		List<Theater> searchResult = crit.list();
		return searchResult;
	}

	@Override
	public void update(Theater theater) {
		this.sessionFactory.getCurrentSession().update(theater);
	}

}
