package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Follow;
import com.example.demo.model.User;
import com.example.demo.repository.FollowRepo;
import com.example.demo.repository.UserRepo;

@RestController
public class FollowController {
	@Autowired
	FollowRepo followRepo;
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/follow/{followerName}")
	public String follow(@PathVariable String followerName, HttpSession session ) {
		if(session.getAttribute("currentUser")==null) {
			return "You are not Logged In";
		}else {
			Follow follow = new Follow();
			follow.setUserId(((User)(session.getAttribute("currentUser"))).getUserID());
			User foloweeId = userRepo.findByUserName(followerName);
			follow.setFollowerId(foloweeId.getUserID());
			followRepo.save(follow);
			return "You are following "+followerName;
		}
	}
}
