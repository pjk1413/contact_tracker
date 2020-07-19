package com.kramer.contactTracker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kramer.contactTracker.models.User;
import com.kramer.contactTracker.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserRepo userRepo;
	
	@PostMapping("/login")
	public Long login(@RequestParam String email, @RequestParam String password) {
		
		if(userRepo.login(email, password) != null) {
			//Current token is the user id, will need to have more data transfered over
			return userRepo.findByEmail(email).get().getId();
		} else {
			//Return of -1 means that the password or email was incorrect
			return (long) -1;
		}
	}
	
	@PostMapping("/password")
	public String changePassword(@RequestParam String email, @RequestParam String password) {
		return null;
	}
	
	@PostMapping("/edit")
	public User editUser(@RequestBody User user) {
		
	}

}