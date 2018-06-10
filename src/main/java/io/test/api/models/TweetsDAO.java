package io.test.api.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import io.test.api.utils.Database;

@Singleton
public class TweetsDAO {

	@Inject
	private Database db;

	public JsonArray getTweets() throws SQLException {
		JsonArrayBuilder tweets = Json.createArrayBuilder();
		ResultSet rs = db.find("SELECT * FROM tweets");
		while (rs.next()) {
			JsonObjectBuilder tweet = Json.createObjectBuilder();
			//TODO: what if someone projects few fields
			tweet.add("uid", rs.getString("uid"));
			tweet.add("tweet", rs.getString("tweet"));
			tweets.add(tweet.build());
		}
		return tweets.build();
	}
	
	public void addTweet(JsonObject body) throws SQLException {
		//TODO: very poor, needs improvement
		ArrayList<Object> data = new ArrayList<>();
		data.add(body.getString("uid"));
		data.add(body.getString("tweet"));
		db.write("INSERT INTO tweets(uid, tweet) VALUES (?, ?)", data);
	}

}
