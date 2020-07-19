package com.kramer.contactTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kramer.contactTracker.models.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}
