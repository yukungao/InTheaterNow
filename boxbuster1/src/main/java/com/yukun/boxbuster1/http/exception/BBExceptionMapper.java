package com.yukun.boxbuster1.http.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.yukun.boxbuster1.service.exception.BBException;


@Provider
@Component
public class BBExceptionMapper implements ExceptionMapper<BBException>{

	@Override
	public Response toResponse(BBException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}

}