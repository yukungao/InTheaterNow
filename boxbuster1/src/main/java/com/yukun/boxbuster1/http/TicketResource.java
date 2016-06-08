package com.yukun.boxbuster1.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yukun.boxbuster1.entity.Ticket;
import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.impl.TicketImpl;
import com.yukun.boxbuster1.http.entity.HttpTicket;
import com.yukun.boxbuster1.service.MovieService;
import com.yukun.boxbuster1.service.PurchaseService;
import com.yukun.boxbuster1.service.TheaterService;
import com.yukun.boxbuster1.service.TicketService;
import com.yukun.boxbuster1.service.UserService;

@Path("tickets")
@Component
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })


public class TicketResource {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	@POST
	@Path("/")
	public Response createTicket(HttpTicket httpTicket) {
		Ticket ticketToCreate = convert(httpTicket);
		long added_id = ticketService.addTicket(ticketToCreate);
		Ticket newTicket = ticketService.getTicketById(added_id);
		return Response.status(Status.CREATED).header("Location", "/tickets/" + added_id)
				.entity(new HttpTicket(newTicket)).build();
	}
	
	
	@GET
	@Path("/userid={userid}/moviename={moviename}/theatername={theatername}")
	public Response buyTicket(@PathParam("userid") long userid, @PathParam("moviename") String moviename, @PathParam("theatername") String theatername) {
		User user = userService.getUser(userid);
		String resp = purchaseService.buyTicket(moviename, theatername,"", user);
		return null;
	}
	
	private Ticket convert(HttpTicket httpTicket) {
		TicketImpl ticket = new TicketImpl();
		ticket.setPrice(httpTicket.price);
		ticket.setStatus(httpTicket.status);
		ticket.setMovie(movieService.getMovieById(httpTicket.movieId));
		ticket.setTheater(theaterService.getTheaterById(httpTicket.theaterId));

		return ticket;
	}
}
