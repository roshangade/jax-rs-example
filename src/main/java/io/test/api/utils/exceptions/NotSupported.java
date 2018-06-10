package io.test.api.utils.exceptions;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotSupported implements ExceptionMapper<NotSupportedException> {

	private JsonObject error = Json
			.createObjectBuilder()
			.add("error", "Not supported")
			.add("code", 103)
			.build();

	
	public Response toResponse(NotSupportedException e) {
		//TODO: log error message
		return Response
				.status(Response.Status.UNSUPPORTED_MEDIA_TYPE)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}
	
}
