package com.yukun.boxbuster1.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.yukun.boxbuster1.entity.Address;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.impl.UserAddressImpl;
import com.yukun.boxbuster1.repository.UserAddressRepository;

@Repository
public class UserAddressRepositoryImpl implements UserAddressRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long addAddress(Address address) {
		return (long) this.sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public Address getAddressById(long addressId) {
		return (Address) this.sessionFactory.getCurrentSession().get(UserAddressImpl.class, addressId);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> searchAddressByZip(String zip) {
		
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(UserAddressImpl.class);
		if (!StringUtils.isEmpty(zip)) {
			crit.add(Restrictions.like("zip", "%" + zip + "%"));
		}
		List<Address> searchResult = crit.list();
		return searchResult;
		
	}

	@Override
	public void update(Address address) {
		this.sessionFactory.getCurrentSession().update(address);
	}

	@Override
	public List<User> getUserbyZip(String zip) {
		
		List<Address> searchResult = searchAddressByZip(zip);
		List<User> userList = new ArrayList<User>();
		
		for(Address element : searchResult) {
			userList.add( ((UserAddressImpl) element).getUser() );

		}
		// TODO Auto-generated method stub
		return userList;
	}
}
