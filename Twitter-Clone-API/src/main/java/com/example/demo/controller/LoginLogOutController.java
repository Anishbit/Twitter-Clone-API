package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@RestController
public class LoginLogOutController {
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/login/")
	public String login(@RequestBody User user, HttpSession session) {
		User currentUserDetails = userRepo.findByUserName(user.getUserName());
		if(currentUserDetails == null) {
			return "User not found";
			
		}else {
			boolean isPasswordMatched = BCrypt.checkpw(user.getPassword(), currentUserDetails.getPassword());
			if(isPasswordMatched) {
				session.setAttribute("currentUser", currentUserDetails);
				return "You are Successfully Logged In";
			}
		}
		return "Incorrect Credentials.";	
	}
	
	@PostMapping("/logout/")
	public String logout(HttpSession session) {
		session.setAttribute("currentUser", null);
		return "Logged Out";
	}
}
