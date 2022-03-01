package fsd.spring.showroom.exceptions;

import fsd.spring.showroom.hibernate.entities.ErrorPayload;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
//this will called when any exception will arise.
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorPayload error = new ErrorPayload(500,"Internal Server Error");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}
	

}
