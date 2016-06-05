package com.yukun.boxbuster1.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.impl.MovieImpl;
import com.yukun.boxbuster1.repository.MovieRepository;
import com.yukun.boxbuster1.utils.Genres;
import com.yukun.boxbuster1.utils.Ratings;

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
	public List<Movie> getMovieByTitle(String title) {
		// TODO Auto-generated method stub
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class)
				.add(Restrictions.eq("title", title));
		List<Movie> searchResult = crit.list();
		return searchResult;
	}

	
	
	
	@Override
	public List<Movie> getMovieByRating(Ratings rating) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class)
				.add(Restrictions.eq("rating", rating));
		List<Movie> searchResult = crit.list();
		return searchResult;
	}

	@Override
	public List<Movie> getMovieByGenre(Genres genre) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class)
				.add(Restrictions.eq("genre", genre));
		List<Movie> searchResult = crit.list();
		return searchResult;
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

	@Override
	public Movie getMovieById(long id) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, id);
	}

	@Override
	public List<Movie> getMovieByImdbRate(double iMDBRating) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class)
				.add(Restrictions.eq("iMDBRating", iMDBRating));
		List<Movie> searchResult = crit.list();
		return searchResult;
	}
}
