package io.test.api.utils.exceptions;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MalformedBody implements ExceptionMapper<JsonParsingException> {

	private JsonObject error = Json
			.createObjectBuilder()
			.add("error", "Malformed body")
			.add("code", 102)
			.build();

	public Response toResponse(JsonParsingException e) {
		// malformed body
		return Response
				.status(Response.Status.BAD_REQUEST)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}

}
