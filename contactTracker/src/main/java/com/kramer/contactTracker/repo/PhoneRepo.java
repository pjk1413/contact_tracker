package com.kramer.contactTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kramer.contactTracker.models.PhoneNumber;

public interface PhoneRepo extends JpaRepository<PhoneNumber, Long> {

}
