package com.yukun.test_bbox;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TestTheaterResource {
	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "bar/rest/theaters";

	private Client client = ClientBuilder.newClient();
	private WebTarget target;

	@Before
	public void init() {
		target = client.target(HTTP_HOST).path(URI_PATH);
	}

	@Test
	public void testaddAndGet() {
		HttpTheater theaterToSend = new HttpTheater();
		theaterToSend.name = "Cinemark";
		theaterToSend.seats = 1;

		Response response = target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(theaterToSend, MediaType.APPLICATION_JSON));

		HttpTheater createResponse = response.readEntity(HttpTheater.class);
		// System.err.println(createResponse);
		Assert.assertEquals(200, response.getStatus());
		Assert.assertEquals(createResponse.name, theaterToSend.name);
		Assert.assertEquals(createResponse.seats, theaterToSend.seats);
		Assert.assertNotNull(createResponse.id);
	}

}
