package com.yukun.test_bbox;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;

public class TestMovieResource {
	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "boxbuster1/rest/movies";
	
	
	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}
	
	@Test
	public void testAddAndGetMovie() {
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieName = "XMEN";
		movieToSend.genre = Genres.ANNIMATION;
		movieToSend.rating = Ratings.R1;

		Response response = target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));

		HttpMovie createResponse = response.readEntity(HttpMovie.class);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(createResponse.movieName, movieToSend.movieName);
		Assert.assertEquals(createResponse.genre, movieToSend.genre);

	}

}
