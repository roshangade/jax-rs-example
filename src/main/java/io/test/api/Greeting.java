package io.test.api;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Requests to '/greeting' are going to serve in JSON format
 */
@Path("greeting")
@Produces(MediaType.APPLICATION_JSON)
public class Greeting {

	/**
	 * Create JSON object with "Hello World!" message 
	 */
	private final JsonObject message = Json.createObjectBuilder().add("message", "Hello World").build();

	/**
	 * @return message in JSON format
	 */
	@GET
	public Response getMessage() {
		return Response.status(Response.Status.OK).entity(message).build();
	}
}
