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
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.impl.TheaterAddressImpl;
import com.yukun.boxbuster1.repository.TheaterAddressRepository;

@Repository
public class TheaterAddressRepositoryImpl implements TheaterAddressRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long addAddress(Address address) {
		return (long) this.sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public Address getAddressById(long addressId) {
		return (Address) this.sessionFactory.getCurrentSession().get(TheaterAddressImpl.class, addressId);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> searchAddressByZip(String zip) {
		
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterAddressImpl.class);
		if (!StringUtils.isEmpty(zip)) {
			crit.add(Restrictions.like("zipCode", "%" + zip + "%"));
		}
		List<Address> searchResult = crit.list();
		return searchResult;
		
	}

	@Override
	public void update(Address address) {
		this.sessionFactory.getCurrentSession().update(address);
	}

	@Override
	public List<Theater> getTheaterbyZip(String zip) {
		// TODO Auto-generated method stub
		List<Address> searchResult = searchAddressByZip(zip);
		List<Theater> theaterList = new ArrayList<Theater>();
		
		for(Address element : searchResult) {
			theaterList.add( ((TheaterAddressImpl) element).getTheater());
		}
		
		return theaterList;
	}
	
}
