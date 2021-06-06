package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Tweet;
import com.example.demo.model.User;
import com.example.demo.repository.TweetRepo;

@RestController
public class CreatePostController {

	@Autowired
	private TweetRepo tweetRepo;

	@PostMapping("/createPost")
	public String createPost(@Valid @RequestBody Tweet tweetObj, Errors errors, HttpSession session) throws Exception {
		if (session.getAttribute("currentUser") == null) {
			return "You are not Logged In";
		}
		if (tweetObj.getTweet().length() > 140) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Your tweet cannot contain more than 140 characters.");
		}
		tweetObj.setUser((User) (session.getAttribute("currentUser")));
		tweetObj.setTweetDateTime(new Date());
		tweetRepo.save(tweetObj);
		return "You have Successfully Created a Tweet";

	}
}
