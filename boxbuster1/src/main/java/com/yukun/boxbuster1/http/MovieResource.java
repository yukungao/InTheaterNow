package com.yukun.boxbuster1.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.impl.MovieImpl;
import com.yukun.boxbuster1.http.entity.HttpMovie;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.service.TicketService;
import com.yukun.boxbuster1.service.exception.BBException;
import com.yukun.boxbuster1.utils.Genres;

@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource {
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TicketService ticketService;
	
	@POST
	@Path("/")
	public Response createMovie(HttpMovie newMovie) {
		Movie movieToCreate = convert(newMovie);
		long addedMovieId = movieService.addMovie(movieToCreate);
		Movie addedMovie = movieService.getMovieById(addedMovieId);
		return Response.status(Status.CREATED).header("Loctation", "/movies/"+addedMovieId).entity(new HttpMovie(addedMovie)).build();
	}
	
	@GET
	@Path("/{movieId}")
	public HttpMovie getMovieById(@PathParam("movieId") long movieId) {
		Movie movie = movieService.getMovieById(movieId);
		return new HttpMovie(movie);
	}
	
	
	@GET
	@Path("/title={title}")
	public List<HttpMovie> getMovieByTitle(@PathParam("title") String title) {
		System.out.println("The title passed in is"+title);
		List<Movie> res = movieService.getMovieByTitle(title);
		List<HttpMovie> returnList = new ArrayList<>(res.size());
		for (Movie movie : res) {
				returnList.add(new HttpMovie(movie));
		}
		return returnList;
	}
	
	@GET
	@Path("/")
	@Wrapped(element = "movies")
	public List<HttpMovie> getAllMovie(@QueryParam("all") long yes) {
		
		List<Movie> res = movieService.getAllMovies();
		List<HttpMovie> returnList = new ArrayList<>(res.size());
		if(yes == 1) {
			for (Movie movie : res) {
				returnList.add(new HttpMovie(movie));
			}
		}
		return returnList;
	}
	
	
	@GET
	@Path("/genre={genre}")
	@Wrapped(element = "movies")
	public List<HttpMovie> getAllMovieByGenre(@PathParam("genre") String genre) {
		List<Movie> found = movieService.getMovieByGenre(Genres.valueOf(genre));
		List<HttpMovie> returnList = new ArrayList<>(found.size());
		for (Movie movie : found) {
			returnList.add(new HttpMovie(movie));
		}
		return returnList;
	}
	
	@GET
	@Path("/theater={theater}")
	@Wrapped(element = "movies")
	public List<HttpMovie> getAllMovieInTheater(@PathParam("theater") String theater) {
		List<Movie> found = ticketService.searchMoviesByTheaterName(theater);
		List<HttpMovie> returnList = new ArrayList<>(found.size());
		for (Movie movie : found) {
			returnList.add(new HttpMovie(movie));
		}
		return returnList;
	}
	
	
	
	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setTitle(httpMovie.title);
		return movie;
	}
	
	
	
}
