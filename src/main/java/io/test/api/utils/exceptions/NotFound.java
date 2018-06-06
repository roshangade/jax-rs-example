package io.test.api.utils.exceptions;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFound implements ExceptionMapper<NotFoundException> {

	private JsonObject error = Json
			.createObjectBuilder()
			.add("error", "Not found")
			.add("code", 101)
			.build();

	public Response toResponse(NotFoundException e) {
		return Response
				.status(Response.Status.NOT_FOUND)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}

}
