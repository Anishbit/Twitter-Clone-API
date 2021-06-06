package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Follow {
	@Id
	@GeneratedValue
	private int followID;
	private int followerId;
	private int userId;

	public int getFollowID() {
		return followID;
	}

	public void setFollowID(int followID) {
		this.followID = followID;
	}

	public Follow() {

	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Follow(int followID, int followerId, int userId) {
		super();
		this.followID = followID;
		this.followerId = followerId;
		this.userId = userId;
	}

}