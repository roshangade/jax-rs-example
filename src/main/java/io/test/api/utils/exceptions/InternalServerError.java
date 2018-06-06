package io.test.api.utils.exceptions;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalServerError implements ExceptionMapper<Throwable> {

	private JsonObject error = Json
			.createObjectBuilder()
			.add("message", "Internal server error")
			.add("code", 100)
			.build();
	
	public Response toResponse(Throwable e) {
		//TODO: log error message
		return Response
				.status(Response.Status.INTERNAL_SERVER_ERROR)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}
}
