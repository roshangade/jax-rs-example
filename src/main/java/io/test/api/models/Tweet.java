package io.test.api.models;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tweets")
public class Tweet {
	
	@Id
	@Column(name="uid")
	private String uid;
	
	@Column(name="tweet")
	private String tweet;
	
	/*@Column(name="likes")
	private int likes;*/
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	/*public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}*/
	
}
