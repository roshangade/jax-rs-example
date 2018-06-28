package io.test.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.mapping.Collection;

import io.test.api.models.Tweet;
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
	
	@GET
	@Path("/all")
	public Response getTweetsFromHibernate() {
		Map<String, Object> _tweets = new HashMap<>();
		
		try {
			//TODO: query part
			_tweets.put("tweets", tweets.getTweetsFromHibernate()); 
			_tweets.put("count", tweets.getTweetsCount());
		} catch(Exception e) {
			throw new InternalServerErrorException();
		}
		return Response
				.status(Response.Status.OK)
				.entity(_tweets)
				.build();
	}
	
	@GET
	@Path("/single") // just for differentiate from old db connection
	public Response getTweetFromHibernate() {
		Map<String, Object> _tweets = new HashMap<>();
		
		try {
			//TODO: query part
			_tweets.put("tweet", tweets.getTweetFromHibernate()); 
			_tweets.put("metadata", "here is metadata");
		} catch(Exception e) {
			throw new InternalServerErrorException();
		}
		return Response
				.status(Response.Status.OK)
				.entity(_tweets)
				.build();
	}
	
	@POST
	@Path("/add") // just for differentiate from old db connection
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTweetFromHibernate(Tweet body) {
		//Map<String, Object> _tweets = new HashMap<>();
		
		try {
			//TODO: query part
			/*_tweets.put("tweet", tweets.getTweetFromHibernate()); 
			_tweets.put("metadata", "here is metadata");*/
			tweets.addTweetFromHibernate(body);
		} catch(Exception e) {
			System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPP "+e.getClass());
			//throw new ValidationException(e.getMessage());
			throw e;
		}
		return Response
				.status(Response.Status.CREATED)
				.entity(body)
				.build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTweet(JsonObject body) {
		JsonObjectBuilder res = Json.createObjectBuilder().add("message", "Tweet has been added successfully");
		try {
			//TODO: validate body
			tweets.addTweet(body);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new InternalServerErrorException();
		}
		return Response
				.status(Response.Status.CREATED)
				.entity(res.build())
				.build();
	}
}
