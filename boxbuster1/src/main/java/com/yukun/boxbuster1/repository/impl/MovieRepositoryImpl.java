package com.yukun.boxbuster1.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.impl.MovieImpl;
import com.yukun.boxbuster1.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return (long) this.sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public Movie getMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, title) ;
	}

	@Override
	public Movie getMovieByRate(float iMDBRating) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, iMDBRating);
	}

	@Override
	public Movie getMovieByGenre(String genre) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, genre);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Movie.class);
		List<Movie> searchResult = crit.list();
		return searchResult;
	}

	@Override
	public void update(Movie movie) {
		this.sessionFactory.getCurrentSession().update(movie);
		
	}
}
