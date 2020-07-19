package com.kramer.contactTracker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kramer.contactTracker.models.Contact;
import com.kramer.contactTracker.models.User;
import com.kramer.contactTracker.repo.ContactRepo;
import com.kramer.contactTracker.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:3000") //not for deployment
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ContactRepo contactRepo;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PostMapping("/login")
	public Long login(@RequestParam String email, @RequestParam String password) {
		System.out.println(email);
		System.out.println(password);
		if(userRepo.login(email, password) != null) {
			//Current token is the user id, will need to have more data transfered over
			return userRepo.findByEmail(email).get().getId();
		} else {
			//Return of -1 means that the password or email was incorrect
			return (long) -1;
		}
	}
	
	@PostMapping("/remove")
	public String removeUser(@RequestParam String email, @RequestParam String password) {
		long id = userRepo.login(email, password).get().getId();
		userRepo.deleteById(id);
		return "User " + email + " deleted";
	}
	
	
	@PostMapping("/password")
	public String changePassword(@RequestParam String email, @RequestParam String password) {
		//will send an email and a link to change password in the future
		return null;
	}
	
	@PostMapping("/email")
	public void changeEmail(@RequestBody User user) {
		
		userRepo.findById(user.getId()).ifPresent(editUser -> {
			if(user.getEmail() != null) {
				editUser.setEmail(user.getEmail());
			}
		});
	}
	
	//currently removes any data that isn't present in the user
	@PostMapping("/name")
	public void changeName(@RequestBody User user) {
		userRepo.findById(user.getId()).ifPresent(editUser -> {
			if(user.getFirstName() != null) {
				editUser.setFirstName(user.getFirstName());
			}
			
			if(user.getLastName() != null) {
				editUser.setLastName(user.getLastName());
			}
		});
	}
	
//	@PostMapping("/addContact")
//	public void addContact(@RequestBody Contact contact, @RequestParam Long id) {
//	
//		userRepo.findById(id).ifPresent(user -> {
//			List<Contact> tempList = user.getContactList();
//			tempList.add(contact);
//			user.setContactList(tempList);
//		});
//	}
	
	@PostMapping("/removeContact")
	public void removeContact(@RequestBody Contact contact, @RequestParam Long id) {
		userRepo.findById(id).ifPresent(user -> {
			user.removeContact(contact);
		});
	}
	
	@PostMapping("/find")
	public User findUserById(@RequestParam Long id) {
		User user = userRepo.findById(id).get();
		user.setPassword("");
		return user;
	}

}
