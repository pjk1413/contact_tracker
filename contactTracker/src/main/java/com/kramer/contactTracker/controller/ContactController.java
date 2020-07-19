package com.kramer.contactTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kramer.contactTracker.models.Address;
import com.kramer.contactTracker.models.Contact;
import com.kramer.contactTracker.models.Event;
import com.kramer.contactTracker.models.PhoneNumber;
import com.kramer.contactTracker.models.User;
import com.kramer.contactTracker.repo.AddressRepo;
import com.kramer.contactTracker.repo.ContactRepo;
import com.kramer.contactTracker.repo.EventRepo;
import com.kramer.contactTracker.repo.PhoneRepo;
import com.kramer.contactTracker.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:3000") //not for deployment
@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private EventRepo eventRepo;
	
	@Autowired
	private PhoneRepo phoneRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ContactRepo contactRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@PostMapping("/edit")
	private void editUser(@RequestBody Contact contact) {
		contactRepo.findById(contact.getId()).ifPresent(editContact -> {
			if (contact.getFirstName() != null) {
				editContact.setFirstName(contact.getFirstName());
			}
			
			if (contact.getLastName() != null) {
				editContact.setLastName(contact.getLastName());
			}
			
			if (contact.getEmail() != null) {
				editContact.setEmail(contact.getEmail());
			}
		});
		
	}
	
	//Add Address to Contact
	@PostMapping("/address")
	private void addAddress(@RequestBody Address address, @RequestParam Long id) {
		Contact tempContact = contactRepo.findById(id).get();
		address.setContact(tempContact);
		addressRepo.save(address);
	}
	
	//Remove address from contact
	@PostMapping("/removeAddress")
	private void removeAddress(@RequestParam Long id) {
		addressRepo.deleteById(id);
	}
	
	//Add PhoneNumber to Contact
	@PostMapping("/phone")
	private void addPhoneNumber(@RequestBody PhoneNumber phoneNumber, @RequestParam Long id) {
		Contact tempContact = contactRepo.findById(id).get();
		phoneNumber.setContact(tempContact);
		phoneRepo.save(phoneNumber);
	}
	
	//Remove PhoneNumber from contact
	@PostMapping("/removePhone")
	private void removePhoneNumber(@RequestParam Long id) {
		phoneRepo.deleteById(id);
	}
	
	//Add Contact to User
	@PostMapping("/addContact")
	private void addContactToUser(@RequestBody Contact contact, @RequestParam Long id) {
		User tempUser = userRepo.findById(id).get();
		contact.setUser(tempUser);
		contactRepo.save(contact);
	}
	
	//Remove Contact from User
	@PostMapping("/removeContact")
	private void removeContactFromUser(@RequestParam Long id) {
		contactRepo.deleteById(id);
	}
	
	//Add Event to Contact
	@PostMapping("/event")
	private void addEventToContact(@RequestBody Event event, @RequestParam Long id) {
		Contact tempContact = contactRepo.findById(id).get();
		event.setContact(tempContact);
		eventRepo.save(event);
	}
	
	//Remove Event from Contact
	@PostMapping("/removeEvent")
	private void removeEventFromContact(@RequestParam Long id) {
		eventRepo.deleteById(id);
	}
	
	
	
}
