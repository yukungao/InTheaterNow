package com.yukun.boxbuster1.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.impl.MovieImpl;
import com.yukun.boxbuster1.http.entity.HttpMovie;
import com.yukun.boxbuster1.service.MovieService;

@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource {
	@Autowired
	private MovieService movieService;
	
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
	
	
	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setTitle(httpMovie.title);
		return movie;
	}
	
	
	
}
