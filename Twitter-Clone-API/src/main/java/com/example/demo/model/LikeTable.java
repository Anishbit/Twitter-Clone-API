package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LikeTable {
	@Id
	@GeneratedValue
	private int likeID;
	private int tweetID;
	private int userID;

	public LikeTable() {
	}

	public LikeTable(int likeID, int tweetID, int userID) {
		super();
		this.likeID = likeID;
		this.tweetID = tweetID;
		this.userID = userID;
	}

	public int getLikeID() {
		return likeID;
	}

	public void setLikeID(int likeID) {
		this.likeID = likeID;
	}

	public int getTweetID() {
		return tweetID;
	}

	public void setTweetID(int tweetID) {
		this.tweetID = tweetID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
