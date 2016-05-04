package com.yukun.boxbuster1.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yukun.boxbuster1.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
}
