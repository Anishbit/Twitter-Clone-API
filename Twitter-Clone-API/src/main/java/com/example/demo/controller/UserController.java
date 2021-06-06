package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tweet;
import com.example.demo.model.User;
import com.example.demo.repository.TweetRepo;
import com.example.demo.repository.UserRepo;

@RestController
public class UserController {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TweetRepo tweetRepo;

	@PostMapping("/register")
	public String createUser(@RequestBody User user) {
		String password = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		String encodedPassword = encoder.encode(password);
		user.setPassword(encodedPassword);

		if (userRepo.save(user) == null) {
			return "Something Went Wrong";
		}
		return "Resgisterd Successfully";
	}

	@GetMapping("/search/{username}")
	public Object searchUser(@PathVariable String username, HttpSession session) {
		System.out.println("USERNAME: " + username);

		if (session.getAttribute("currentUser") == null) {
			return "You are not Logged In";
		} else {
			User foundUser = userRepo.findByUserName(username);
			Map<String, String> hm = new HashMap<>();
			hm.put("userName", foundUser.getUserName());
			hm.put("fullName", foundUser.getFullName());

			System.out.println("USERNAME: " + username);
			return hm;

		}
	}

	@GetMapping("/searchAllPost/{username}")
	public Object searchAllPost(@PathVariable String username, HttpSession session) {
		if (session.getAttribute("currentUser") == null) {
			return null;
		} else {
			User foundUser = userRepo.findByUserName(username);
			ArrayList<Tweet> al = tweetRepo.findAllByUser(foundUser);

			System.out.println("Lamba Bhata: " + al.size());
			HashMap<String, String> hm = new HashMap<>();
			for (Tweet tweet : al) {
				String tweetId = Integer.toString(tweet.getTweetID());
				String tweetContent = tweet.getTweet();
				hm.put("Tweet " + tweetId, tweetContent);
			}
			return hm;

		}
	}
}
