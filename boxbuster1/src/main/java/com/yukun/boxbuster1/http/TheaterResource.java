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

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yukun.boxbuster1.entity.Movie;
import com.yukun.boxbuster1.entity.Theater;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.http.entity.HttpMovie;
import com.yukun.boxbuster1.http.entity.HttpTheater;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.service.TheaterService;
import com.yukun.boxbuster1.service.TicketService;
import com.yukun.boxbuster1.service.UserService;

@Path("/theaters")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TheaterResource {
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private TicketService ticketService;

	@Autowired
	private UserService userService;
	
	@POST
	@Path("/")
	public Response createTheater(HttpTheater newTheater) {
		return null;
		
	}
	
	@GET
	@Path("/{theaterId}")
	public HttpTheater getTheaterById(@PathParam("theaterId") long theaterId) {
		Theater theater = theaterService.getTheaterById(theaterId);
		return new HttpTheater(theater);
	}
	
	
	@GET
	@Path("/")
	@Wrapped(element = "theaters")
	public List<HttpTheater> getAllTheaters(@QueryParam("all") long yes) {
		
		List<Theater> res = theaterService.getAllTheaters();
		List<HttpTheater> returnList = new ArrayList<>(res.size());
		if(yes == 1) {
			for (Theater theater : res) {
				returnList.add(new HttpTheater(theater));
			}
		}
		return returnList;
	}
	
	
	@GET
	@Path("/title={title}")
	public List<HttpTheater> getTheaterByTitle(@PathParam("title") String title) {
		System.out.println("The title passed in is"+title);
		List<Theater> res = theaterService.getTheaterByName(title);
		List<HttpTheater> returnList = new ArrayList<>(res.size());
		for (Theater theater : res) {
				returnList.add(new HttpTheater(theater));
		}
		return returnList;
	}
	
	@GET
	@Path("/zip={zip}")
	public List<HttpTheater> getTheaterByZipCode(@PathParam("zip") String zip) {
		System.out.println("The title passed in is"+zip);
		List<Theater> res = theaterService.getTheaterByZip(zip);
		List<HttpTheater> returnList = new ArrayList<>(res.size());
		for (Theater theater : res) {
				returnList.add(new HttpTheater(theater));
		}
		return returnList;
	}
	
	@GET
	@Path("/username={username}")
	public List<HttpTheater> getTheaterNearUser(@PathParam("username") String username) {
		User user_obj = userService.getUserByName(username,"");
		String zip = user_obj.getAddress().getZipCode();
		List<Theater> res = theaterService.getTheaterByZip(zip);
		List<HttpTheater> returnList = new ArrayList<>(res.size());
		for (Theater theater : res) {
				returnList.add(new HttpTheater(theater));
		}
		return returnList;
	}
	
	@GET
	@Path("/movie={movie}")
	@Wrapped(element = "theaters")
	public List<HttpTheater> getAllMovieInTheater(@PathParam("movie") String movie) {
		List<Theater> found = ticketService.searchTheatersByMovieName(movie);
		List<HttpTheater> returnList = new ArrayList<>(found.size());
		for (Theater theater : found) {
			returnList.add(new HttpTheater(theater));
		}
		return returnList;
	}
	
}
