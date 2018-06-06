package io.test.api;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.test.api.models.TweetsDAO;

@Path("/tweets")
@Produces(MediaType.APPLICATION_JSON)
public class Tweets {
	
	@Inject
	private TweetsDAO tweets;
	
	@GET
	public Response getTweets() {
		JsonObjectBuilder res = Json.createObjectBuilder();
		try {
			//TODO: query part
			res.add("tweets", tweets.getTweets());
		} catch(Exception e) {
			throw new InternalServerErrorException();
		}
		return Response
				.status(Response.Status.OK)
				.entity(res.build())
				.build();
	}
}
