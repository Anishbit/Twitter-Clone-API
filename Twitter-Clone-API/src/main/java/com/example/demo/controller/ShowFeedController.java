package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Follow;
import com.example.demo.model.Tweet;
import com.example.demo.model.User;
import com.example.demo.repository.FollowRepo;
import com.example.demo.repository.TweetRepo;
import com.example.demo.repository.UserRepo;

@RestController
public class ShowFeedController {
	@Autowired
	FollowRepo followRepo;

	@Autowired
	TweetRepo tweetRepo;

	@Autowired
	UserRepo userRepo;

	@GetMapping("/showFeeds/")
	public Object showFeed(HttpSession session) {
		User user = ((User) (session.getAttribute("currentUser")));
		if (user == null) {
			return "You are not Logged In";
		} else {
			int userId = user.getUserID();
			ArrayList<Follow> followTable = followRepo.findAllByUserId(userId);
			Set<Integer> allFollower = new HashSet<>();
			for (Follow f : followTable) {
				allFollower.add(f.getFollowerId());
			}

			ArrayList<Tweet> allTweet = new ArrayList<>();
			for (Integer i : allFollower) {
				// get all tweets
				allTweet.addAll(tweetRepo.findAllByUser(userRepo.findByUserID(i)));
			}

			ArrayList<Map<String, String>> finalList = new ArrayList<>();

			for (Tweet t : allTweet) {
				Map<String, String> hm = new HashMap<String, String>();
				hm.put("TweetID ", (Integer.toString(t.getTweetID())));
				hm.put("Tweet ", t.getTweet());
				hm.put("Created On ", t.getTweetDateTime().toString());
				hm.put("Created By ", t.getUser().getUserName());
				finalList.add(hm);
			}
			return finalList;
		}
	}
}
