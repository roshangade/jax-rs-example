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

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Singleton
public class TweetsDAO {
	
	SessionFactory sf = null;
	Session s = null;

	@Inject
	private Database db;
	
	public TweetsDAO() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public List<Tweet> getTweetsFromHibernate() {
		List<Tweet> tweets = null;
		try {
			s = sf.openSession();
			s.beginTransaction();
			tweets = s.createQuery("from Tweet").getResultList();
			// = query.list();
		} catch (Exception e) {
			System.out.println("xxxxxxxxxx :::::: " + e.getMessage());
		} finally {
			s.close();
		}
		return tweets;
	}

	public JsonArray getTweets() throws SQLException {
		JsonArrayBuilder tweets = Json.createArrayBuilder();
		ResultSet rs = db.find("SELECT * FROM tweets");
		while (rs.next()) {
			JsonObjectBuilder tweet = Json.createObjectBuilder();
			// TODO: what if someone projects few fields
			tweet.add("uid", rs.getString("uid"));
			tweet.add("tweet", rs.getString("tweet"));
			tweets.add(tweet.build());
		}
		return tweets.build();
	}

	public void addTweet(JsonObject body) throws SQLException {
		// TODO: very poor, needs improvement
		System.out.println("=====>>>> " + body + body.getString("date"));
		ArrayList<Object> data = new ArrayList<>();
		data.add(body.getString("uid"));
		data.add(body.getString("tweet"));
		data.add(body.getString("date"));
		data.add(body.getInt("likes"));
		db.write("INSERT INTO tweets(uid, tweet, likes, Date) VALUES (?, ?, ?, ?)", data);
	}

}
