package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Tweet {
	@Id
	@GeneratedValue
	private int tweetID;
	private String tweet;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	private Date tweetDateTime;

	public Tweet(int tweetID, String tweet, User user, Date tweetDateTime) {
		super();
		this.tweetID = tweetID;
		this.tweet = tweet;
		this.user = user;
		this.tweetDateTime = tweetDateTime;
	}

	public Tweet() {

	}

	public int getTweetID() {
		return tweetID;
	}

	public void setTweetID(int tweetID) {
		this.tweetID = tweetID;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {

		this.tweet = tweet;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTweetDateTime() {
		return tweetDateTime;
	}

	public void setTweetDateTime(Date tweetDateTime) {
		this.tweetDateTime = tweetDateTime;
	}

}
