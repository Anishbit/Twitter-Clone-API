package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.LikeTable;
import com.example.demo.model.User;
import com.example.demo.repository.LikeRepo;

@RestController
public class LikePostController {
	@Autowired
	LikeRepo likeRepo;
	
	@PostMapping("/like/{tweetId}")
	public String likeTweet(HttpSession session, @PathVariable String tweetId) {
		if(session.getAttribute("currentUser")==null) {
			return "You are not Logged In";
		}else {
			LikeTable liketable = new LikeTable();
			liketable.setTweetID(Integer.valueOf(tweetId));
			liketable.setUserID(((User)session.getAttribute("currentUser")).getUserID());
			likeRepo.save(liketable);
			return "You Liked This Post";
		}
	}
}
