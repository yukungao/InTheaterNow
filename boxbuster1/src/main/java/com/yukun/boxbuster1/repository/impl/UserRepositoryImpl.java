package com.yukun.boxbuster1.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.impl.UserImpl;
import com.yukun.boxbuster1.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long addUser(User user) {
		return (Long) this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUser(long userId) {
		return (User) this.sessionFactory.getCurrentSession().get(UserImpl.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> search(String firstName, String lastName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		if (!StringUtils.isEmpty(firstName)) {
			crit.add(Restrictions.like("firstname", "%" + firstName + "%"));
		}
		if (!StringUtils.isEmpty(lastName)) {
			crit.add(Restrictions.like("lastname", "%" + lastName + "%"));
		}
		List<User> searchResult = crit.list();
		return searchResult;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(user);
	}
}
