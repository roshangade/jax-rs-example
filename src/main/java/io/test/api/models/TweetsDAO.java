package io.test.api.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import io.test.api.utils.Database;

@Singleton
public class TweetsDAO {

	@Inject
	private Database db;

	public JsonArray getTweets() throws SQLException {
		JsonArrayBuilder tweets = Json.createArrayBuilder();
		ResultSet rs = db.execute("SELECT * FROM tweets");
		while (rs.next()) {
			JsonObjectBuilder tweet = Json.createObjectBuilder();
			tweet.add("uid", rs.getString("uid"));
			tweet.add("tweet", rs.getString("tweet"));
			tweets.add(tweet.build());
		}
		return tweets.build();
	}

}
