package com.kramer.contactTracker.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kramer.contactTracker.models.User;

public interface UserRepo extends JpaRepository<User, Long> {

	@Query("FROM User WHERE email=?1 AND password=?2")
	Optional<User> login(String email, String password);
	
	@Query("FROM User WHERE email=?1")
	Optional<User> findByEmail(String email);
}
