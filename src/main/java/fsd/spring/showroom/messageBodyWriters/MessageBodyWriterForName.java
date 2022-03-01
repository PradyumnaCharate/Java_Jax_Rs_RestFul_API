package fsd.spring.showroom.messageBodyWriters;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;

import fsd.spring.showroom.hibernate.entities.Name;



@Provider
@Produces(MediaType.TEXT_PLAIN)
public class MessageBodyWriterForName implements MessageBodyWriter<Name> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		
		return Name.class == type;
	}

	@Override
	public void writeTo(Name t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		
		entityStream.write(t.toString().getBytes());

	}

}
