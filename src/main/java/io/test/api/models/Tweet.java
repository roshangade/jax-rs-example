package io.test.api.models;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name="tweets")
public class Tweet {
	
	@Id
	@Column(name="uid")
	@NotNull
	@Size(min=8,max=32)
	@DefaultValue("aaaaaaaaaa")
	private String uid = "sssss";
	
	@Column(name="tweet")
	@NotNull
	@Size(min=1, max=160)
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
